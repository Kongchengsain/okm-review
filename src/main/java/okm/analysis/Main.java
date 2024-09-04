package okm.analysis;

import okm.analysis.model.MNmap;
import okm.analysis.model.MProcess;
import okm.analysis.params.Params;
import okm.analysis.pocs.POCCatalog;
import okm.analysis.utils.UFileUtil;
import okm.analysis.utils.UIntroduce;
import okm.analysis.utils.UNmap;
import okm.analysis.utils.UStrUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        //指定poc
        String usePoc = "";
        //输入参数：IP地址
        String ip = "";
        //输入参数：IP地址文件
        String ip_file = "";
        //输入参数：nmap扫描的结果文件
        String nmapFile = "";
        //输出参数：存在漏洞的IP文件
        String ipOutFile = "";
        //所有进程的集合
        ArrayList<MProcess> processList = new ArrayList<>();
        //临时的poc文件路径
        String tempPOCFile = null;

        // 添加一个关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("检测到Ctrl+C，执行清理操作...");
            for (MProcess mProcess : processList) {
                mProcess.stop();
            }
        }));

        //解析各个输入参数
        for (int i = 0; i < args.length; i++) {

            if (Params.HELP.equals(args[i])) {

                //帮助文档
                System.out.println(UIntroduce.printLogo());
                System.out.println(UIntroduce.printHelp());
                return;
            }
            if (Params.VERSION.equals(args[i])) {

                //显示版本
                System.out.println(UIntroduce.printVersion());
                return;

            }
            if (Params.POC_LIST.equals(args[i])) {

                //显示支持的poc列表
                System.out.println(POCCatalog.printPOCList());
                return;

            }
            if (Params.USE_POC.equals(args[i])) {

                //使用指定的poc
                usePoc = args[i + 1];
            }
            if (Params.IP_OUT.equals(args[i])) {

                //输出文件路径
                ipOutFile = args[i + 1];
            }
            /**
             * 扫描IP源的顺序判定：IP地址 > IP地址文件 > nmap扫描的结果文件
             */
            if (Params.IP.equals(args[i])) {

                //优先获取输入的IP地址
                ip = args[i + 1];

            } else if (Params.IP_FILE.equals(args[i])) {

                //其次读取输入的IP地址文件
                ip_file = args[i + 1];

            } else if (Params.NMAP_RESULT.equals(args[i])) {

                //最后读取指定输入参数：nmap扫描的结果文件
                nmapFile = args[i + 1];
            }

        }

        //打印 logo
        System.out.println(UIntroduce.printLogo());
        System.out.println(UIntroduce.printScanning());

        //创建nmap集合
        ArrayList<MNmap> list = new ArrayList();

        if (!"".equals(ip)) {
            //使用IP生成nmap对象
            list.add(new MNmap(ip));

        } else if (!"".equals(ip_file)) {

            File file = new File(ip_file);

            if (!file.canRead()) {

                System.out.println("输入文件无法读取：" + ip_file);
                return;
            } else {

                //使用IP地址文件生成nmap对象
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    //加入IP地址
                    list.add(new MNmap(line));
                }
            }

        } else if (!"".equals(nmapFile)) {

            //读取外部文件,例：nmap扫描结果文件
            File file = new File(nmapFile);

            if (!file.canRead()) {
                System.out.println("输入文件无法读取：" + nmapFile);
                return;
            } else {

                //使用nmap扫描结果文件生成nmap对象
                BufferedReader reader = new BufferedReader(new FileReader(file));

                MNmap nmap = null;
                String line;

                //循环读取每一行
                while ((line = reader.readLine()) != null) {

                    //ip
                    if (line.startsWith("Nmap")) {
                        nmap = new MNmap();
                        nmap.ip = UNmap.findIp(line);
                    }
                    //135
                    if (line.startsWith("135") && nmap != null) {
                        nmap.p135 = UNmap.findP135(line);
                    }
                    //3389
                    if (line.startsWith("3389") && nmap != null) {
                        nmap.p3389 = UNmap.findP3389(line);
                        //将每一个nmap对象加入list
                        list.add(nmap);
                    }
                }
            }
        } else {

            System.out.println("未输入有效的源IP");
            return;
        }

        //指定poc
        if ("".equals(usePoc.trim())) {
            System.out.println("未指定poc");
            return;
        }

        //创建临时的poc工具
        if (POCCatalog.CVE_2024_38077.equals(usePoc)) {

            String exeFileName = "pocs/" + POCCatalog.CVE_2024_38077 + ".exe";
            // 目标目录，例如用户主目录下的ext文件夹
            String targetDir = System.getProperty("user.home") + File.separator + "ext";
            tempPOCFile = targetDir + File.separator + POCCatalog.CVE_2024_38077 + ".exe";

            //如果目标poc文件不存在，则复制到文件系统
            if (!UFileUtil.isExist(tempPOCFile)) {

                // 创建目标目录（如果不存在）
                Files.createDirectories(Paths.get(targetDir));

                // 读取resources目录下的exe文件
                InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(exeFileName);
                if (inputStream == null) {
                    throw new FileNotFoundException("Resource file " + exeFileName + " not found in the classpath");
                }

                // 构造目标文件的路径
                Path targetPath = Paths.get(tempPOCFile);

                // 将InputStream写入到文件系统的目标位置
                try (FileOutputStream outputStream = new FileOutputStream(targetPath.toFile())) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        //将临时的poc工具复制到文件系统
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        } else {
            System.out.println("暂不支持poc:" + usePoc);
            return;
        }

        //计数
        int count = 0;
        //循环执行exe工具，参数是nmap的IP，并逐个获取执行结果
        for (int i = 0; i < list.size(); i++) {

            MNmap nmap1 = list.get(i);

            //扫描的情况是，输入了IP（此时端口号均为空）、输入了nmap_file同时两个端口都是开放状态
            if (UStrUtil.isEmpty(nmap1.p3389) || ("open".equals(nmap1.p135) && "open".equals(nmap1.p3389))) {

                // 指定要执行的exe文件及其参数
                MProcess process = new MProcess(tempPOCFile, nmap1.ip);
                String result = process.scan();
                processList.add(process);

                if (result != null) {
                    //输出扫描结果
                    System.out.println(result);
                    if (result.contains("Vulnerability Detected")) {

                        //收集存在漏洞的IP 将扫描结果写入文件
                        if (!"".equals(ipOutFile)) {
                            UFileUtil.appendFile(result, ipOutFile);
                        }
                        //计数
                        count++;
                    }
                }
            }
        }

        System.out.println("Vulnerability total: " + count);

        //扫描完后删除poc工具
        UFileUtil.delFile(tempPOCFile);
    }

}
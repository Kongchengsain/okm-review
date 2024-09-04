package okm.analysis.model;

import okm.analysis.utils.UStrUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MProcess {

    private String pocFile;
    private String ip;
    private ProcessBuilder processBuilder;
    private Process process;

    public MProcess() {
    }

    public MProcess(String pocFile, String ip) {
        this.processBuilder = new ProcessBuilder(pocFile, ip);
    }

    public String scan() {

        try {
            // 启动进程
            this.process = this.processBuilder.start();
            // 读取标准输出
            BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String l;
            while ((l = r.readLine()) != null) {

                if (UStrUtil.isStartWithNum(l))
                    //返回以数字开头的执行结果，例： 69.3.65.182 Vulnerability Detected.
                    return l;
            }

            // 读取标准错误（如果需要）
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                System.out.println("Standard Error: " + errorLine);
            }

            // 等待外部程序执行完成
            int exitCode = process.waitFor();
            if (exitCode == 0) {
//                System.out.println("程序执行完成");
            } else {
                System.out.println("程序执行出错，退出码：" + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void stop() {
        if (this.process != null) {
            this.process.destroy();
        }
    }

}

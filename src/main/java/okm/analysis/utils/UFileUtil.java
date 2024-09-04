package okm.analysis.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UFileUtil {


    /**
     * 判断目标文件是否存在
     *
     * @param destFile file
     * @return bool
     */
    public static boolean isExist(String destFile) {

        return new File(destFile).exists();
    }

    /**
     * 写入文件 覆盖
     *
     * @param content  content
     * @param destFile 目标文件
     * @return bool
     */
    public static boolean writeFile(String content, String destFile) {

        try {
            // 创建目标文件
            File file = new File(destFile);
            if (!file.exists()) {
                file.createNewFile();
            }

            if (file.canWrite()) {

                // true表示追加，false表示覆盖
                FileWriter fw = new FileWriter(destFile, false);
                fw.write(content);
                fw.flush();

                return true;
            } else {

                System.out.println("目标文件不可写：" + destFile);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("目标文件写入错误：" + e.getStackTrace());
            return false;
        }
    }

    /**
     * 写入文件 追加
     *
     * @param content  content
     * @param destFile 目标文件
     * @return bool
     */
    public static boolean appendFile(String content, String destFile) {

        try {
            // 创建目标文件
            File file = new File(destFile);
            if (!file.exists()) {
                file.createNewFile();
            }

            if (file.canWrite()) {

                // true表示追加，false表示覆盖
                FileWriter fw = new FileWriter(destFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.newLine();
                bw.append(content);
                bw.flush();

                return true;
            } else {

                System.out.println("目标文件不可写：" + destFile);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("目标文件写入错误：" + e.getStackTrace());
            return false;
        }
    }

    public static void delFile(String tempPOCFile) {
        new File(tempPOCFile).delete();
    }

}

package okm.analysis.utils;

public class UNmap {

    /**
     * 从行中解析ip
     * @param line
     * @return ip
     */
    public static String findIp(String line) {

        String ip = "";
        String [] arr = line.split(" ");
        for (int i = 0;i < arr.length;i++) {
            if(arr[i].trim().length() > 6) {
                ip = arr[i];
            }
        }
        return ip;
    }

    /**
     * 从行中解析135端口的状态
     * @param line
     * @return p135
     */
    public static String findP135(String line) {

        String [] arr = line.split(" ");
        return arr[2];
    }

    /**
     * 从行中解析3389端口的状态
     * @param line
     * @return p3389
     */
    public static String findP3389(String line) {
        String [] arr = line.split(" ");
        return arr[1];
    }

}

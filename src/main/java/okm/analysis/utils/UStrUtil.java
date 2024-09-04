package okm.analysis.utils;

public class UStrUtil {

    public static boolean isEmpty (String str) {

        return null == str || "".equals(str) || "".equals(str.trim());
    }

    public static boolean isStartWithNum(String str) {
        return Character.isDigit(str.charAt(0));
    }

    public static void main(String[] args) {
        System.out.println(isStartWithNum("47.36.98 dfa"));
    }

}

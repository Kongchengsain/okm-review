package okm.analysis.pocs;

public class POCCatalog {

    public static String CVE_2024_38077= "CVE-2024-38077";

    public static String printPOCList () {

        StringBuilder builder = new StringBuilder();
        builder.append(CVE_2024_38077);

        return builder.toString();
    }

}

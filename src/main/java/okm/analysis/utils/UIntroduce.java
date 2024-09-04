package okm.analysis.utils;

public class UIntroduce {

    public static String printLogo() {
        StringBuilder builder = new StringBuilder();
        builder.append("Welcome to OKM-REVIEW.");
        builder.append("\n         —————  ——     ————        ——");
        builder.append("\n        |     ||  |  / /|   \\    /   |");
        builder.append("\n        |  |  ||  | / / |  | \\  / |  |");
        builder.append("\n        |  |  ||  |/ /  |  |  \\/  |  |");
        builder.append("\n        |  |  ||  |\\ \\  |  |  ——  |  |");
        builder.append("\n        |  |  ||  | \\ \\ |  |      |  |");
        builder.append("\n        |     ||  |  \\ \\|  |      |  |");
        builder.append("\n         —————  ——     ————        ——");
        return builder.toString();
    }

    public static String printScanning() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nstart scannning.");
        return builder.toString();
    }

    public static String printHelp() {
        printLogo();
        StringBuilder builder = new StringBuilder();
        builder.append("\nThis project is a tool that collects POCs, especially the. exe tool targeting specific vulnerabilities. This project connects users and specific tools through adhesive code, eliminating the hassle of searching and the shortcomings of the original tools.");
        builder.append("\nUsage：");
        builder.append("\n  -i    Input the target ip address like 192.168.1.1 or ip scope like 192.168.1.1/24");
        builder.append("\n  -v    Print the version of OKM");
        builder.append("\n  -if   Set an input file path which contains a lot of ip address arranged as one per line");
        builder.append("\n  -nf   Set an input file path that Nmap has scanned over and generated.Meanwhile,It's better to contain only two port which are 135 and 3389");
        builder.append("\n  -pl   Show all of the POCs currently included");
        builder.append("\n  -poc  Set a poc name when scanning,such as CVE-2024-38077");
        builder.append("\n  -of   Set an output file path which contains all of the vulnerable ips and will be generated when scanning over");
        builder.append("\n  -h    Show help document");
        return builder.toString();
    }

    public static String printVersion() {
        StringBuilder builder = new StringBuilder();
        builder.append("OKM-REVIEW Version 1.0");
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(printHelp());
    }

}

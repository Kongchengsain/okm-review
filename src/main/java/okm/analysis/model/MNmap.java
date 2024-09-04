package okm.analysis.model;

public class MNmap {

    public String ip;
    public String p135;
    public String p3389;

    public MNmap() {
    }

    public MNmap(String ip) {
        this.ip = ip;
    }

    public MNmap(String ip, String p135, String p3389) {
        this.ip = ip;
        this.p135 = p135;
        this.p3389 = p3389;
    }

}

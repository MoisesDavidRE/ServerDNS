import java.io.Serializable;

public class objetoDNS implements Serializable {

    private String host;
    private String dns;

//  Constructores
    public objetoDNS(String host, String dns) {
        this.host = host;
        this.dns = dns;
    }

    public objetoDNS() {}

// Métodos get
    public String getHost() {
        return host;
    }
    public String getDns() {
        return dns;
    }

// Métodos set
    public void setHost(String host) {
        this.host = host;
    }
    public void setDns(String dns) {
        this.dns = dns;
    }
}


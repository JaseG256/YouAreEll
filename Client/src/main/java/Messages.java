import sun.net.idn.StringPrep;

public class Messages extends Model{

    private String sequence;
    private String timestamp;
    private String fromid;
    private String toid;
    private String message;

    public Messages(String fromid, String toid, String message) {
        this.fromid = fromid;
        this.toid = toid;
        this.message = message;

    }

    public Messages(String fromid, String message) {
        this.fromid = fromid;
        this.toid = timestamp;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid;
    }

    @Override
    public String toString() {
        return fromid + ": " + toid + ": " + message + ": " + timestamp;
    }
}

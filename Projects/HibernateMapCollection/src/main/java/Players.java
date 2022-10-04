/**
 * @author Zulfa Attar
 */
public class Players {
    private int jno;
    private String name;
    private int bid_value;

    public Players() {
    }

    public Players(int jno, String name, int bid_value) {
        this.jno = jno;
        this.name = name;
        this.bid_value = bid_value;
    }


    public int getJno() {
        return jno;
    }

    public void setJno(int jno) {
        this.jno = jno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBid_value() {
        return bid_value;
    }

    public void setBid_value(int bid_value) {
        this.bid_value = bid_value;
    }
}

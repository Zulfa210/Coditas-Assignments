import java.util.Map;

/**
 * @author Zulfa Attar
 */
public class IPL_team_details {

    private int tid;
    private String team_name, owner_name;
    private Map<String, Players> players;

    public IPL_team_details(int tid, String team_name, String owner_name, Map<String, Players> players) {
        this.tid = tid;
        this.team_name = team_name;
        this.owner_name = owner_name;
        this.players = players;
    }

    public IPL_team_details() {
    }

    public IPL_team_details(int tid) {
        this.tid = tid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public Map<String, Players> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Players> players) {
        this.players = players;
    }
}

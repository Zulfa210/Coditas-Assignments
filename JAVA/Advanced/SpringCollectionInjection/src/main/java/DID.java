import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Zulfa Attar
 */
public class DID {
    private String seasonName;
    private List<String> brandPartners;

    private Map<Participants, String> participants;

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public List<String> getBrandPartners() {
        return brandPartners;
    }

    @Resource
    @Autowired
    public void setBrandPartners(List<String> brandPartners) {
        this.brandPartners = brandPartners;
    }

    public Map<Participants, String> getParticipants() {
        return participants;
    }
    public void setParticipants(Map<Participants, String> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "DID{" +
                "seasonName='" + seasonName + '\'' +
                ", brandPartners=" + brandPartners +
                ", participants=" + participants +
                '}';
    }


    public void display(){
        List<String> l = getBrandPartners();
        Map<Participants, String> m = getParticipants();
        System.out.println("Season Name: " + getSeasonName());
        System.out.println("Brand Partners: ");
        for (String list: l){
            System.out.println(list);
        }
        System.out.println("Participants: ");
        for(Map.Entry<Participants, String> m1: m.entrySet()){
            System.out.println( m1.getKey() + " Team: " + m1.getValue());
        }
    }

    DID(){}


}

/**
 * @author Zulfa Attar
 */
/**
 * @author Zulfa Attar
 */
public class Address {
    private String houseName, city,state;

    public Address(String houseName, String city, String state) {
        this.houseName = houseName;
        this.city = city;
        this.state = state;
    }

    Address(){

    }
    @Override
    public String toString() {
        return "Address{" +
                "houseName='" + houseName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}


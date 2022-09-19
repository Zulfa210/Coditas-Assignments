/**
 * @author Zulfa Attar
 */
public class Address {
    String streetName;
    String cityName;
    String stateName;
    int pincode;


    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Address(String streetName, String cityName, String stateName, int pincode) {
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.pincode = pincode;
    }

    public void display(){
        System.out.println("Street Name: " + getStreetName() +
                "\nCity Name: " + getCityName()+
                "\nState Name: " + getStateName() +
                "\nPincode: " + getPincode());
    }
}

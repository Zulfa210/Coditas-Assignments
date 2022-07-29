package week2.day8.Assignments;

public class Address {
    int House_no, Street_no;

    @Override
    public String toString() {
        return "Address{" +
                "House_no=" + House_no +
                ", Street_no=" + Street_no +
                ", street_name='" + street_name + '\'' +
                ", society_name='" + society_name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    String street_name, society_name, city, state;

    public Address(int house_no, int street_no, String street_name, String society_name, String city, String state) {
        House_no = house_no;
        Street_no = street_no;
        this.street_name = street_name;
        this.society_name = society_name;
        this.city = city;
        this.state = state;
    }
}

/**
 * @author Zulfa Attar
 */
public class Student {
    int id;
    String name;
    Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public void display(){

        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        getAddress().display();
    }

}

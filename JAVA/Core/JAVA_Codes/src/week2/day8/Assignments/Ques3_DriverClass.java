package week2.day8.Assignments;

//3). Create a class Medicine to represent a drug manufactured by a pharmaceutical company. Provide a function display Label()
// in this class to print Name and address of the company.
//Derive Tablet, Syrup and Ointment classes from the Medicine class.
//Override the displayLabel() function in each of these classes to print additional information
// suitable to the type of medicine.
//For example, in case of tablets, it could be "store in a cool dry place", in case of ointments
// it could be "for external use only" etc. Create a class TestMedicine. Write main function to do the following:
// Declare an array of Medicine references of size 10 Create a medicine object of the type as decided by a
// randomly generated integer in the range 1 to 3.
// Refer Java API Documentation to find out random generation features.
// Check the polymorphic behavior of the displayLabel() method.


import java.util.Random;

abstract class Medicine{
    String Company_name;
    Address add = new Address(12, 31, "dffs", " eewr", "sds", "sfsd");

    public Medicine(String company_name, Address address) {
        Company_name = company_name;
        this.address = address;
    }


    void displayLabel(){
         System.out.println("Company Name: " + Company_name);
         System.out.println("Address: " + address);
    }
}

class Tablet extends Medicine{
    public Tablet(String company_name, Address address) {
        super(company_name, address);
    }

    void displayLabel(){
        super.displayLabel();
        System.out.println("Store in a cool dry place");

    }

}

class Syrup extends Medicine{
    public Syrup(String company_name, Address address) {
        super(company_name, address);
    }

    void displayLabel(){
        super.displayLabel();
        System.out.println("Shake well before use");

    }

}

class Ointment extends Medicine{
    public Ointment(String company_name, Address address) {
        super(company_name, address);
    }

    void displayLabel(){
        super.displayLabel();
        System.out.println("For external use only");

    }
}

public class Ques3_DriverClass {
    public static void main(String[] args) {

        Medicine medicine[] = new Medicine[10];
        Random randomVariable = new Random();

        for(int i = 0; i < 10; i++){
            int type = randomVariable.nextInt(3);

            switch (type){
                case 0:
                   medicine[i] = new Tablet("Cipla", ;
                    break;

                case 1:
                   // medicine[i] = new Syrup();
                    break;

                case 2:
                   // medicine[i] = new Ointment();
                    break;
            }
        }

        for (int i = 0; i< medicine.length; i++){
            System.out.println(medicine[i]);
        }

    }
}

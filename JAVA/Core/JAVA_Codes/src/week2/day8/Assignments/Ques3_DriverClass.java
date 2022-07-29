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
    String Company_name = "Cipla";
    Address add = new Address(12, 31, "dffs", " eewr", "sds", "sfsd");
//creating address as aggregate class.


    void displayLabel(){
        System.out.println("-----------------------------------------------------");
         System.out.println("Company Name: " + Company_name);
         System.out.println("Address: " + add);
    }
}

class Tablet extends Medicine{


    void displayLabel(){
        super.displayLabel();
        System.out.println("Tablet: Store in a cool dry place");

    }

}

class Syrup extends Medicine{

    void displayLabel(){
        super.displayLabel();
        System.out.println("Syrup: Shake well before use");

    }

}

class Ointment extends Medicine{

    void displayLabel(){
        super.displayLabel();
        System.out.println("Ointment: For external use only");

    }
}

public class Ques3_DriverClass {
    public static void main(String[] args) {

        Medicine medicine[] = new Medicine[10];
        Random randomVariable = new Random();

        for(int i = 0; i < 10; i++){
            //generating random variable
            int type = randomVariable.nextInt(3);

            switch (type){
                case 0:
                   medicine[i] = new Tablet();
                    break;

                case 1:
                    medicine[i] = new Syrup();
                    break;

                case 2:
                   medicine[i] = new Ointment();
                    break;
            }
        }

        for (int i = 0; i< medicine.length; i++){
            medicine[i].displayLabel();
        }

    }
}

//output:
//-----------------------------------------------------
//Company Name: Cipla
//Address: Address{House_no=12, Street_no=31, street_name='dffs', society_name=' eewr', city='sds', state='sfsd'}
//Syrup: Shake well before use
//-----------------------------------------------------
//Company Name: Cipla
//Address: Address{House_no=12, Street_no=31, street_name='dffs', society_name=' eewr', city='sds', state='sfsd'}
//Tablet: Store in a cool dry place
//-----------------------------------------------------
//Company Name: Cipla
//Address: Address{House_no=12, Street_no=31, street_name='dffs', society_name=' eewr', city='sds', state='sfsd'}
//Ointment: For external use only
//-----------------------------------------------------
//Company Name: Cipla
//Address: Address{House_no=12, Street_no=31, street_name='dffs', society_name=' eewr', city='sds', state='sfsd'}
//Tablet: Store in a cool dry place
//-----------------------------------------------------
//Company Name: Cipla
//Address: Address{House_no=12, Street_no=31, street_name='dffs', society_name=' eewr', city='sds', state='sfsd'}
//Tablet: Store in a cool dry place
//-----------------------------------------------------
//Company Name: Cipla
//Address: Address{House_no=12, Street_no=31, street_name='dffs', society_name=' eewr', city='sds', state='sfsd'}
//Tablet: Store in a cool dry place
//-----------------------------------------------------
//Company Name: Cipla
//Address: Address{House_no=12, Street_no=31, street_name='dffs', society_name=' eewr', city='sds', state='sfsd'}
//Syrup: Shake well before use
//-----------------------------------------------------
//Company Name: Cipla
//Address: Address{House_no=12, Street_no=31, street_name='dffs', society_name=' eewr', city='sds', state='sfsd'}
//Tablet: Store in a cool dry place
//-----------------------------------------------------
//Company Name: Cipla
//Address: Address{House_no=12, Street_no=31, street_name='dffs', society_name=' eewr', city='sds', state='sfsd'}
//Ointment: For external use only
//-----------------------------------------------------
//Company Name: Cipla
//Address: Address{House_no=12, Street_no=31, street_name='dffs', society_name=' eewr', city='sds', state='sfsd'}
//Ointment: For external use only
//
//Process finished with exit code 0
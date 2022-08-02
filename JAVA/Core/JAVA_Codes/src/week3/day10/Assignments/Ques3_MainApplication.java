package week3.day10.Assignments;
//Q.3) Try to access private variables of class using reflection

import java.lang.reflect.*;

class Credit_card{
    public int card_no;
    public String card_type;
    private int cvv;

    public Credit_card(int card_no, String card_type, int cvv) {
        this.card_no = card_no;
        this.card_type = card_type;
        this.cvv = cvv;
    }
}

public class Ques3_MainApplication {

    public static void main(String[] args) throws Exception{

        //creating object
        Credit_card card1 = new Credit_card(122, "Platinum", 789);


        Class myclass= Class.forName("week3.day10.Assignments.Credit_card");

        //accessing private field using getDeclareField method and using class.setAccessible as true to access private fields
        Field myPrivateField = myclass.getDeclaredField("cvv");
        myPrivateField.setAccessible(true);

        //casting the accessed field into the required data type
        int cvv = (int)myPrivateField.get(card1);

        System.out.println("Value of private member is: "+ cvv);
    }
}
//output:
//Value of private member is: 789

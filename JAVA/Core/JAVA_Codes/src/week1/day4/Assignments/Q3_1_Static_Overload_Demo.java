package week1.day4.Assignments;

public class Q3_1_Static_Overload_Demo {

    public static void user_login(int mobileno, String email){
        System.out.println("You are logged in using both mobile no. and email id");
    }
    public static void user_login(int userID){
        System.out.println("You are logged in using mobile no.");
    }
    public static void user_login(String email){
        System.out.println("You are logged in using and email id");
    }

    //overloading static method user_login using 3 different signatures
    public static void main(String[] args) {
        int mobile_no = 1222242525;
        String email = "abc@gmail.com";

        Q3_1_Static_Overload_Demo.user_login(mobile_no);
        Q3_1_Static_Overload_Demo.user_login(email);
        Q3_1_Static_Overload_Demo.user_login(mobile_no, email);
    }
}

//output
//You are logged in using mobile no.
//You are logged in using and email id
//You are logged in using both mobile no. and email id


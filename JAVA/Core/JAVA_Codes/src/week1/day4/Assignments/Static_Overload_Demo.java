package week1.day4.Assignments;

public class Static_Overload_Demo {

    public static void user_login(int mobileno, String email){
        System.out.println("You are logged in using both mobile no. and email id");
    }

    public static void user_login(int userID){
        System.out.println("You are logged in using mobile no.");
    }
    public static void user_login(String email){
        System.out.println("You are logged in using and email id");
    }

    public static void main(String[] args) {
        int mobile_no = 1222242525;

        Static_Overload_Demo.user_login(mobile_no);
    }

}

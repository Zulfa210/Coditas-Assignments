package week1.day4;

//Rule 1= you can use only static variables in static method
//static block is called as load initializer or load initializer
//within static block you can use local as well as static variable

public class StaticDemo {

    String name = "Batch2";
    static int aadhar_card = 12333;

    //non-static method
    public void accept_data(){
        System.out.println("The person is " + name + " with aadhar " + aadhar_card);
    }

    //static method
    public static void show_data(){
        System.out.println("Aadhar card is " + aadhar_card);
    }
    static{
        System.out.println("Static one");
    }

    static{
        System.out.println("Static Two");
    }

    public static void main(String[] args) {

         StaticDemo staticDemo = new StaticDemo();

    }
}

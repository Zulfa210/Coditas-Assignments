package week1.day2;

public class Types_Of_Variables {

    //instance variable => it is not mandatory to initialize instance variables, it has default values
    //using object you can reinitialize instance variables

    static int age;
    //no need of object creation to access this value
    //using classname.variable_name you can access/ reinitialize
    //or direct name of static variable


    public void add(){
        //local variables => You have to initialize local variable at the time o declaration
        int number1 = 0 , number2 = 0 , sum = 0;
        sum = number1 + number2 ;
        System.out.println(sum);
    }

    public static void main(String args[]){

        //class_new reference_name = new class_name();
        //new => will help in creating dynamic memory
        //using object you cannot initialize local variables
        Types_Of_Variables types = new Types_Of_Variables();
        types.add();

        Types_Of_Variables.age= 22;


    }
}

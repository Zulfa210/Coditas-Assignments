package week1.day2;

public class VariableTypes_Store {
    String name = "TV";
    int price = 200;
    //instance variable
    static int stock = 50;

public void calculateBill(int quantity){

    //local variable
    float amount = price * quantity;

    System.out.println("Your Amount is " + amount);



}

public static void main( String args[]){

    VariableTypes_Store customer1 = new VariableTypes_Store();
    int quantity = 4;
    customer1.calculateBill(quantity);
    VariableTypes_Store.stock = VariableTypes_Store.stock - quantity;
    //static variable accessed through class name
    System.out.println("Stock left is " + VariableTypes_Store.stock);
}


}

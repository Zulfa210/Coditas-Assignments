package week2.day9;

//2)Practically prove, After changing the return type overloading happens or not?
//Overloading only depends on different signature
//We can Overload methods having different signatures by changing their return types
//But, we cannot overload after changing only return type and keeping the signature same,
//error by compiler = > add(int, int)' is already defined in 'week2.day9.overloading
//If they don’t have different parameters,
// they both are still considered as same method even though return type is different
// and a compile time error will be generated.
class overloadingDemo{

    public int add ( int a, int b){
        return a + b;
    }

    public float add ( int a, float b){
        return a + b;
    }
}
public class Ques2_DriverClass {
    public static void main(String[] args) {
        overloadingDemo demo = new overloadingDemo();
        System.out.println("Addition is " + demo.add(12, 15));

    }

}

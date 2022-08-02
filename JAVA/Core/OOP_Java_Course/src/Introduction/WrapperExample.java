package Introduction;

public class WrapperExample {


    public static void main(String[] args) {
 //       Integer num = 50;

//        int a  =10;
//        int b  = 20;


        Integer a = 20;
        Integer b = 30;


        swap(a,b);

        System.out.println("a: " + a + " b: " + b);


    }
    static void swap(Integer a, Integer b){
        Integer temp = a;
        a= b;
        b= temp;
    }
}

class A{
    final int num = 10;
    String name;

    public A(String name) {
        this.name = name;
    }

}

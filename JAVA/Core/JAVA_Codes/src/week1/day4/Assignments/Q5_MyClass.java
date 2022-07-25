package week1.day4.Assignments;

public class Q5_MyClass {
    private static int x=10;
    //static blocks will be executed only once
    static {
        x++;
    }
    static {
        ++x;
    }
    //non-static blocks will be executed everytime the object is created
    {
        x--;
    }
        public static void main (String[]args){
            Q5_MyClass obj = new Q5_MyClass();
            Q5_MyClass obj2 = new Q5_MyClass();
            Q5_MyClass obj3 = new Q5_MyClass();
            System.out.println(x);

        }
    }
package week3.day11.ClassPracticals;

class Outer{
    public void display(){
        System.out.println("This is inside the method display");


        class Inner{
            public void show(){
                System.out.println("This is inside LIC......");
            }
        }//LIC end

        Inner inner = new Inner();
        inner.show();

    }

    class Member_Inner{
        public void show(){
            System.out.println("This is inside Member inner class");
        }
    }
}

public class LocalInnerClass {

    public static void main(String[] args) {

        Outer outer = new Outer();
        //outer.display();

        Outer.Member_Inner member_inner = outer.new Member_Inner();

       // Outer.Member_Inner member_inner1 = new Outer.Member_Inner();
        member_inner.show();
    }
}

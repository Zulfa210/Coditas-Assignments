package week1.day4.Assignments;

public class Q4_Demo {
    void m1(Q4_Demo demo) {
        System.out.println("Instance method");
    }
    //we cannot overload method which has a difference of static keyword
    //we cannot overload either two or more static methods or two or more non-static method
    static void m2(Q4_Demo d) {
        System.out.println("Static method");
    }

    public static void main(String[] args) {
        Q4_Demo obj = new Q4_Demo();

        obj.m1(obj);
        Q4_Demo.m2(obj);

    }
}

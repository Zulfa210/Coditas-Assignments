package week1.day3.Assignments;

public class Q1_If_Else_Ladder {

    public void demo(){
        int number1 = 3;
        if(number1 >= 0)
            if(number1 == 0)
                System.out.println("First");
            else
                System.out.println("Second");
        System.out.println("Third");
    }

    public static void main(String[] args) {
        Q1_If_Else_Ladder obj = new Q1_If_Else_Ladder();
        obj.demo();

    }

}
//Output:
//        Second
//        Third
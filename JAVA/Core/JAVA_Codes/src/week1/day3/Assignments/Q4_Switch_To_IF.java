package week1.day3.Assignments;

public class Q4_Switch_To_IF {
    int m, x;

    public void checkNumber(){
        m = 1;
        //adding m as 1 hence x=4 will be printed
        if(m == 0){
            x = x+2;
            System.out.println("X = " + x);
        }
        else if(m == 1){
            x = x+4;
            System.out.println("X = " + x);
        }
        else if(m == 2){
            x = x+6;
            System.out.println("X = " + x);
        }
    }

    public static void main(String[] args) {
        Q4_Switch_To_IF object1 = new Q4_Switch_To_IF();

        object1.checkNumber();
    }
}

//output:
//        X = 4

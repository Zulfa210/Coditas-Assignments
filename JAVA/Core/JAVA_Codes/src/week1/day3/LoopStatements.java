package week1.day3;



public class LoopStatements {

    public void for_loop_demo(){

        for(int i = 0; i < 10; i++)
        {
            System.out.println("For loop Iteration no: " + i);
        }
    }

    public void while_loop_demo(){
        int num = 0;
        while( num < 10){

            System.out.println("While loop Iteration no: "+ num);
            num++;

        }
    }

    public void do_while_loop_demo(){
        int num = 10;
        do{
            System.out.println("Do-While loop Iteration no: "+ num);
            num++;

        }while( num < 10);
    }

    public void for_each_demo(){

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for(int n:numbers){
            System.out.println("Iteration no: "+ n);
        }
    }

    public void break_And_Continue_Demo(){

        for(int i = 0; i< 10; i++)
        {
            if(i == 5)
                continue;

            if(i == 7)
                break;
            System.out.println(i);
        }

    }

    public static void main(String[] args) {

        LoopStatements object = new LoopStatements();
        //object.for_loop_demo();
        //object.while_loop_demo();
        //object.do_while_loop_demo();
        //object.for_each_demo();
        object.break_And_Continue_Demo();
    }

}

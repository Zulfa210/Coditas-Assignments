package week2.day9;

//4)Write a program for Addition operation,
class Addition {
    //overloading add method
    public int add(int a, int b){
        return a + b;
    }

    public double add(float a, float b){
        return a + b;
    }
}

class Varargs_Addition{

    //add using varargs
    public int add(int ... values){

        int sum = 0;
        for(int e : values)
            sum += e;

        return sum;
    }
        }

        //use varargs for add method

//access above classes in mainO
public class Ques4_DriveClass {


    public static void main(String[] args) {
        Addition addition = new Addition();
        System.out.println("Addition of int :" + addition.add(12, 13));

        System.out.println("Addition of float : " +addition.add(11.5f, 12.6f));

        Varargs_Addition varObject = new Varargs_Addition();

        System.out.println("Addition using varArgs:  " + varObject.add(12, 22, 14, 11, 15));
    }
}

//output:
//Addition of int :25
//Addition of float : 24.100000381469727
//Addition using varArgs:  74
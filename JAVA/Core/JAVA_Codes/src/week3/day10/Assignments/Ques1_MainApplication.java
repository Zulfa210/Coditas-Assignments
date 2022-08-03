package week3.day10.Assignments;
//Q.1)What is Constructor Chaining?
//=> Constructor chaining is the process of calling one constructor from another constructor with respect to current object.
//
//One of the main use of constructor chaining is to avoid duplicate codes while having multiple constructor
//(by means of constructor overloading) and make code more readable.
//Constructor chaining can be done in two ways :
//1)Within same class=>using this keyword
//2)From base class => using super keyword
//This process is used when we want to perform multiple tasks in a single constructor
// rather than creating a code for each task in a single constructor we create a separate constructor
// for each task and make their chain which makes the program more readable.


class Student{
    public int id;
    public String name;

    public Student(){
        System.out.println("Inside Default constructor");
    }

    public Student(int id){
        //calling default Student() constructor using this keyword
        //this();
        this.id = id;
        System.out.println("Student id is: " + id);
    }

    public Student(int id, String name){
        //calling Student(int id) constructor from this constructor using this keyword
        this(id);
        this.name = name;
        System.out.println("Student Name is: " + name);
    }
}


class Java_Student extends Student{

    int marks_in_java;

    //chaining with Student(int id) constructor of parent class
    // using super keyword
    public Java_Student(int id, int marks_in_java) {
        super(id);
        this.marks_in_java = marks_in_java;
        System.out.println("Java Student Marks are: " + marks_in_java);
    }


    //chaining with Student(int id, String name) constructor of parent class
    // using super keyword
    public Java_Student(int id, String name, int marks_in_java) {
        super(id, name);
        this.marks_in_java = marks_in_java;
        System.out.println("Java Student Marks are: " + marks_in_java);
    }
}

public class Ques1_MainApplication {
    public static void main(String[] args) {
        Student zulfa  = new Student(11, "Zulfa Attar");
        System.out.println("======================================================");
        Java_Student dev   = new Java_Student(12, "Devayush" , 90);
        System.out.println("========================================================");
        Java_Student abhi = new Java_Student(13, 80);
    }
}

//Output:
//Inside Default constructor
//Student id is: 11
//Student Name is: Zulfa Attar
//======================================================
//Inside Default constructor
//Student id is: 12
//Student Name is: Devayush
//Java Student Marks are: 90
//========================================================
//Inside Default constructor
//Student id is: 13
//Java Student Marks are: 80
//

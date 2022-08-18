package Introduction;

import java.awt.geom.Arc2D;

public class Main {
    public static void main(String[] args) {
//
//        //System.out.println("Hello world!");
//
//        //store 5 roll numbers
//        int[] numbers = new int[5];
//
//        //store 5 names
//        String[] names  = new String[5];
//
//        //data of 5 students
//        int[] rno = new int[5];
//        String[] name = new String[5];
//        float[] marks  = new float[5];
//
//        Student[] students = new Student[5];
//
//        Student zulfa;  //reference variable declaration
//        zulfa = new Student(11,"Zulfa Attar", 90.8f); //object memory allocation
//
//        Student Rohit = new Student(12, "Rohit Raut", 88.5f);
//
////        zulfa.name= "Zulfa Attar";
////        zulfa.rno = 11;
////        zulfa.marks = 90.8f;


//        System.out.println(zulfa.rno);
//        System.out.println(zulfa.name);
//        System.out.println(zulfa.marks);
//
//        Student copied = new Student(zulfa);
//        System.out.println(copied.name);
//
//        Student defaultStudent = new Student();
//        System.out.println(defaultStudent.name);
//
//        //two reference variable pointing to the same object
//        Student one = new Student();
//        Student two = one;
//
//        //if we change variable value through one reference variable
//        //another one also changes
//        //because ultimately they are pointing to the same object in the heap memory
//        one.name = "ChangedName";
//
//        System.out.println(two.name);
int k=0;
        for(int i=0;i<5;i++) {
         k=1;
         for(int j=0;j<10;j++) {
           if(j>=4-i && j<=4+i && k==1) {
               System.out.print("*");
               k=0;
           }
           else{
               System.out.print(" ");
               k=1;
           }
        }
            System.out.println();
    }

    }
}
//creating a class
//for every single student
class Student {
    int rno;
    String name;
    float marks;

    //we need a way to add values of the above
    //properties object by object
    //hence constructor is used
    Student (int rno, String name, float marks){
        //this keyword: one word to access every object
        this.name= name;
        this.rno = rno;
        this.marks = marks;
    }

    Student (Student otherStudent){
        //this keyword: one word to access every object
        //here this will be replaced by name of object/reference variable
        this.name= otherStudent.name;
        this.rno = otherStudent.rno;
        this.marks = otherStudent.marks;
    }

    void greeting(){
        System.out.println("Hello! My name is " + this.name);
    }
    void changeName(String name){
        this.name  = name;
    }

    Student (){
        //this is how we call a constructor
        // from another constructor
        //internally: new Student(list of parameters);
        this(10, "Default Student", 100.0f );
    }


}
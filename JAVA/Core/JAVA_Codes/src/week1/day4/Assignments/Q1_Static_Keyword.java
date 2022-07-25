package week1.day4.Assignments;

class Student{
    //static variable
    static String college;
    int rollno;
    String name;

    //non-static method
    public void setStudent(int rollno1, String name1){
        System.out.println("Printing details from Non-Static Method:");
        System.out.println("Name: "+ name1);
        System.out.println("Roll no: " + rollno1);
    }

    //static class can access only the static members of outer class
    static class innerStatic{

        //static method
        public static void showCollege(){

            System.out.println("Printing from Static Method:");
            System.out.println("College: "+ college);
        }

    }

    //static block
    static {
        System.out.println("This is a Static block");
    }
    static {
        college = "MIT";
        //static block can initialize static variables
    }
}


public class Q1_Static_Keyword {

    public static void main(String[] args) {
        Student studentobj = new Student();
        int rollno = 11;
        String name= "Zulfa Attar";

        //accessing non-static method through object
        studentobj.setStudent(rollno, name);

        //accessing static method of static class through direct class name
        Student.innerStatic.showCollege();

    }
}

//output
//This is a Static block
//Printing details from Non-Static Method:
//Name: Zulfa Attar
//Roll no: 11
//Printing from Static Method:
//College: MIT

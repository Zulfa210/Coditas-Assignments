package week3.day10.Assignments;

//Q.2) Try all methods of class for variables, methods, constructor, class

import java.lang.reflect.*;

class Company{
    public int companyId;
    public String name;
    public int no_Of_Employees;

    public Company(){ }

    public Company(int companyId, String name, int no_Of_Employees) {
        this.companyId = companyId;
        this.name = name;
        this.no_Of_Employees = no_Of_Employees;
    }


    public void showData(){
        System.out.println("Company name: " + name + " id: " + companyId + " No. of Employees: "+  no_Of_Employees);
    }

}

public class Ques2_MainApplication {
    public static void main(String[] args) throws Exception {

        //using Class.forName method to access a class
        Class class1  = Class.forName("week3.day10.Assignments.Company");

        System.out.println("==================DATA ABOUT CLASS==========================");
        System.out.println("Name of class: " + class1.getName());
        System.out.println("Package of class: " + class1.getPackage());
        System.out.println("Super class of class: " + class1.getSuperclass());




        //using Class.getConstructors() to access all public constructors of a class
        Constructor[] constructors = class1.getConstructors();

        System.out.println("==================ALL CONSTRUCTORS====================");
        for(Constructor constructor : constructors){
            System.out.println(constructor.toString());
        }

        //using Class.getMethods() to access all public methods of a class
        Method[] method1 = class1.getMethods();

        System.out.println("==================ALL METHODS====================");
        for(Method method : method1){
            System.out.println(method);
        }

        //using Class.getDeclaredMethods to access all publicly declared methods of a class
        Method[] methods = class1.getDeclaredMethods();

        System.out.println("==================DECLARED METHODS====================");
        for(Method method : methods){
            System.out.println(method);
        }


        //using Class.getFields to access all public fields of a class
        Field[] fields = class1.getFields();

        System.out.println("==================ALL FIELDS====================");
        for(Field field: fields){
            System.out.println(field.toString());
        }
    }
}

//output:
//============DATA ABOUT CLASS==========================
//Name of class: week3.day10.Assignments.Company
//Package of class: package week3.day10.Assignments
//Super class of class: class java.lang.Object
//==================ALL CONSTRUCTORS====================
//public week3.day10.Assignments.Company()
//public week3.day10.Assignments.Company(int,java.lang.String,int)
//==================ALL METHODS====================
//public void week3.day10.Assignments.Company.showData()
//public final void java.lang.Object.wait() throws java.lang.InterruptedException
//public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
//public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
//public boolean java.lang.Object.equals(java.lang.Object)
//public java.lang.String java.lang.Object.toString()
//public native int java.lang.Object.hashCode()
//public final native java.lang.Class java.lang.Object.getClass()
//public final native void java.lang.Object.notify()
//public final native void java.lang.Object.notifyAll()
//==================DECLARED METHODS====================
//public void week3.day10.Assignments.Company.showData()
//==================ALL FIELDS====================
//public int week3.day10.Assignments.Company.companyId
//public java.lang.String week3.day10.Assignments.Company.name
//public int week3.day10.Assignments.Company.no_Of_Employees
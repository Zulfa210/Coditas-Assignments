package week3.day10;
//this:- It is pointing towards your current object
//when parameters name are same, this is used to differentiate between local and instance, for assigning value
//then names are different, no need to use this.
//
//

class Teacher{
    public Teacher(int tid, String name, String city, float salary) {
        this.tid = tid;
        this.name = name;
        this.city = city;
        this.salary = salary;
        System.out.println("\n" + tid +" " +  name + " "+ city +" "+ salary);
    }

    private int tid;
    private String name, city;
    private float salary;

    Teacher(){
        System.out.println("This is default constructor\n" + tid +" " +  name + " "+ city +" "+ salary);
    }
}

class Asst_Professor extends Teacher{
    int experience;


    public Asst_Professor(int tid, String name, String city, float salary, int experience) {
        super(tid, name, city, salary);
        this.experience = experience;
    }

    public Asst_Professor(int experience){
        this.experience = experience;
    }


}

public class Teacher_MainApplication {
    public static void main(String[] args) {
        //Teacher teacher = new Teacher();

        System.out.println("--------------------------------------------");
        Teacher teacher1 = new Teacher(12, "Zulfa", "Pune", 30000f);

        Asst_Professor asst_professor = (Asst_Professor) new Teacher();

    }
}

//Downcasting
//instanceOf keyword


package week2.day7;

class RajKapoor{
    int pan_id = 2121;
    public void display(){
        System.out.println("Details of Grandparent is: " + pan_id);
    }
}
class Randheer_kapoor extends RajKapoor{

    int pan_id = 87687;
    String name  = "Randheer";
    public void display(){
        super.display();
        System.out.println("Details of parent is:  Pan_id " + pan_id + " Name: " + name);
    }
}

class Kareena_kapoor extends Randheer_kapoor{

    int pan_id = 87678;
    String name  = "Kareena";
    int aadhar = 8979;
    public void display(){
        super.display();

        System.out.println("Details of Child is: Pan_id " + pan_id + " Name: " + name + " Aadhar_id "+ aadhar );
    }
}

public class MainApplication_Multilevel {

    public static void main(String[] args) {

        Kareena_kapoor rk = new Kareena_kapoor();
        rk.display();
    }
}

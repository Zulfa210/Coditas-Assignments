package week1.day3.Assignments;

public class Q3_Temperature_Switch {

    public void temperature_Check(){
        int var = 2;
        //entering var as 2, hence medium will be printed

        switch(var){
            case 1:
                System.out.println("Low");
                break;

            case 2:
                System.out.println("Medium");
                break;

            case 3:
                System.out.println("High");
                break;

            default:
                System.out.println("Abnormal");
        }
    }

    public static void main(String[] args) {

        Q3_Temperature_Switch check = new Q3_Temperature_Switch();
        check.temperature_Check();
    }
}

//output:
//        Medium

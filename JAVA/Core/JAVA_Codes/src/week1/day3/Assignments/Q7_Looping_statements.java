package week1.day3.Assignments;

public class Q7_Looping_statements {

    String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public void print_Days(){
        for (String s: week){
            System.out.println(s);
        }
    }

    public void print_Days_withSkip(){

        for (String s: week){

            if(s == "Friday")
                continue;

            System.out.println(s);
        }
    }

    public void print_date(int today){

        for(int i = 1; i <= today; i++)
            System.out.println("July "+ i);

        System.out.println("Today is "+ today + "July");
    }



    public static void main(String[] args) {
        Q7_Looping_statements object1 = new Q7_Looping_statements();
        object1.print_Days();

        System.out.println("=================================================");
        object1.print_Days_withSkip();

        System.out.println("=================================================");

        object1.print_date(22);
    }
}

//Output:
//        Monday
//        Tuesday
//        Wednesday
//        Thursday
//        Friday
//        Saturday
//        Sunday
//        =================================================
//        Monday
//        Tuesday
//        Wednesday
//        Thursday
//        Saturday
//        Sunday
//        =================================================
//        July 1
//        July 2
//        July 3
//        July 4
//        July 5
//        July 6
//        July 7
//        July 8
//        July 9
//        July 10
//        July 11
//        July 12
//        July 13
//        July 14
//        July 15
//        July 16
//        July 17
//        July 18
//        July 19
//        July 20
//        July 21
//        July 22
//        Today is 22July
//
//

package week4.Day16;

public class CLADemo {
    public static void main(String[] args) {
        System.out.println("Command LineArgument");
        for(String s: args){
            System.out.println(s);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int sum = a + b;
        System.out.println("Addition using CLA: " + sum);
    }
}

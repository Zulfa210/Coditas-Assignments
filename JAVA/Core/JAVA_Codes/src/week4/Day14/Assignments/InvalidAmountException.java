package week4.Day14.Assignments;

public class InvalidAmountException extends Exception{
    public InvalidAmountException(String message){
        System.out.println("Invalid Amount Exception: " + message);
    }

    public InvalidAmountException(){
        super();
    }
    public InvalidAmountException(String message, Throwable cause){
        System.out.println("Invalid Amount Exception: " + message + "\nCause: " + cause);
    }
    public InvalidAmountException(Throwable cause){
        System.out.println("Cause: " + cause);
    }
}

package week4.Day14.Assignments;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(){
        super();
    }
    public InsufficientBalanceException(String message){
        System.out.println("Insufficient Balance Exception: " + message);
    }

    public InsufficientBalanceException(String message, Throwable cause){
        System.out.println("Insufficient Balance Exception: " + message + "\nCause: " + cause);
    }

    public InsufficientBalanceException(Throwable cause){
        System.out.println( "\nCause: " + cause);
    }
}

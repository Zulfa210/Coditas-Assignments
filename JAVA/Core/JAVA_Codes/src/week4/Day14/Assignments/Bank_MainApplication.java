package week4.Day14.Assignments;
/**
 * Q.1 )Write a program for::below cases to handle wrong operations done by customers in
 * deposit, and withdrawal operations.
 * Case 1)CREATE an InvalidAmountException if the user enters zero or -ve amount in deposit
 * and withdraw operations
 * Case 2)I hrow InsufficientBalanceException if the user enters the amount greater than the
 * balance in case of withdrawing operations
 *
 * @author Zulfa-Coditas
 */

import java.util.Scanner;

class Bank_customer{
    int account_number;
    float balance;
    String accountHolder_name;

    public Bank_customer(int account_number,  String accountHolder_name, float balance) {
        this.account_number = account_number;
        this.balance = balance;
        this.accountHolder_name = accountHolder_name;
    }

    public void withdrawal(float amount){
        try{
            if(amount <= 0){
                throw new InvalidAmountException("Enter value greater than zero!!!");
            }
            else if (this.balance<amount) {
                throw new InsufficientBalanceException("Enter amount less than or equal to your current balance");
            }
            else{
                balance -= amount;
                System.out.println("Amount " + amount + " Withdrawal successfully, Available Balance: " + balance);

            }
        }catch (InvalidAmountException | InsufficientBalanceException e){
            e.printStackTrace();
        }

    }
    public void deposit(float amount){
        try{
            if(amount <= 0){
                throw new InvalidAmountException("Enter value greater than zero!!!");
            }
            else{
                balance += amount;
                System.out.println("Amount " + amount + " Deposited successfully, Available Balance: " + balance);
            }
        }catch (InvalidAmountException e){
            e.printStackTrace();
        }

    }

}
public class Bank_MainApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer details to create Customer Account: ");
        System.out.println("Enter Account number: ");
        int account_number = scanner.nextInt();
        System.out.println("Enter Customer Name: ");
        String customer_name = scanner.next();
        System.out.println("Enter Balance: ");
        float balance = scanner.nextFloat();

        Bank_customer customer = new Bank_customer(account_number, customer_name, balance);
        char answer;
         do{
             System.out.println("Enter your Choice: \n1. Withdrawal\n2. Deposit");
             int choice = scanner.nextInt();
             if(choice == 1){
                 System.out.println("Enter amount for Withdrawal: ");
                 float withdrawalAmount = scanner.nextFloat();
                 customer.withdrawal(withdrawalAmount);
             }
             else if(choice ==2){
                 System.out.println("Enter amount for Deposit: ");
                 float depositAmount = scanner.nextFloat();
                 customer.deposit(depositAmount);
             }
             System.out.println("Do you want to do more Transaction? (Y/N)");
             answer = scanner.next().charAt(0);

         }while(answer == 'Y' || answer == 'y');

    }
}

/*
Output:
Enter Customer details to create Customer Account:
Enter Account number:
111
Enter Customer Name:
Zulfa
Enter Balance:
10000
Enter your Choice:
1. Withdrawal
2. Deposit
1
Enter amount for Withdrawal:
0
Invalid Amount Exception: Enter value greater than zero!!!
Do you want to do more Transaction? (Y/N)
week4.Day14.Assignments.InvalidAmountException
	at week4.Day14.Assignments.Bank_customer.withdrawal(Bank_MainApplication.java:19)
	at week4.Day14.Assignments.Bank_MainApplication.main(Bank_MainApplication.java:70)
Y
Enter your Choice:
1. Withdrawal
2. Deposit
2
Enter amount for Deposit:
0
Invalid Amount Exception: Enter value greater than zero!!!
Do you want to do more Transaction? (Y/N)
week4.Day14.Assignments.InvalidAmountException
	at week4.Day14.Assignments.Bank_customer.deposit(Bank_MainApplication.java:37)
	at week4.Day14.Assignments.Bank_MainApplication.main(Bank_MainApplication.java:75)
Y
Enter your Choice:
1. Withdrawal
2. Deposit
1
Enter amount for Withdrawal:
-1
Invalid Amount Exception: Enter value greater than zero!!!
Do you want to do more Transaction? (Y/N)
week4.Day14.Assignments.InvalidAmountException
	at week4.Day14.Assignments.Bank_customer.withdrawal(Bank_MainApplication.java:19)
	at week4.Day14.Assignments.Bank_MainApplication.main(Bank_MainApplication.java:70)
Y
Enter your Choice:
1. Withdrawal
2. Deposit
1
Enter amount for Withdrawal:
1000
Amount 1000.0 Withdrawal successfully, Available Balance: 9000.0
Do you want to do more Transaction? (Y/N)
Y
Enter your Choice:
1. Withdrawal
2. Deposit
2
Enter amount for Deposit:
5000
Amount 5000.0 Deposited successfully, Available Balance: 14000.0
Do you want to do more Transaction? (Y/N)
N

Process finished with exit code 0
 */

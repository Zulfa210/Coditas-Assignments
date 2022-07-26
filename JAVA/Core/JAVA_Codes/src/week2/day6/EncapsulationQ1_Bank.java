package week2.day6;

import java.util.*;

class Bank{

    //customer details are kept private
    private String account_number;
    private String customer_name;
    private String account_type;
    private long balance;

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    //bank details are kept public
    public String bank_name;
    public String bank_address;
    public String bank_branch;
    public String IFSC_code;


    public Bank(String bank_name, String bank_address, String bank_branch, String IFSC_code) {
        this.bank_name = bank_name;
        this.bank_address = bank_address;
        this.bank_branch = bank_branch;
        this.IFSC_code = IFSC_code;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "account_number='" + account_number + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", account_type='" + account_type + '\'' +
                ", balance=" + balance +
                ", bank_name='" + bank_name + '\'' +
                ", bank_address='" + bank_address + '\'' +
                ", bank_branch='" + bank_branch + '\'' +
                ", IFSC_code='" + IFSC_code + '\'' +
                '}';
    }

    public void openAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account No: ");
        account_number = sc.next();
        System.out.print("Enter Account type: ");
        account_type = sc.next();
        System.out.print("Enter Name: ");
        customer_name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        long amount;
        System.out.println("Enter the amount you want to deposit: ");
        amount = sc.nextLong();
        balance = balance + amount;
    }

    public void withdrawal() {
        Scanner sc = new Scanner(System.in);
        long amount;
        System.out.println("Enter the amount for withdrawal: ");
        amount = sc.nextLong();
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " +  amount + " Try Again...!!" );
        }
    }
}
public class EncapsulationQ1_Bank {


    public static void main(String[] args) {
        Bank bank1 = new Bank("HDFC","Pune","Bund Garden", "HDFC00262");
        bank1.openAccount();
        bank1.deposit();
    }

}

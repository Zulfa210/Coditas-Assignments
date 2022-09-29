package com.bean;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Entity
@Table(name = "savings_account")
public class SavingAccount implements BankAccount{
    @Id
    @Column(name = "account_number")
    private long accountNumber;
    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "account_Ifsc_code")
    private String accountIfscCode;

    @Column(name = "account_balance")
    private float accountBalance;

    @OneToMany(mappedBy = "savingsAccount", cascade = CascadeType.ALL)
    private List<Address> accountAddress;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountIfscCode() {
        return accountIfscCode;
    }

    public void setAccountIfscCode(String accountIfscCode) {
        this.accountIfscCode = accountIfscCode;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<Address> getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(List<Address> accountAddress) {
        this.accountAddress = accountAddress;
    }

    public SavingAccount(long accountNumber, String accountHolderName, String accountIfscCode, float accountBalance, List<Address> accountAddress) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountIfscCode = accountIfscCode;
        this.accountBalance = accountBalance;
        this.accountAddress = accountAddress;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountIfscCode='" + accountIfscCode + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountAddress=" + accountAddress +
                '}';
    }
}

package com.bean;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Entity
@Table(name = "current_account")
public class CurrentAccount implements BankAccount{
    @Id
    @Column(name = "account_number")
    private long accountNumber;
    @Column(name ="account_holder_name")
    private String accountHolderName;

    @Column(name = "account_ifsc_code")
    private String accountIfscCode;

    @Column(name = "account_balance")
    private float accountBalance;

    @Column(name = "account_holder_company")
    private String accountHolderCompanyName;

    @OneToMany(mappedBy = "currentAccount", cascade = CascadeType.ALL)
    private List<Address> accountAddress;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CurrentAccount(long accountNumber, String accountHolderName, String accountIfscCode, float accountBalance, String accountHolderCompanyName, List<Address> accountAddress) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountIfscCode = accountIfscCode;
        this.accountBalance = accountBalance;
        this.accountHolderCompanyName = accountHolderCompanyName;
        this.accountAddress = accountAddress;
    }

    public String getAccountHolderCompanyName() {
        return accountHolderCompanyName;
    }

    public void setAccountHolderCompanyName(String accountHolderCompanyName) {
        this.accountHolderCompanyName = accountHolderCompanyName;
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

    public CurrentAccount() {
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountIfscCode='" + accountIfscCode + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountHolderCompanyName='" + accountHolderCompanyName + '\'' +
                ", accountAddress=" + accountAddress +
                '}';
    }
}

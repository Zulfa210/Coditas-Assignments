package com.bean;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "flat_no")
    private int flatNo;

    @Column(name = "street_name")
    private String StreetName;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "pincode")
    private int pincode;

    @ManyToOne
    @JoinColumn(name = "current_account")
    private CurrentAccount currentAccount;

    @ManyToOne
    @JoinColumn(name = "savings_account")
    private SavingAccount savingAccount;

    public Address() {
    }

    public Address(int addressId, int flatNo, String streetName, String cityName, int pincode, CurrentAccount currentAccount, SavingAccount savingAccount) {
        this.addressId = addressId;
        this.flatNo = flatNo;
        StreetName = streetName;
        this.cityName = cityName;
        this.pincode = pincode;
        this.currentAccount = currentAccount;
        this.savingAccount = savingAccount;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    public SavingAccount getSavingsAccount() {
        return savingAccount;
    }

    public void setSavingsAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", flatNo=" + flatNo +
                ", StreetName='" + StreetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", pincode=" + pincode +
                ", currentAccount=" + currentAccount +
                ", savingsAccount=" + savingAccount +
                '}';
    }
}

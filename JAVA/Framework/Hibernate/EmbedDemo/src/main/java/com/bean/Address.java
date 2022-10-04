package com.bean;

import javax.persistence.Embeddable;

/**
 * @author Zulfa Attar
 */
@Embeddable
public class Address {

    private int houseNumber;
    private String areaName;
    private String cityName;
    private int pincode;

    public Address(int houseNumber, String areaName, String cityName, int pincode) {
        this.houseNumber = houseNumber;
        this.areaName = areaName;
        this.cityName = cityName;
        this.pincode = pincode;
    }

    public Address() {
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", areaName='" + areaName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}

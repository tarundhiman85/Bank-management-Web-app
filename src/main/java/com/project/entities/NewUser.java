package com.project.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class NewUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, name = "first_name")
    private String firstName;
    @Column(length = 10, name = "last_name")
    private String lastName;
    @Column(length = 20, name = "fathers_name")
    private String fathersName;
    @Column(length = 25, name = "dob")
    private String dob;
    @Column(length = 10, name = "gender")
    private String gender;
    @Column(length = 1500, name = "user_addressr")
    private String address;
    @Column(length = 1500, name = "present_address")
    private String presentAddress;
    @Column(length = 20, name = "pan_number")
    private String PANno;
    @Column(length = 20, name = "user_phone")
    private String userPhone;
    @Column(length = 20, name = "account_type")
    private String accountType;
    @Column(length = 20, name = "opening_balance")
    private String openingBalance;


    public NewUser(){}

    public NewUser(String firstName,String lastName,String fathersName,String dob,String gender,String address,
                   String presentAddress,String PANno,String userPhone,String accountType,String openingBalance)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.fathersName=fathersName;
        this.dob=dob;
        this.gender=gender;
        this.address=address;
        this.presentAddress=presentAddress;
        this.PANno=PANno;
        this.userPhone=userPhone;
        this.accountType=accountType;
        this.openingBalance=openingBalance;

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPANno() {
        return PANno;
    }

    public void setPANno(String PANno) {
        this.PANno = PANno;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(String openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }


    @Override
    public String toString() {
        return "NewUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", presentAddress='" + presentAddress + '\'' +
                ", PANno='" + PANno + '\'' +
                ", accountType='" + accountType + '\'' +
                ", openingBalance='" + openingBalance + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}

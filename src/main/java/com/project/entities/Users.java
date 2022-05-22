package com.project.entities;
import javax.persistence.*;


@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, name = "user_id")
    private int userId;
    @Column(length = 100, name = "user_email")
    private String userEmail;
    @Column(length = 100, name = "user_password")
    private String userPassword;
    @Column(length = 100, name = "fullName")
    private String userName;
    @Column(length = 100, name = "father_name")
    private String fatherName;
    @Column(name = "DOB")
    private String dob;
    @Column(name = "gender")
    private String gender;
    @Column(length = 1500, name = "user_address")
    private String userAddress;
    @Column(length = 1500, name = "present_address")
    private String presentAddress;
    @Column(length = 10, name = "pan_number")
    private String panNo;
    @Column(length = 10, name = "mobile_phone")
    private String MobilePhone;
    @Column(length = 10, name = "landline")
    private String landline;
    @Column(name = "account_type")
    private String accountType;
    @Column(name ="opening_balance")
    private String balance;
    @Column(name="customer_id")
    private String customerId;
    @Column(length = 10, name="account_No")
    private String accountNo;
    @Column(length = 10, name = "card_number")
    private String cardNumber;
    @Column(length = 100, name = "branch_name")
    private String branchName;
    @Column(length = 10, name = "ifsc_code")
    private String ifscCode;
    private int RoleId;
    private String LoginStatus="false";

    public Users(){}

    public Users(String userName, String userEmail, String userPassword, String userPhone, String userAddress, String presentAddress, String accountType, String fatherName, String dob, String panNumber, String balance, String landline, String gender, String branchName) {
      this.userName=userName;
      this.userEmail=userEmail;
      this.userPassword=userPassword;
      this.MobilePhone=userPhone;
      this.userAddress=userAddress;
      this.presentAddress=presentAddress;
      this.accountType=accountType;
      this.fatherName=fatherName;
      this.dob=dob;
      this.panNo=panNumber;
      this.balance=balance;
      this.landline=landline;
      this.gender=gender;
      this.branchName=branchName;
    }

    public String getLoginStatus() {
        return LoginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        LoginStatus = loginStatus;
    }

    //auto generate numbers when user create account
    @PrePersist
    public void generateNo(){
        //a random 10 digit number
        this.customerId = String.valueOf(Math.random()).substring(2, 12);
        this.accountNo = String.valueOf(Math.random()).substring(2,12);
        this.cardNumber = String.valueOf(Math.random()).substring(2,12);
        this.RoleId=2;
        switch (this.branchName) {
            case "Ahmadabad":
                this.ifscCode = "IFSC-AHM";
                break;
            case "Haryana":
                this.ifscCode = "IFSC-HRY";
                break;
            case "Mumbai":
                this.ifscCode = "IFSC-MUM";
                break;
            case "Pune":
                this.ifscCode = "IFSC-PUN";
                break;
            case "Chandigarh":
                this.ifscCode = "IFSC-CHD";
                break;
            case "Bangalore":
                this.ifscCode = "IFSC-BLR";
                break;
        }
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }


    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        MobilePhone = mobilePhone;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}


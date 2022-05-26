package com.project.entities;

import javax.persistence.*;

@Entity
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String UserType;
    private int UserID;
    private String Password;
    private String LoginStatus;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;
    public UserCredentials() {

    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public UserCredentials(String userType, int userID, String password, String loginStatus) {
        UserType = userType;
        UserID = userID;
        Password = password;
        LoginStatus = loginStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLoginStatus() {
        return LoginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        LoginStatus = loginStatus;
    }
}

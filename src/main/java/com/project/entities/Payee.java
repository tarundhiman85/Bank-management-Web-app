package com.project.entities;

import javax.persistence.*;

@Entity
public class Payee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pID;
    private String pAccountNumber;
    private String pName;
    private String pIFSC;
    private boolean activated = false;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private Users user;

    public Payee(String pAccountNumber, String pName, String pIFSC, Users user) {
        this.pAccountNumber = pAccountNumber;
        this.pName = pName;
        this.pIFSC = pIFSC;
        this.user = user;
    }

    public Payee() {

    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getpAccountNumber() {
        return pAccountNumber;
    }

    public void setpAccountNumber(String pAccountNumber) {
        this.pAccountNumber = pAccountNumber;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpIFSC() {
        return pIFSC;
    }

    public void setpIFSC(String pIFSC) {
        this.pIFSC = pIFSC;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

package com.project.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tId;
    private String referenceNo;
    private String transactionType;
    private String pAccountNumber;
    private Date Time;
    private String Amount;
    private String Status;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;

    @PrePersist
    void onCreate(){
        Time = new Date();
        //create a 10 digit random number
        referenceNo = String.format("%010d", (int)(Math.random()*10000000000L));
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getpAccountNumber() {
        return pAccountNumber;
    }

    public void setpAccountNumber(String pAccountNumber) {
        this.pAccountNumber = pAccountNumber;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

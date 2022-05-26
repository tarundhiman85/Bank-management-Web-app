package com.project.entities;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class RDAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String DepositAmount;
    private String TenureOfDeposit;
    private String CurrentROI;
    private String MaturityAmount;
    private String MaturityDate;
    private String NextDate;
    private String registeredDate;
    private boolean isActive=false;
    private String MonthlyDeposit;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private Users user;

    @PrePersist
    public void prePersist() throws ParseException {
        this.registeredDate = new Date().toString();
//        String nextMonth = this.registeredDate.split(" ")[1];
        //increment the month by 1
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        if (!isActive)
        {
            Date date = formatter.parse(this.registeredDate);
            isActive = true;
            date.setMonth(date.getMonth() + 1);
            this.NextDate = date.toString();
        }
        else
        {
            Date date = formatter.parse(this.NextDate);
            date.setMonth(date.getMonth() + 1);
            this.NextDate = date.toString();
        }
    }

    public String getNextDate() {
        return NextDate;
    }

    public void setNextDate(String nextDate) {
        NextDate = nextDate;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public RDAccount(String depositAmount, String tenureOfDeposit, String currentROI, String maturityAmount, String maturityDate)
    {
        DepositAmount = depositAmount;
        TenureOfDeposit = tenureOfDeposit;
        CurrentROI = currentROI;
        MaturityAmount = maturityAmount;
        MaturityDate = maturityDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public RDAccount() {

    }

    public String getMonthlyDeposit() {
        return MonthlyDeposit;
    }

    public void setMonthlyDeposit(String monthlyDeposit) {
        MonthlyDeposit = monthlyDeposit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDepositAmount() {
        return DepositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        DepositAmount = depositAmount;
    }

    public String getTenureOfDeposit() {
        return TenureOfDeposit;
    }

    public void setTenureOfDeposit(String tenureOfDeposit) {
        TenureOfDeposit = tenureOfDeposit;
    }

    public String getCurrentROI() {
        return CurrentROI;
    }

    public void setCurrentROI(String currentROI) {
        CurrentROI = currentROI;
    }

    public String getMaturityAmount() {
        return MaturityAmount;
    }

    public void setMaturityAmount(String maturityAmount) {
        MaturityAmount = maturityAmount;
    }

    public String getMaturityDate() {
        return MaturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        MaturityDate = maturityDate;
    }
}

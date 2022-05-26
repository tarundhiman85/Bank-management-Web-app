package com.project.entities;

import javax.persistence.*;

@Entity
public class FDAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String DepositAmount;
    private String TenureOfDeposit;
    private String CurrentROI;
    private String MaturityAmount;
    private String MaturityDate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private Users user;

    public FDAccount( String depositAmount, String tenureOfDeposit, String currentROI, String maturityAmount, String maturityDate) {


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

    public FDAccount() {

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

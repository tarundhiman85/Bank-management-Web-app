package com.project.Service;

import com.project.entities.FDAccount;
import com.project.entities.Payee;
import com.project.entities.RDAccount;
import com.project.entities.Transact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingMethodsTest {

    @Test
    void saveTransaction() {
        //test the save transaction method
        Transact transact = new Transact();
        transact.setAmount("100");
        transact.setTransactionType("Deposit");
        transact.setReferenceNo("123456789");
        transact.setpAccountNumber("523523533");
        assertEquals(transact.getAmount(), "100");
        assertEquals(transact.getTransactionType(), "Deposit");
        assertEquals(transact.getReferenceNo(), "123456789");
        assertEquals(transact.getpAccountNumber(), "523523533");
    }

    @Test
    void savePayee() {
        //test the save payee method
        Payee payee = new Payee();
        payee.setpName("Test");
        payee.setpAccountNumber("123456789");
        payee.setpID(1);
        payee.setpIFSC("IFSC-AHM");

        assertEquals(payee.getpName(), "Test");
        assertEquals(payee.getpAccountNumber(), "123456789");
        assertEquals(payee.getpID(), 1);
        assertEquals(payee.getpIFSC(), "IFSC-AHM");
    }

    @Test
    void activatePayee() {
        //test to activate payee method
        Payee payee = new Payee();
        payee.setActivated(true);
        assertTrue(payee.isActivated());
    }

    @Test
    void saveFDAccount(){
        //test to save FD account method
        FDAccount fdAccount = new FDAccount();
        fdAccount.setDepositAmount("100");
        fdAccount.setMaturityDate("12/12/2020");
        fdAccount.setMaturityAmount("1000");
        fdAccount.setCurrentROI("10");
        assertEquals(fdAccount.getDepositAmount(), "100");
        assertEquals(fdAccount.getMaturityDate(), "12/12/2020");
        assertEquals(fdAccount.getMaturityAmount(), "1000");
        assertEquals(fdAccount.getCurrentROI(), "10");
    }

    @Test
    void saveRDAccount(){
        //test to save RD account method
        RDAccount rdAccount = new RDAccount();
        rdAccount.setDepositAmount("100");
        rdAccount.setMaturityDate("12/12/2020");
        rdAccount.setMaturityAmount("1000");
        rdAccount.setCurrentROI("10");
        assertEquals(rdAccount.getDepositAmount(), "100");
        assertEquals(rdAccount.getMaturityDate(), "12/12/2020");
        assertEquals(rdAccount.getMaturityAmount(), "1000");
        assertEquals(rdAccount.getCurrentROI(), "10");
    }
}
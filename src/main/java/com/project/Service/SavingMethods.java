package com.project.Service;

import com.project.dao.UserDao;
import com.project.entities.*;

import com.project.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SavingMethods {
    public void saveTransaction(Transact tx){
        Session session = FactoryProvider.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.save(tx);
        session.close();
    }

    ////////////////FD RD Methods/////////////////////////////
    public boolean saveFDAccount(FDAccount fd){
        try{
        Session session = FactoryProvider.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.save(fd);
        session.close();
        return true;
    }
    catch (Exception e){
        return false;
    }
    }
    public boolean saveRDAccount(RDAccount rd){
        try{
            Session session = FactoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();
            transaction.commit();
            session.save(rd);
            session.close();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    //////////////Payee Methods/////////////////////////////
    public boolean SavePayee(String AccountNumber, String ifsc, String payeeName, Users user){
        try {
            Payee payee = new Payee( AccountNumber, payeeName, ifsc, user);
            Session session = FactoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();
            transaction.commit();
            session.save(payee);
            session.close();
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean activatePayee(Payee payee){
        try {
            payee.setActivated(true);
            Session session = FactoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(payee);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            return false;
        }
        return true;
    }


    ////////////////Stock Methods/////////////////////////////
    public boolean saveStock(Stocks stock, Users user) {
        try {
            Double amount2 = getDoubleby2Places(stock);
            boolean b = new UserDao(FactoryProvider.getFactory()).decreaseUserBalance(user, amount2);
            return SaveStock(stock, b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sellStock(Stocks stock, Users user) {
        try {
            Double amount2 = getDoubleby2Places(stock);
            boolean b = new UserDao(FactoryProvider.getFactory()).increaseUserBalance(user, amount2);
            return new RemoveMethod().removeStock(stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private Double getDoubleby2Places(Stocks stock) {
        //convert this amount to double
        double amount1 = Double.parseDouble(stock.getPrice());
        String s = String.format("%.2f", amount1);
        //convert this String to double increasing the user balance
        return Double.parseDouble(s);
    }


    private boolean SaveStock(Stocks stock, boolean b) {
        if (b) {
            Session session = FactoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();
            transaction.commit();
            session.save(stock);
            session.close();
            return true;
        } else {
            return false;
        }
    }

    public void createProfitLoss(String profit, String loss, Users user) {
        profitLoss profitLoss = new profitLoss(profit, loss, user);
        Session session = FactoryProvider.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.save(profitLoss);
        session.close();
    }
}

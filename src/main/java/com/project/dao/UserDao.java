package com.project.dao;

import com.project.entities.*;
import com.project.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {
    private SessionFactory factory;
    //we need to give Session factory to dao
    public UserDao(SessionFactory factory){
        this.factory=factory;
    }
    public UserDao() {
    }
    public Users getUserByEmailandPassword(String email, String password){
        Users user = null;
        try {
            //validation if the user exists
            Session session = this.factory.openSession();
            String q = "from Users where userEmail=: e and userPassword=: p";
            Query query = (Query) session.createQuery(q);
            query.setParameter("e", email);
            query.setParameter("p", password);
            user = (Users) query.uniqueResult();
            session.close();
        }
        catch (Exception e){
          e.printStackTrace();
        }
        return user;
    }
    public Users getUserById(int id){
        Users user = null;
        try {
            //validation if the user exists
            Session session = this.factory.openSession();
            String q = "from Users where userId=:i";
            Query query = (Query) session.createQuery(q);
            query.setParameter("i", id);
            user = (Users) query.uniqueResult();
            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    public Payee getPayeeById(String id){
        Payee payee = null;
        try {
            //validation if the user exists
            //convert id to int
            int i = Integer.parseInt(id);
            Session session = this.factory.openSession();
            String q = "from Payee where pID=:i";
            Query query = (Query) session.createQuery(q);
            query.setParameter("i", i);
            payee = (Payee) query.uniqueResult();
            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return payee;
    }
    public List<Users> getAllUsers(){
        List<Users> users = new ArrayList<>();
        try {
            //validation if the user exists
            Session session = this.factory.openSession();
            String q = "from Users";
            Query query = (Query) session.createQuery(q);
            users = query.list();
            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
    public Payee getPayee(String AccountNumber, String PayeeName, String IfscCode){
        Payee payee = null;
        try {
            //validation if the user exists
            Session session = this.factory.openSession();
            String q = "from Payee where pAccountNumber=:a and pName=:p and pIFSC=:i";
            Query query = (Query) session.createQuery(q);
            query.setParameter("a", AccountNumber);
            query.setParameter("p", PayeeName);
            query.setParameter("i", IfscCode);
            payee = (Payee) query.uniqueResult();
            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return payee;
    }
    public List<Payee> getPayeeList(int userId){
        List<Payee> payeeList = null;
        try {
            //validation if the user exists
            Session session = this.factory.openSession();
            String q = "from Payee where user.userId=:i";
            Query query = (Query) session.createQuery(q);
            query.setParameter("i", userId);
            payeeList = query.list();
            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return payeeList;
    }
    public RDAccount getRDAccountByUserId(int id){
        RDAccount rdAccount = null;
        try {
            //validation if the user exists
            Session session = this.factory.openSession();
            String q = "from RDAccount where user.userId=:i";
            Query query = (Query) session.createQuery(q);
            query.setParameter("i", id);
            rdAccount = (RDAccount) query.uniqueResult();
            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rdAccount;
    }

    public boolean updateRDAccount(RDAccount rd) throws ParseException {
        boolean result = false;
        try{
        String nextDate = rd.getNextDate();
        //update the date also to next month
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date = formatter.parse(nextDate);
        date.setMonth(date.getMonth() + 1);
        nextDate = date.toString();
        rd.setNextDate(nextDate);
            Session session = this.factory.openSession();
            session.beginTransaction();
            session.update(rd);
            session.getTransaction().commit();
            session.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public FDAccount getFDAccountByUserId(int id) {
        FDAccount fdAccount = null;
        try {
            //validation if the user exists
            Session session = this.factory.openSession();
            String q = "from FDAccount where user.userId=:i";
            Query query = (Query) session.createQuery(q);
            query.setParameter("i", id);
            fdAccount = (FDAccount) query.uniqueResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fdAccount;
    }

    public boolean removeFDAccount(FDAccount fd) {
        //call the method increase the balance of the user by giving the deposit amount of fd account
        Users user = fd.getUser();
        increaseBalancefd(user,fd.getMaturityAmount(),fd);
        boolean result = false;
        try {
            Session session = this.factory.openSession();
            session.beginTransaction();
            session.delete(fd);
            session.getTransaction().commit();
            session.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    public boolean removeRDAccount(RDAccount rd) {
        //call the method increase the balance of the user by giving the deposit amount of rd account
        Users user = rd.getUser();
        increaseBalancerd(user,rd.getMaturityAmount(), rd);
        boolean result = false;
        try {
            Session session = this.factory.openSession();
            session.beginTransaction();
            session.delete(rd);
            session.getTransaction().commit();
            session.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private void increaseBalancerd(Users user, String depositAmount, RDAccount rd) {
        //first check on the rd the deposit amount is greater then or equal to maturity amount
        if(Double.parseDouble(depositAmount) >= Double.parseDouble(rd.getMaturityAmount())){
            //just simply add the maturity amount to the opening balance of the user
            user.setBalance(String.valueOf(Double.parseDouble(user.getBalance()) + Double.parseDouble(rd.getMaturityAmount())));
            //call the update user method to update the user
            updateUser(user);
        }
        else{
            //if the deposit amount is less then the maturity amount then decrease one percent of the deposit amount from rd account and add it to the user
            user.setBalance(String.valueOf(Double.parseDouble(user.getBalance()) + (Double.parseDouble(depositAmount) - (Double.parseDouble(depositAmount) * 0.01))));
            //call the update user method to update the user
            updateUser(user);
        }
    }
    private void increaseBalancefd(Users users, String maturityAmount, FDAccount fd) {
        //check if the maturity date is greater then or equal to today date
        if(fd.getMaturityDate().compareTo(String.valueOf(new Date())) < 0){
            //just simply add the maturity amount to the opening balance of the user
            users.setBalance(String.valueOf(Double.parseDouble(users.getBalance()) + Double.parseDouble(fd.getMaturityAmount())));
            //call the update user method to update the user
            updateUser(users);
        }
        else{
            //if the deposit amount is less then the maturity amount then decrease one percent of the deposit amount from fd account and add it to the user
            users.setBalance(String.valueOf(Double.parseDouble(users.getBalance()) + (Double.parseDouble(maturityAmount) - (Double.parseDouble(maturityAmount) * 0.01))));
            //call the update user method to update the user
            updateUser(users);
        }


    }

    private void updateUser(Users user) {
        try {
            Session session = this.factory.openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Transact> getTransactionHistoryList(int userId) {
        List<Transact> transactList = new ArrayList<>();
        try {
            Session session = this.factory.openSession();
            session.beginTransaction();
            transactList = session.createQuery("from Transact where user.userId = :userId").setParameter("userId", userId).list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactList;
    }

    public boolean validateUserRegistrationEmail(String userEmail) {
        String q = "From Users where userEmail=:e";
        Session session = this.factory.openSession();
        Query qu = session.createQuery(q);
        qu.setParameter("e", userEmail);
        if (qu.uniqueResult() == null) return true;
        return false;
    }

    public boolean validateUserRegistrationUserName(String userName) {
        String q = "From Users where userName=:e";
        Session session = this.factory.openSession();
        Query qu = session.createQuery(q);
        qu.setParameter("e", userName);
        if (qu.uniqueResult() == null) return true;
        return false;
    }

    public boolean decreaseUserBalance(Users user, Double amount) {
        try {
            Session session = this.factory.openSession();
            session.beginTransaction();
            String s = String.valueOf(Double.parseDouble(user.getBalance()) - amount);
            //get the double upto 2 decimal places
            user.setBalance(String.format("%.2f", Double.parseDouble(s)));
            session.update(user);
            session.update(user);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Stocks> getStockList(Users user) {
          List<Stocks> stockList = new ArrayList<>();
        try {
            Session session = this.factory.openSession();
            session.beginTransaction();
            stockList = session.createQuery("from Stocks where user.userId = :userId").setParameter("userId", user.getUserId()).list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockList;
    }

    public boolean increaseUserBalance(Users user, Double amount2) {
        try {
            Session session = this.factory.openSession();
            session.beginTransaction();
             String s = String.valueOf(Double.parseDouble(user.getBalance()) + amount2);
             //get the double upto 2 decimal places
            user.setBalance(String.format("%.2f", Double.parseDouble(s)));
            session.update(user);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stocks getStockById(String stockId) {
        Stocks stock = null;
        try {
            int id = Integer.parseInt(stockId);
            Session session = this.factory.openSession();
            session.beginTransaction();
            stock = session.get(Stocks.class, id);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stock;
    }

    public void updateProfitLoss(Users user, String profit, String loss) {
        try {
            //first check if profitLoss object exists for a user
            //get profitLoss object by userId
            profitLoss profitLoss = getProfitLossByUserId(user.getUserId());
            if (profitLoss == null) {
                //create new profitLoss object
                profitLoss = new profitLoss();
                profitLoss.setUser(user);
                profitLoss.setProfit(profit);
                profitLoss.setLoss(loss);
                Session session = this.factory.openSession();
                session.beginTransaction();
                session.save(profitLoss);
                session.getTransaction().commit();
                session.close();
            }
            else {
                //update profitLoss object
                Session session = this.factory.openSession();
                session.beginTransaction();
                //add the previous profit and loss to the new profit and loss
                profitLoss.setProfit(String.valueOf(Double.parseDouble(profitLoss.getProfit()) + Double.parseDouble(profit)));
                profitLoss.setLoss(String.valueOf(Double.parseDouble(profitLoss.getLoss()) + Double.parseDouble(loss)));
                session.update(profitLoss);
                session.getTransaction().commit();
                session.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public profitLoss getProfitLossByUserId(int userId) {
        profitLoss profitLoss = null;
        try {
            Session session = this.factory.openSession();
            session.beginTransaction();
            String q = "from profitLoss where user.userId=:i";
            Query query = (Query) session.createQuery(q);
            query.setParameter("i", userId);
            profitLoss = (profitLoss) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profitLoss;
    }


}

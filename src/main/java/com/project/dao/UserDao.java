package com.project.dao;

import com.project.entities.FDAccount;
import com.project.entities.RDAccount;
import com.project.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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

    public boolean updateRDAccount(RDAccount rd) {
        boolean result = false;
        try {
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
        increaseBalancefd(user,fd.getDepositAmount(),fd);
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
        increaseBalancerd(user,rd.getDepositAmount(), rd);
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
    private void increaseBalancefd(Users users, String depositAmount, FDAccount fd) {
        //first check on the fd the deposit amount is greater then or equal to maturity amount
        if(Double.parseDouble(depositAmount) >= Double.parseDouble(fd.getMaturityAmount())){
            //just simply add the maturity amount to the opening balance of the user
            users.setBalance(String.valueOf(Double.parseDouble(users.getBalance()) + Double.parseDouble(fd.getMaturityAmount())));
            //call the update user method to update the user
            updateUser(users);
        }
        else{
            //if the deposit amount is less then the maturity amount then decrease one percent of the deposit amount from fd account and add it to the user
            users.setBalance(String.valueOf(Double.parseDouble(users.getBalance()) + (Double.parseDouble(depositAmount) - (Double.parseDouble(depositAmount) * 0.01))));
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


}

package com.project.dao;

import com.project.entities.Payee;
import com.project.entities.Users;
import com.project.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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
}

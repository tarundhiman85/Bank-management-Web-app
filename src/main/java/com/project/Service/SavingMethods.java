package com.project.Service;

import com.project.entities.FDAccount;
import com.project.entities.RDAccount;
import com.project.entities.Transact;

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
}

package com.project.Service;

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
}

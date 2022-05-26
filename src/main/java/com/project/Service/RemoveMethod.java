package com.project.Service;

import com.project.entities.Payee;
import com.project.entities.Transact;
import com.project.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemoveMethod {
    public boolean removePayee(Payee payee) {
        try {
            Session session = FactoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(payee);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

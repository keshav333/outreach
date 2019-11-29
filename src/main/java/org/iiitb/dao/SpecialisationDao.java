package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Offer;
import org.iiitb.bean.Specialisation;
import org.iiitb.util.SessionUtil;

import java.util.List;

public class SpecialisationDao {

    public static List<Specialisation> findAll() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Specialisation";
        Query query = session.createQuery(hql);

        List<Specialisation> specialisations = query.list();

        transaction.commit();
        session.close();

        return specialisations;
    }
    public static Specialisation find(Integer id) {
        System.out.println(id);
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Specialisation domain = session.get(Specialisation.class, id);
        transaction.commit();
        session.close();
        return domain;
    }
}

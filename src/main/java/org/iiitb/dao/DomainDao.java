package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Offer;
import org.iiitb.bean.UserData;
import org.iiitb.util.SessionUtil;

import java.util.List;

public class DomainDao {

    public static List<Domain> findAll() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Domain";
        Query query = session.createQuery(hql);

        List<Domain> domains = query.list();

        transaction.commit();
        session.close();

        return domains;
    }
    public static Domain find(Integer id) {
        System.out.println(id);
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Domain domain = session.get(Domain.class, id);
        transaction.commit();
        session.close();
        return domain;
    }
}

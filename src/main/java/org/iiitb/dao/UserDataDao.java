package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Offer;
import org.iiitb.bean.UserData;
import org.iiitb.util.SessionUtil;

import java.util.List;

public class UserDataDao {
    public static void save(UserData user) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();
    }
    public static UserData find(String username) {
        System.out.println(username);
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        UserData user = session.get(UserData.class, username);

        transaction.commit();
        session.close();
        return user;
    }
    public static List<UserData> findAll() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM UserData";
        Query query = session.createQuery(hql);

        List<UserData> userdata = query.list();

        transaction.commit();
        session.close();

        return userdata;
    }
}

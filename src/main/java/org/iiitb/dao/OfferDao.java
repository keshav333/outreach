package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Offer;
import org.iiitb.util.SessionUtil;

import java.util.List;

public class OfferDao {
    public static void save(Offer offer) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(offer);

        transaction.commit();
        session.close();
    }
    public static Offer find(Integer id) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Offer domain = session.get(Offer.class, id);

        transaction.commit();
        session.close();
        return domain;
    }
    public static List<Offer> findAll() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        /*String hql = "select o.organisation, o.min_grade, o.max_intake, s.name, d.name\n" +
                "from Offer o, offer_domain od , offer_specialisation os, Domain d, Specialisation s\n" +
                "where d.id = od.domain_id and s.id = os.specialisation_id and o.id = od.domainOffers_id and o.id = specOffers_id";*/
        String hql = "From Offer";
        Query query = session.createQuery(hql);

        List<Offer> domains = query.list();
        System.out.println(domains);

        transaction.commit();
        session.close();

        return domains;
    }

}

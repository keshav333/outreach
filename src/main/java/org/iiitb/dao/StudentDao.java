package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Student;
import org.iiitb.util.SessionUtil;


public class StudentDao {
    public void save(Student student) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(student);
        
        transaction.commit();
        session.close();
    }
    
    public Student find(Integer id) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        Student student = session.get(Student.class, id);
        
        transaction.commit();
        session.close();
        return student;
    }
    
    public Student findByRollNumber(String rollNumber) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "FROM Student WHERE rollNumber = :roll_number";
        Query query = session.createQuery(hql);
        query.setParameter("roll_number", rollNumber);
        Student student = (Student) query.getSingleResult();
        
        transaction.commit();
        session.close();
        return student;
    }
    
    public String getLastRollNumber(Domain domain) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "SELECT s.rollNumber FROM Student s, Domain d WHERE s.domain = d AND d = :givenDomain ORDER BY s.rollNumber DESC";
        Query query = session.createQuery(hql);
        query.setParameter("givenDomain", domain);
        String rollNumber = (String) query.list().get(0);
        
        transaction.commit();
        session.close();
        return rollNumber;
    }
}
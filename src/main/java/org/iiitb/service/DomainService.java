package org.iiitb.service;

import org.iiitb.bean.Domain;
import org.iiitb.bean.Offer;
import org.iiitb.bean.Specialisation;
import org.iiitb.dao.DomainDao;
import org.iiitb.dao.OfferDao;

import java.util.List;

public interface DomainService {
    DomainDao domainDao = new DomainDao();

    List<Domain> findAll();
    Domain find(Integer id);
}

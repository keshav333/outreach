package org.iiitb.service;

import org.iiitb.bean.Offer;
import org.iiitb.dao.OfferDao;

import java.util.List;

public interface OfferService {

    OfferDao offerDao = new OfferDao();

    void save(Offer offer);

    Offer find(Integer id);

    List<Offer> findAll();
}

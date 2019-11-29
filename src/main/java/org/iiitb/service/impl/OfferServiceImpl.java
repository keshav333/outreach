package org.iiitb.service.impl;

import org.iiitb.bean.Offer;
import org.iiitb.dao.OfferDao;
import org.iiitb.service.OfferService;

import java.util.List;

public class OfferServiceImpl implements OfferService {
    @Override
    public void save(Offer offer) {
        OfferDao.save(offer);
    }

    @Override
    public Offer find(Integer id) {
        return OfferDao.find(id);
    }

    @Override
    public List<Offer> findAll() {
        return OfferDao.findAll();
    }


}

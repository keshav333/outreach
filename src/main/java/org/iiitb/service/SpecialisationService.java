package org.iiitb.service;

import org.iiitb.bean.Offer;
import org.iiitb.bean.Specialisation;
import org.iiitb.bean.UserData;
import org.iiitb.dao.OfferDao;
import org.iiitb.dao.SpecialisationDao;

import java.util.List;

public interface SpecialisationService {
    SpecialisationDao SpecialisationDao = new SpecialisationDao();

    List<Specialisation> findAll();
    Specialisation find(Integer id);
}

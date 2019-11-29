package org.iiitb.service.impl;

import org.iiitb.bean.Specialisation;
import org.iiitb.bean.UserData;
import org.iiitb.dao.SpecialisationDao;
import org.iiitb.dao.UserDataDao;
import org.iiitb.service.SpecialisationService;

import java.util.List;

public class SpecialisationServiceImpl implements SpecialisationService {
    @Override
    public List<Specialisation> findAll() {
        return SpecialisationDao.findAll();
    }
    @Override
    public Specialisation find(Integer id) {
        return org.iiitb.dao.SpecialisationDao.find(id);
    }
}

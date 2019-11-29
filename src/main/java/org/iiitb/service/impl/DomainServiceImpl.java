package org.iiitb.service.impl;

import org.iiitb.bean.Domain;
import org.iiitb.bean.Specialisation;
import org.iiitb.bean.UserData;
import org.iiitb.dao.DomainDao;
import org.iiitb.dao.UserDataDao;
import org.iiitb.service.DomainService;

import java.util.List;

public class DomainServiceImpl implements DomainService {
    @Override
    public List<Domain> findAll() {
        return DomainDao.findAll();
    }
    @Override
    public Domain find(Integer id) {
        return DomainDao.find(id);
    }
}

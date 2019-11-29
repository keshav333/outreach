package org.iiitb.service.impl;

import org.iiitb.bean.Offer;
import org.iiitb.bean.UserData;
import org.iiitb.dao.OfferDao;
import org.iiitb.dao.UserDataDao;
import org.iiitb.service.UserDataService;

import java.util.List;

public class UserDataServiceImpl implements UserDataService {

    @Override
    public void save(UserData userdata) {
        UserDataDao.save(userdata);
    }

    @Override
    public UserData find(String username) {
        return UserDataDao.find(username);
    }
    @Override
    public List<UserData> findAll() {
        return UserDataDao.findAll();
    }

}

package org.iiitb.service;

import org.iiitb.bean.Offer;
import org.iiitb.bean.UserData;
import org.iiitb.dao.UserDataDao;

import java.util.List;

public interface UserDataService {
    UserDataDao userDao = new UserDataDao();

    void save(UserData userdata);

    UserData find(String username);

    List<UserData> findAll();
}

package com.decrises.urlshortenerservice.service.impl;

import com.decrises.urlshortenerservice.dao.UserProfileDAO;
import com.decrises.urlshortenerservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserProfileDAO userProfileDAO;

    @Override
    public boolean deleteUserProfile(String username) {
        return userProfileDAO.deleteUserProfile(username);
    }
}

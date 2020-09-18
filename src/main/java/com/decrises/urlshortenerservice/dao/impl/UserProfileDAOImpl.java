package com.decrises.urlshortenerservice.dao.impl;

import com.decrises.urlshortenerservice.dao.UserProfileDAO;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDAOImpl implements UserProfileDAO {

    @Override
    public boolean deleteUserProfile(String username) {
        return false;
    }
}

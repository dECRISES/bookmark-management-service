package com.decrises.urlshortenerservice.service.impl;

import com.decrises.urlshortenerservice.dao.CardDAO;
import com.decrises.urlshortenerservice.entity.Card;
import com.decrises.urlshortenerservice.service.GroupManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupManagementServiceImpl implements GroupManagementService {

    @Autowired
    private CardDAO cardDAO;

    @Override
    public List<Card> getGroups() {
        return cardDAO.getGroups();
    }

    @Override
    public boolean updateGroup(int groupId) {
        return cardDAO.updateGroup(groupId);
    }

    @Override
    public boolean deleteGroup(Long groupId) {
        return cardDAO.deleteGroup(groupId);
    }


}

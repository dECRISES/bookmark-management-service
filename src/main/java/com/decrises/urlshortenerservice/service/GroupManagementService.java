package com.decrises.urlshortenerservice.service;

import com.decrises.urlshortenerservice.entity.Card;

import java.util.List;

public interface GroupManagementService {

    List<Card> getGroups();

    boolean updateGroup(int groupId);

    boolean deleteGroup(Long groupId);
}

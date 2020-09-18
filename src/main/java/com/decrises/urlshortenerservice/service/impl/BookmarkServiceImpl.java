package com.decrises.urlshortenerservice.service.impl;

import com.decrises.urlshortenerservice.dao.CardDAO;
import com.decrises.urlshortenerservice.entity.Card;
import com.decrises.urlshortenerservice.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    private CardDAO cardDAO;


    @Override
    public List<Card> getCards() {
        return cardDAO.getCards();
    }

    @Override
    public Card getCard(Long cardId) {
        return cardDAO.getCard(cardId);
    }

    @Override
    public boolean updateCard(int cardId) {
        return cardDAO.updateCard(cardId);
    }

    @Override
    public boolean deleteCard(Long cardId) {
        return cardDAO.deleteCard(cardId);
    }

    @Override
    public List<Card> getCardsForGroup(int groupId) {
        return cardDAO.getCardsForGroups(groupId);
    }

    @Override
    public boolean deleteCardForGroup(int groupId, int cardId) {
        return cardDAO.deleteCardForGroup(groupId, cardId);
    }

    @Override
    public boolean updateCardForGroup(int groupId, int cardId) {
        return cardDAO.updateCardForGroup(groupId, cardId);
    }
}

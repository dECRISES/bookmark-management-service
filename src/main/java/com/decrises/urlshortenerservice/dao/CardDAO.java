package com.decrises.urlshortenerservice.dao;

import com.decrises.urlshortenerservice.entity.Card;

import java.util.List;

public interface CardDAO {

    List<Card> getCards();

    Card getCard(Long cardId);

    boolean updateCard(int cardId);

    boolean deleteCard(Long cardId);

    List<Card> getCardsForGroups(int groupId);

    boolean deleteCardForGroup(int groupId, int cardId);

    boolean updateCardForGroup(int groupId, int cardId);

    List<Card> getGroups();

    boolean updateGroup(int groupId);

    boolean deleteGroup(Long groupId);

}

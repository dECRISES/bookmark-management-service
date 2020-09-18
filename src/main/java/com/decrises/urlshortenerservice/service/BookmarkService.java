package com.decrises.urlshortenerservice.service;

import com.decrises.urlshortenerservice.entity.Card;

import java.util.List;

public interface BookmarkService {

    List<Card> getCards();

    Card getCard(Long cardId);

    boolean updateCard(int cardId);

    boolean deleteCard(Long cardId);

    List<Card> getCardsForGroup(int groupId);

    boolean deleteCardForGroup(int groupId, int cardId);

    boolean updateCardForGroup(int groupId, int cardId);

}

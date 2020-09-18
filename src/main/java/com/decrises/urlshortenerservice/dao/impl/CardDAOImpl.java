package com.decrises.urlshortenerservice.dao.impl;

import com.decrises.urlshortenerservice.dao.CardDAO;
import com.decrises.urlshortenerservice.entity.Card;
import com.decrises.urlshortenerservice.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardDAOImpl implements CardDAO {

/*    @Autowired
    private ModelMapper modelMapper;*/

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getCards() {
        return cardRepository.getCardsAccordingToType("tinyurl");
    }

    @Override
    public Card getCard(Long cardId) {
        return cardRepository.getCardByCardId(cardId);
    }

    @Override
    public boolean updateCard(int cardId) {
        return false;
    }

    @Override
    public boolean deleteCard(Long cardId) {
        return cardRepository.deleteCardByCardId(cardId);
    }

    @Override
    public List<Card> getCardsForGroups(int groupId) {
        return null;
    }

    @Override
    public boolean deleteCardForGroup(int groupId, int cardId) {
        return false;
    }

    @Override
    public boolean updateCardForGroup(int groupId, int cardId) {
        return false;
    }

    @Override
    public List<Card> getGroups() {
        return null;
    }

    @Override
    public boolean updateGroup(int groupId) {
        return false;
    }

    @Override
    public boolean deleteGroup(Long groupId) {
        return cardRepository.deleteCardByCardId(groupId);
    }

    /*    private CardModel convertToModel(Card card) {
        return modelMapper.map(card, CardModel.class);
    }*/

}

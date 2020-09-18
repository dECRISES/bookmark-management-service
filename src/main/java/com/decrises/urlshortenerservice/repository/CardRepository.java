package com.decrises.urlshortenerservice.repository;

import com.decrises.urlshortenerservice.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("select c from Card c where c.type=:type")
    List<Card> getCardsAccordingToType(@Param("type") String type);

    @Query("select c from Card c where c.cardId=:cardId")
    Card getCardByCardId(@Param("cardId") Long cardId);

    boolean deleteCardByCardId(Long cardId);
}

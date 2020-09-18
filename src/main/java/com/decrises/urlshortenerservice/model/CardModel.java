package com.decrises.urlshortenerservice.model;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class CardModel {

    private Long cardId;
    private String title;
    private String icon;
    private String image;
    private String description;
    private String createdBy;
    private Date createdDate;
    private CardModel group;
    private Set<CardModel> subordinates;

}

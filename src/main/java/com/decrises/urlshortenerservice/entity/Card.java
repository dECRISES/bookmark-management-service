package com.decrises.urlshortenerservice.entity;

import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name="card")
public class Card {

    @Id
    @Column(name="EMPLOYEE_ID")
    @GeneratedValue
    private Long cardId;

    @Column(name="TITLE")
    private String title;

    @Column(name="TYPE")
    private String type;

    @Column(name="ICON")
    private String icon;

    @Column(name="IMAGE")
    private String image;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="CREATEDBY")
    private String createdBy;

    @Column(name="CREATEDDATE")
    private Date createdDate;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="group_id")
    private Card group;

    @OneToMany(mappedBy="group")
    private Set<Card> subordinates = new HashSet<Card>();

    public Card() {
    }

    public Card(String title, String description) {
        this.title = title;
        this.description = description;
    }

}

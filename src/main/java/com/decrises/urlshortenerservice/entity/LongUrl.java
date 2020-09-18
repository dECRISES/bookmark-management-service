package com.decrises.urlshortenerservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "UrlDirectory")
public class LongUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String longUrl;

    @Column(nullable = false)
    private Date createdDate;

    private Date expiryDate;

}

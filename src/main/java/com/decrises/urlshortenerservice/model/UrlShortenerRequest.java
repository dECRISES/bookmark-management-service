package com.decrises.urlshortenerservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class UrlShortenerRequest {

    private String longUrl;
    private Date expiryDate;

}

package com.decrises.urlshortenerservice.controller;

import com.decrises.urlshortenerservice.service.UrlShortenerService;
import com.decrises.urlshortenerservice.model.UrlShortenerRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/url")
@Tag(name = "Url Shortener Service", description = "Url Shortener Service")
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping("create-tiny-url")
    public String convertToShortUrl(@RequestBody UrlShortenerRequest request) {
        return urlShortenerService.generateTinyUrl(request);
    }

    @GetMapping(value = "{shortUrl}")
    @Cacheable(value = "urls", key = "#shortUrl", sync = true)
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {
        var url = urlShortenerService.getOriginalUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }


}

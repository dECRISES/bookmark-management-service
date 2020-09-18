package com.decrises.urlshortenerservice.service;

import com.decrises.urlshortenerservice.entity.LongUrl;
import com.decrises.urlshortenerservice.model.UrlShortenerRequest;
import com.decrises.urlshortenerservice.repository.LongUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class UrlShortenerService {

    private final LongUrlRepository longUrlRepository;
    private final Base62ConvertorService base62ConvertorService;

    @Autowired
    public UrlShortenerService(LongUrlRepository longUrlRepository, Base62ConvertorService base62ConvertorService) {
        this.longUrlRepository = longUrlRepository;
        this.base62ConvertorService = base62ConvertorService;
    }
    
    public String generateTinyUrl(UrlShortenerRequest request) {
        var url = new LongUrl();
        url.setLongUrl(request.getLongUrl());
        url.setExpiryDate(request.getExpiryDate());
        url.setCreatedDate(new Date());
        var entity = longUrlRepository.save(url);

        return base62ConvertorService.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl) {
        var id = base62ConvertorService.decode(shortUrl);
        var entity = longUrlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));

        if (entity.getExpiryDate() != null && entity.getExpiryDate().before(new Date())){
            longUrlRepository.delete(entity);
            throw new EntityNotFoundException("Link expired!");
        }

        return entity.getLongUrl();
    }
}

package com.decrises.urlshortenerservice.repository;

import com.decrises.urlshortenerservice.entity.LongUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongUrlRepository extends JpaRepository<LongUrl, Long> {
}

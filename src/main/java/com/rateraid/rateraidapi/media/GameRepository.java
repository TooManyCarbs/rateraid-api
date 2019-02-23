package com.rateraid.rateraidapi.media;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface GameRepository extends PagingAndSortingRepository<Game, Long> {

    @RestResource(rel = "title-contains", path = "containsTitle")
    Page<Game> findByTitleContaining(@Param("title") String title, Pageable page);
}

package com.KonList.repository;

import com.KonList.model.anime.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    boolean existsByTitle(String name);

    Optional<Anime> findByTitle(String animeName);
}

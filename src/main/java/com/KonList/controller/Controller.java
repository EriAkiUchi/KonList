package com.KonList.controller;

import com.KonList.exception.ValidationException;
import com.KonList.model.anime.Anime;
import com.KonList.model.anime.AnimeDTO;
import com.KonList.serve.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private AnimeService animeService;

    @GetMapping("/anime/{animeName}")
    public ResponseEntity<?> getAnimeByName(@PathVariable String animeName) {
        try {
            AnimeDTO anime = animeService.getAnime(animeName);
            return ResponseEntity.ok(anime);
        } catch (ValidationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/anime/s/{animeId}")
    public ResponseEntity<String> saveAnimeById(@PathVariable String animeId) {
        try {
            Anime anime = animeService.getAnimeById(animeId);
            System.out.println(anime);
            animeService.saveAnime(anime);
            return ResponseEntity.ok().build();
        } catch (ValidationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/anime/d/{animeName}")
    public ResponseEntity<String> deleteAnime(@PathVariable String animeName) {
        try {
            animeService.deleteAnime(animeName);
            return ResponseEntity.ok().build();
        } catch (ValidationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}

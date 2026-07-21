package com.KonList.serve;

import com.KonList.exception.ValidationException;
import com.KonList.model.anime.*;
import com.KonList.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

//    @Autowired
//    private ConvertData convertData;

    public AnimeDTO getAnime(String animeName) {
        ConsumeApi consumeApi = new ConsumeApi();
        ConvertData convertData = new ConvertData();
//        Optional<Anime> optional;
        String ADDRESS_ANIME_NAME = "https://api.tenrai.org/v1/anime?q=";
        String queryParameter = "&limit=5";

        String nameParameter = animeName.replaceAll(" ", "+");

        String returnedJson = consumeApi.getData(ADDRESS_ANIME_NAME + nameParameter + queryParameter);

        //get the data from the field "data" from response
        ArrayList<AnimeDTO> jsonData = convertData.getData(returnedJson, AnimeSearchResponse.class).data();

        //match the name given with one of the titles
        Optional<AnimeDTO> result = jsonData.stream()
                .filter(a -> a.titles()
                                        .stream()
                                        .anyMatch(t ->
                                                t.title().toLowerCase().contains(animeName.toLowerCase())
                                        )
                )
                .findFirst();

//        System.out.println(result);

        if (result.isEmpty()) {
            throw new ValidationException("No anime found with the query " + animeName);
        }
        else {
            return result.get();
        }
    }

    public Anime getAnimeById(String id) {
        ConsumeApi consumeApi = new ConsumeApi();
        ConvertData convertData = new ConvertData();

        String ADDRESS_ANIME_ID = "https://api.jikan.moe/v4/anime/";
        String returnedJson = consumeApi.getData(ADDRESS_ANIME_ID + id);

        //get the data from the field "data" from response
        AnimeDTO jsonData = convertData.getData(returnedJson, AnimeDetailResponse.class).data();

        if (jsonData == null) {
            throw new ValidationException("No anime found with the id " + id);
        }

        //return the data transformed into the Entity class
        return AnimeMapper.toEntity(jsonData);

    }

    public void saveAnime(Anime anime) {
        boolean alreadyExists = animeRepository.existsByTitle(anime.getTitle());

        if(alreadyExists) {
            throw new ValidationException("Anime already exists in database");
        }
        animeRepository.save(anime);
    }

    public void deleteAnime(String animeName) {
        Optional<Anime> anime = animeRepository.findByTitle(animeName);

        if(anime.isEmpty()) {
            throw new ValidationException("Anime not found in DB.");
        }

        animeRepository.delete(anime.get());
    }
}

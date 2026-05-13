package com.KonList.model.anime;

import com.KonList.model.Genre.GenreData;
import com.KonList.model.Rating;
import com.KonList.model.Studio.StudioData;
import com.KonList.model.Type;

//convert AnimeDTO into Anime
//decouples Anime with the API in order to separate the responsibilities
public class AnimeMapper {
    public static Anime toEntity(AnimeDTO data) {
        Anime anime = new Anime();

        anime.setTitle(data.title());
        anime.setSynopsis(data.synopsis());
        anime.setScore(data.score());
        anime.setSource(data.source());
        anime.setNumberEpisodes(data.numberEpisodes());

        if (data.type() != null) {
            anime.setType(Type.valueOf(data.type().toUpperCase()));
        }

        if (data.rating() != null) {
            anime.setRating(Rating.fromString(data.rating()));
        }

        if (data.genres() != null) {
            anime.setGenres(
                    data.genres().stream()
                            .map(GenreData::name)
                            .toList()
            );
        }

        if (data.studios() != null) {
            anime.setStudios(
                    data.studios().stream()
                            .map(StudioData::name)
                            .toList()
            );
        }

        return anime;
    }
}

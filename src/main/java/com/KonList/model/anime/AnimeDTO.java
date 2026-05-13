package com.KonList.model.anime;

import com.KonList.model.Genre.GenreData;
import com.KonList.model.Studio.StudioData;
import com.KonList.model.Title.TitleData;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnimeDTO(String title,
                       Long mal_id,
                       String synopsis,
                       Double score,
                       String source,
                       @JsonAlias("episodes") Integer numberEpisodes,
                       String type,
                       String rating,
                       List<TitleData> titles,
                       List<StudioData> studios,
                       List<GenreData> genres) {
}

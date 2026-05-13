package com.KonList.model.anime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnimeDetailResponse(AnimeDTO data) {
}

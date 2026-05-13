package com.KonList.model.anime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

//get all data from the response
@JsonIgnoreProperties(ignoreUnknown = true)
public record AnimeSearchResponse(ArrayList<AnimeDTO> data) {
}

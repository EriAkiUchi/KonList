package com.KonList.model.anime;

import com.KonList.model.Genre.GenreData;
import com.KonList.model.Rating;
import com.KonList.model.Studio.StudioData;
import com.KonList.model.Type;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "animes")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Lob //indicates to jpa that this is a large text field
    private String synopsis;

    private Double score;
    private String source;
    private Integer numberEpisodes;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @ElementCollection //strings of studios
    private List<String> studios;

    @ElementCollection //strings of genres
    private List<String> genres;

    public Anime(){}

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Double getScore() {
        return score;
    }

    public String getSource() {
        return source;
    }

    public Integer getNumberEpisodes() {
        return numberEpisodes;
    }

    public Type getType() {
        return type;
    }

    public Rating getRating() {
        return rating;
    }

    public List<String> getStudios() {
        return studios;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setNumberEpisodes(Integer numberEpisodes) {
        this.numberEpisodes = numberEpisodes;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setStudios(List<String> studios) {
        this.studios = studios;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

//    @Override
//    public String toString() {
//        return "Name: " + this.getTitle() +
//                "\nScore: " + this.getScore() +
//                "\nSource: " + this.getSource() +
//                "\nEpisodes: " + this.getNumberEpisodes() +
//                "\nGenres: " + this.getGenres() +
//                "\nRating: " + this.getRating() +
//                "\nStudios: " + this.getStudios() +
//                "\nType: " + this.getType();
//    }
}

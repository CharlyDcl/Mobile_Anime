package fr.esiea.anime.Model.Anime;

import com.google.gson.annotations.SerializedName;

public class AnimeSearchResponse {

    private String title;

    @SerializedName("mal_id")
    private Integer id;

    @SerializedName("image_url")
    private String image;

    private String synopsis;

    @SerializedName("episodes")
    private Integer nb_episodes;

    private Double score;

    public AnimeSearchResponse(String title, Integer id, String image, String synopsis, Integer nb_episodes, Double score) {
        this.title = title;
        this.id = id;
        this.image = image;
        this.synopsis = synopsis;
        this.nb_episodes = nb_episodes;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getNb_episodes() {
        return nb_episodes;
    }

    public void setNb_episodes(Integer nb_episodes) {
        this.nb_episodes = nb_episodes;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}

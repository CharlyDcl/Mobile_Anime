package fr.esiea.anime.Model.Anime;

import com.google.gson.annotations.SerializedName;

public class AnimeResponse {

    private String title;

    private String title_english;

    @SerializedName("mal_id")
    private Integer id;

    @SerializedName("image_url")
    private String image;

    private String url;

    @SerializedName("trailer_url")
    private String trailer;

    private Integer episodes;

    private String duration;

    private Double score;

    private Integer rank;

    private String background;

    private String synopsis;

    public AnimeResponse(String title, String title_english, Integer id, String image, String url, String trailer, Integer episodes, String duration, Double score, Integer rank, String background, String synopsis) {
        this.title = title;
        this.title_english = title_english;
        this.id = id;
        this.image = image;
        this.url = url;
        this.trailer = trailer;
        this.episodes = episodes;
        this.duration = duration;
        this.score = score;
        this.rank = rank;
        this.background = background;
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_english() {
        return title_english;
    }

    public void setTitle_english(String title_english) {
        this.title_english = title_english;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}

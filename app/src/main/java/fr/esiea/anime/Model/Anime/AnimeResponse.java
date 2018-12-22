package fr.esiea.anime.Model.Anime;

import com.google.gson.annotations.SerializedName;

public class AnimeResponse {

    private String title;

    @SerializedName("mal_id")
    private int id;

    private String url;

    @SerializedName("trailer_url")
    private String trailer;

    private Integer episodes;

    private String duration;

    private Double score;

    private Integer rank;

    private String background;

    private String synopsis;

    public AnimeResponse(String title, int id, String url, String trailer, Integer episodes, String duration, Double score, Integer rank, String background, String synopsis) {
        this.title = title;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

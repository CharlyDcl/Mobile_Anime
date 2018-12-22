package fr.esiea.anime.Model.Anime;

import com.google.gson.annotations.SerializedName;

public class Anime {

    private String title;

    @SerializedName("mal_id")
    private int id;

    private String firebase_id;

    private String url;

    @SerializedName("trailer_url")
    private String trailer;

    private String episodes;

    private String duration;

    private String score;

    private String rank;

    private String background;

    private String synopsis;

    public Anime() {
    }

    public Anime(String title, int id, String firebase_id, String trailer, String episodes, String duration, String score, String rank, String background, String synopsis) {
        this.title = title;
        this.id = id;
        this.firebase_id = firebase_id;
        //this.url = url;
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

    public String getFirebase_id() {
        return firebase_id;
    }

    public void setFirebase_id(String firebase_id) {
        this.firebase_id = firebase_id;
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

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
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

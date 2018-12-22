package fr.esiea.anime.ViewModel;

import android.databinding.ObservableField;

public class FavoriteItemViewModel {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> synopsis = new ObservableField<>();
    public ObservableField<String> episodes = new ObservableField<>();
    public ObservableField<String> score = new ObservableField<>();
    public String id_database;

    public FavoriteItemViewModel(String title, String synopsis, String episodes, String score, String id_database) {
        this.title.set(title);
        this.synopsis.set(synopsis);
        this.episodes.set(episodes);
        this.score.set(score);
        this.id_database = id_database;
    }

}

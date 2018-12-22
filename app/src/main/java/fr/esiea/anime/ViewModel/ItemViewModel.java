package fr.esiea.anime.ViewModel;

import android.content.Context;
import android.databinding.ObservableField;

import java.util.Random;

public class ItemViewModel {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();
    public ObservableField<String> episodes = new ObservableField<>();
    public ObservableField<String> score = new ObservableField<>();
    public int id;

    public ItemViewModel(Context context, String title, String descr, Integer episodes, Double score, int id){
        this.title.set(title);
        this.description.set(descr);
        this.episodes.set(episodes.toString());
        this.score.set(score.toString());
        this.id = id;
    }

}

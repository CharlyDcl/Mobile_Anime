package fr.esiea.anime.ViewModel;

import android.content.Context;
import android.databinding.ObservableField;

import java.util.Random;

public class ItemViewModel {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();
    public ObservableField<String> episodes = new ObservableField<>();
    public ObservableField<String> score = new ObservableField<>();
    public Integer id;

    static Random random = new Random();
    public int value;

    public ItemViewModel(Context context, String title, String descr, Integer episodes, Double score, Integer id){
        assign(random.nextInt(100) + 1);
        this.title.set(title);
        this.description.set(descr);
        this.episodes.set(episodes.toString());
        this.score.set(score.toString());
        this.id = id;
    }

    public void squareTwo() {
        assign(value*2);
    }

    private void assign(int x) {
        value = x;
        title.set(String.valueOf(x*2));
        description.set(String.valueOf(x));
    }
}

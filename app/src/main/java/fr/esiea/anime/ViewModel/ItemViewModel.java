package fr.esiea.anime.ViewModel;

import android.content.Context;
import android.databinding.ObservableField;

import java.util.Random;

public class ItemViewModel {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();
    public ObservableField<Integer> episodes = new ObservableField<>();
    public ObservableField<Double> score = new ObservableField<>();

    static Random random = new Random();
    public int value;

    public ItemViewModel(Context context, String title, String descr, Integer episodes, Double score){
        assign(random.nextInt(100) + 1);
        this.title.set(title);
        this.description.set(descr);
        this.episodes.set(episodes);
        this.score.set(score);
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

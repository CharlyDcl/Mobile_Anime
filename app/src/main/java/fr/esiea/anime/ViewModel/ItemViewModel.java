package fr.esiea.anime.ViewModel;

import android.databinding.ObservableField;

import java.util.Random;

public class ItemViewModel {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();

    static Random random = new Random();
    private int value;

    public ItemViewModel(){
        assign(random.nextInt(100) + 1);
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

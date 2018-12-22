package fr.esiea.anime.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.util.Log;

import fr.esiea.anime.View.MainActivity;

public class ItemListViewModel {

    public ObservableField<String> screenTitle = new ObservableField<>();
    public ObservableArrayList<ItemViewModel> items = new ObservableArrayList<>();
    Context context;
    public ItemListViewModel(Context context) {

        this.context = context;
        screenTitle.set("This is a list of (x & y) where x = y * 2, click on any cell and then: y = y * 2 ");
        for (int i = 0; i < 10; i++) {
            //generateItem();
        }

    }

    public void ReadFromApi() {

    }

    public void clear() {
        items.clear();
    }

    public void generateItem(String title, String descr, Integer episodes, Double score) {
        items.add(items.size(), new ItemViewModel(context, title, descr, episodes, score));
    }

    public void onItemTapped(Object item){
        Log.d("itemclick", "onItemTapped: " + ((ItemViewModel) item).description.get());
        ((ItemViewModel)item).squareTwo();
        context.startActivity(new Intent(context, MainActivity.class));
    }

}

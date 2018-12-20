package fr.esiea.anime.ViewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

public class ItemListViewModel {

    public ObservableField<String> screenTitle = new ObservableField<>();
    public ObservableArrayList<ItemViewModel> items = new ObservableArrayList<>();


    public ItemListViewModel() {

        screenTitle.set("This is a list of (x & y) where x = y * 2, click on any cell and then: y = y * 2 ");

        for (int i = 0; i < 10; i++) {
            generateItem();
        }
    }

    public void clear() { items.clear(); }
    public void generateItem() { items.add(items.size(), new ItemViewModel());}
    public void onItemTapped(Object item){ ((ItemViewModel)item).squareTwo(); }
}

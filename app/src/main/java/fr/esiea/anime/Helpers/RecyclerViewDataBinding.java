package fr.esiea.anime.Helpers;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class RecyclerViewDataBinding<T> {

    @BindingAdapter({"itemsSource", "itemTemplate", "onItemTapped"})
    public void bind(RecyclerView recyclerView, List<T> items, int itemTemplate, GenericAdapter.ItemTappedListener onItemTapped) {
        recyclerView.setAdapter(new GenericAdapter(items, itemTemplate, DataBindingUtil.findBinding(recyclerView), onItemTapped));
    }

    @BindingAdapter({"onItemTapped"})
    public void bind(RecyclerView recyclerView, GenericAdapter.ItemTappedListener itemTapped) {
    }
}
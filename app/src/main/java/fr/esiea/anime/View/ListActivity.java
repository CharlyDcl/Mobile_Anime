package fr.esiea.anime.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.esiea.anime.R;
import fr.esiea.anime.ViewModel.ItemListViewModel;
import fr.esiea.anime.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        binding.setViewmodel( new ItemListViewModel());
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager( new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration( new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }
}

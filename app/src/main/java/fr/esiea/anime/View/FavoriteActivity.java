package fr.esiea.anime.View;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import fr.esiea.anime.R;
import fr.esiea.anime.ViewModel.FavoriteItemListViewModel;
import fr.esiea.anime.databinding.FavoriteListBinding;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FavoriteListBinding binding = DataBindingUtil.setContentView(this, R.layout.favorite_list);
        binding.setViewmodel( new FavoriteItemListViewModel(getApplicationContext()));
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.favorite_recycler_view);
        recyclerView.setLayoutManager( new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration( new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                startActivity( new Intent(this, ListActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

package fr.esiea.anime.View;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import fr.esiea.anime.R;
import fr.esiea.anime.ViewModel.DetailViewModel;
import fr.esiea.anime.databinding.DetailActivityBinding;

//Deatil anime from search activity
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        DetailActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.detail_activity);
        binding.setViewmodel( new DetailViewModel(getApplicationContext(), getIntent().getExtras().getInt("ID_ELEMENT")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorite:
                startActivity(new Intent(this, FavoriteActivity.class));
                return true;

            case R.id.search:
                startActivity( new Intent(this, ListActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

package fr.esiea.anime.View;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fr.esiea.anime.R;
import fr.esiea.anime.ViewModel.MainViewModel;
import fr.esiea.anime.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(new MainViewModel());
    }

    public void newActivity(View v) {
        startActivity(new Intent(this, ListActivity.class));
    }
}

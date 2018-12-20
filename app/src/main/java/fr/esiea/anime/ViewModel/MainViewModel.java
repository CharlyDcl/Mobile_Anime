package fr.esiea.anime.ViewModel;

import android.databinding.ObservableField;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fr.esiea.anime.Model.Anime.AnimeResponse;
import fr.esiea.anime.Model.Api.ApiAnime;
import fr.esiea.anime.Model.Api.ApiInterface;
import fr.esiea.anime.Model.Anime.ResultAnime;
import fr.esiea.anime.Model.User;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel {

    public ObservableField<String> helloText = new ObservableField<>("");
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference myRefUsers = database.getReference().child("users");

    public MainViewModel() {
        myRef.child("texte").setValue(helloText.get());
        ApiAnime.getRetrofitInstance().create(ApiInterface.class).getAnimesByTitle("naruto").enqueue(new Callback<ResultAnime>() {
            @Override
            public void onResponse(retrofit2.Call<ResultAnime> call, Response<ResultAnime> response) {
                Log.d("data", "onResponse: " + response.body().getResults().get(0).getSynopsis());

            }

            @Override
            public void onFailure(retrofit2.Call<ResultAnime> call, Throwable t) {
                Log.d("error", "onFailure: " + t.getMessage());
            }
        });

        ApiAnime.getRetrofitInstance().create(ApiInterface.class).getAnimeByID(20).enqueue(new Callback<AnimeResponse>() {
            @Override
            public void onResponse(retrofit2.Call<AnimeResponse> call, Response<AnimeResponse> response) {
                Log.d("dataAnime", "onResponse: " + response.body().getSynopsis());
            }

            @Override
            public void onFailure(retrofit2.Call<AnimeResponse> call, Throwable t) {
                Log.d("error", "onFailure: " + t.getMessage());
            }
        });
    }

    public void database() {
        myRef.child("onbuttonclick").setValue(helloText.get());
        Log.d("data", "database: " + helloText.get());
        String id = myRefUsers.push().getKey();
        User user = new User(helloText.get(),helloText.get().toUpperCase(), id);
        myRefUsers.child(id).setValue(user);
        Log.d("data", "database: " + user);
    }
}

package fr.esiea.anime.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fr.esiea.anime.Model.Anime.Anime;
import fr.esiea.anime.Model.Anime.AnimeResponse;
import fr.esiea.anime.Model.Api.ApiAnime;
import fr.esiea.anime.Model.Api.ApiInterface;
import fr.esiea.anime.View.FavoriteActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailViewModel {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> synopsis = new ObservableField<>();
    public ObservableField<String> nb_episode = new ObservableField<>();
    public ObservableField<String> score = new ObservableField<>();
    public ObservableField<String> trailer = new ObservableField<>();
    public ObservableField<String> background = new ObservableField<>();
    public ObservableField<String> duration = new ObservableField<>();
    public ObservableField<String> rank = new ObservableField<>();
    Context context;
    int id;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("animes");

    public DetailViewModel(Context context, int id_api) {
        this.id = id_api;
        this.context = context;
        ApiDetailAnime();
    }

    public void ApiDetailAnime() {
        ApiAnime.getRetrofitInstance().create(ApiInterface.class).getAnimeByID(id).enqueue(new Callback<AnimeResponse>() {
            @Override
            public void onResponse(Call<AnimeResponse> call, Response<AnimeResponse> response) {
                AnimeResponse anime = response.body();
                title.set(anime.getTitle());
                synopsis.set(anime.getSynopsis());
                nb_episode.set(anime.getEpisodes().toString());
                score.set(anime.getScore().toString());
                trailer.set(anime.getTrailer());
                background.set(anime.getBackground());
                duration.set(anime.getDuration());
                rank.set(anime.getRank().toString());
            }

            @Override
            public void onFailure(Call<AnimeResponse> call, Throwable t) {
                Log.d("data detail anime", "onFailure: " + t.getMessage());
            }
        });
    }

    public void writeToFirebase() {
        String push_id = myRef.push().getKey();
        Anime animeToStore = new Anime(title.get(), id, push_id, trailer.get(), nb_episode.get(), duration.get(), score.get(), rank.get(), background.get(), synopsis.get());
        myRef.child(push_id).setValue(animeToStore);
        context.startActivity( new Intent(context, FavoriteActivity.class));
    }
}

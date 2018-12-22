package fr.esiea.anime.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.util.Log;

import java.util.List;

import fr.esiea.anime.Model.Anime.AnimeSearchResponse;
import fr.esiea.anime.Model.Anime.ResultAnime;
import fr.esiea.anime.Model.Api.ApiAnime;
import fr.esiea.anime.Model.Api.ApiInterface;
import fr.esiea.anime.View.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListViewModel {

    public ObservableField<String> screenTitle = new ObservableField<>();
    public ObservableArrayList<ItemViewModel> items = new ObservableArrayList<>();
    public ObservableField<String> search = new ObservableField<>("");
    Context context;

    public ItemListViewModel(final Context context) {

        this.context = context;
        screenTitle.set("This is a list of (x & y) where x = y * 2, click on any cell and then: y = y * 2 ");

        ReadFromApi();
    }

    public void ReadFromApi() {
        ApiAnime.getRetrofitInstance().create(ApiInterface.class).getAnimesByTitle("naruto").enqueue(new Callback<ResultAnime>() {
            @Override
            public void onResponse(Call<ResultAnime> call, Response<ResultAnime> response) {
                List<AnimeSearchResponse> list = response.body().getResults();
                for (AnimeSearchResponse element : list) {
                    items.add(items.size(), new ItemViewModel(context, element.getTitle(), element.getSynopsis(), element.getNb_episodes(), element.getScore(), element.getId()));
                    Log.d("data api", "onResponse: " + element.getTitle());
                }
            }

            @Override
            public void onFailure(Call<ResultAnime> call, Throwable t) {
                Log.d("error", "onFailure: " + t.getMessage());
            }
        });

    }

    public void clear() {
        items.clear();
    }

//    public void generateItem(String title, String descr, Integer episodes, Double score, Integer id) {
//        items.add(items.size(), new ItemViewModel(context, title, descr, episodes, score, id));
//    }

    public void onItemTapped(Object item){
        Log.d("itemclick", "onItemTapped: " + ((ItemViewModel) item).description.get());
        ((ItemViewModel)item).squareTwo();
        context.startActivity(new Intent(context, MainActivity.class));
    }

}

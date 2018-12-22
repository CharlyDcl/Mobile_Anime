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
import fr.esiea.anime.View.DetailActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListViewModel {

    public ObservableArrayList<ItemViewModel> items = new ObservableArrayList<>();
    public ObservableField<String> search = new ObservableField<>();
    Context context;

    public ItemListViewModel(final Context context) {

        this.context = context;
    }

    public void ReadFromApi() {
        clear();
        if (search.get() == null) return;
        ApiAnime.getRetrofitInstance().create(ApiInterface.class).getAnimesByTitle(search.get()).enqueue(new Callback<ResultAnime>() {
            @Override
            public void onResponse(Call<ResultAnime> call, Response<ResultAnime> response) {
                List<AnimeSearchResponse> list = response.body().getResults();
                for (AnimeSearchResponse element : list) {
                    items.add(items.size(), new ItemViewModel(context, element.getTitle(), element.getSynopsis(), element.getNb_episodes(), element.getScore(), element.getId()));
                    Log.d("data api", "onResponse: " + element.getTitle() + "id: " + element.getId());
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

    public void onItemTapped(Object item){
        Log.d("itemclick", "onItemTapped: " + ((ItemViewModel) item).description.get());
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("ID_ELEMENT", ((ItemViewModel) item).id);
        context.startActivity(intent);
    }

}

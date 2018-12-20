package fr.esiea.anime.Model.Api;

import fr.esiea.anime.Model.Anime.AnimeResponse;
import fr.esiea.anime.Model.Anime.ResultAnime;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search/anime")
    Call<ResultAnime> getAnimesByTitle(@Query("q") String Anime);

    @GET("anime/{animeID}/")
    Call<AnimeResponse> getAnimeByID(@Path("animeID") int id);

}

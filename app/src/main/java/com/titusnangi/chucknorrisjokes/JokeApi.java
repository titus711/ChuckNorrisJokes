package com.titusnangi.chucknorrisjokes;

import com.titusnangi.chucknorrisjokes.models.JokeModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface JokeApi {

    //query search for movies
    //https://api.chucknorris.io/jokes/search?query={query}
    @GET("jokes/search")
    Call<JokeModel> getResultList(
            @Query("query") String query
    );

}

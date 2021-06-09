package com.titusnangi.chucknorrisjokes.request;

import com.titusnangi.chucknorrisjokes.JokeApi;
import com.titusnangi.chucknorrisjokes.utils.Credentials;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    //configuring retrofit with the Gson converter and base_url
    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(Credentials.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());


    // implementing the retrofit singleton pattern that
    // allows only one instance of the class to exist in the JVM
    private static Retrofit retrofit = retrofitBuilder.build();

    private static JokeApi jokeApi = retrofit.create(JokeApi.class);


    public static JokeApi getJokeApi() {
        return jokeApi;
    }

}

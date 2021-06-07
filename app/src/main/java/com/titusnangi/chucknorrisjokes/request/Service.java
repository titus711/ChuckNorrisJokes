package com.titusnangi.chucknorrisjokes.request;

import com.titusnangi.chucknorrisjokes.JokeApi;
import com.titusnangi.chucknorrisjokes.utils.Credentials;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

     // configuring retrofit with the Gson converter and base_url
    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());



    // implementing the retrofit singleton pattern that
    // allows only instance of the class existing in the JVM
    private static Retrofit sRetrofit = retrofitBuilder.build();



    // interface

    private static JokeApi sJokeApi = sRetrofit.create(JokeApi.class);



    public JokeApi getJokeApi(){
        return sJokeApi;
    }







}

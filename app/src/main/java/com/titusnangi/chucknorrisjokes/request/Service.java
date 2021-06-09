package com.titusnangi.chucknorrisjokes.request;

import com.titusnangi.chucknorrisjokes.JokeApi;
import com.titusnangi.chucknorrisjokes.utils.Credentials;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {


    // implementing the retrofit singleton pattern that
   // allows only one instance of the class to exist in the JVM
    private static Retrofit sRetrofit;

    private static Service sService;

    //configuring retrofit with the Gson converter and base_url
    private Service() {
        sRetrofit = new Retrofit.Builder()
                .baseUrl(Credentials.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized Service getService() {
        if (sService == null) {
            sService = new Service();
        }

        return sService;
    }

    // interface
    public JokeApi getApi() {
        return sRetrofit.create(JokeApi.class);
    }


}

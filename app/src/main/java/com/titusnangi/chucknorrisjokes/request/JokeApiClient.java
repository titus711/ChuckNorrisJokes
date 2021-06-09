package com.titusnangi.chucknorrisjokes.request;

import androidx.lifecycle.MutableLiveData;

import com.titusnangi.chucknorrisjokes.models.JokeModel;

import java.util.List;

public class JokeApiClient {

    //moving the live data from the repository class into
    // the remote data source which is the api client


    //Livedata
    private MutableLiveData<List<JokeModel>> mJokes;

    //singleton pattern
    private static JokeApiClient instance;


    public static JokeApiClient getInstance(){
        if (instance == null){
            instance = new JokeApiClient();
        }

        return instance;
    }

    //constructor
    private JokeApiClient(){
        mJokes = new MutableLiveData<>();
    }

    //getter
    public MutableLiveData<List<JokeModel>> getJokes() {
        return mJokes;
    }
}

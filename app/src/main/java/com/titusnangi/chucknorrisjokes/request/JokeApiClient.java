package com.titusnangi.chucknorrisjokes.request;

import androidx.lifecycle.MutableLiveData;

import com.titusnangi.chucknorrisjokes.AppExecutors;
import com.titusnangi.chucknorrisjokes.models.JokeModel;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

    public void searchJokesApi(){
        final Future myHandler = AppExecutors.getInstance().networkIO().submit(new Runnable() {
            @Override
            public void run() {
                //thread for retrieving data from the api using retrofit
            }
        });

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                //thread for cancelling data from the api using retrofit
                myHandler.cancel(true);

            }
            //timeout
        },5000, TimeUnit.MICROSECONDS);
    }
}

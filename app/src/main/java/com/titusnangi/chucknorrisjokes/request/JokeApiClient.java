package com.titusnangi.chucknorrisjokes.request;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.titusnangi.chucknorrisjokes.AppExecutors;
import com.titusnangi.chucknorrisjokes.models.JokeModel;
import com.titusnangi.chucknorrisjokes.models.Result;
import com.titusnangi.chucknorrisjokes.response.JokeSearchResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeApiClient {
    List<Result> list = new ArrayList<>();


    //moving the live data from the repository class into
    // the remote data source which is the api client


    //Livedata
    private MutableLiveData<List<JokeModel>> mJokes;

    //singleton pattern
    private static JokeApiClient instance;


    public static JokeApiClient getInstance() {
        if (instance == null) {
            instance = new JokeApiClient();
        }

        return instance;
    }

    //constructor
    private JokeApiClient() {
        mJokes = new MutableLiveData<>();
    }

    //getter
    public MutableLiveData<List<JokeModel>> getJokes() {
        return mJokes;
    }

    public void searchJokesApi() {
        //final Future myHandler = AppExecutors.getInstance().networkIO().submit();

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                //thread for cancelling data from the api using retrofit
                //myHandler.cancel(true);

            }
            //timeout
        }, 5000, TimeUnit.MICROSECONDS);


    }

    //retrieving data from RestApi by runnable
    private class RetrieveJokesRunnable implements Runnable {

        private String query;
        boolean cancelRequest;


        public RetrieveJokesRunnable(String query) {
            this.query = query;
            cancelRequest = false;
        }

        @Override
        public void run() {
            //getting the response objects


        }


        // search method/ query


        private void cancelRequest() {
            Log.v("Tag", "Cancelling Search Request");
            cancelRequest = true;
        }


    }
}

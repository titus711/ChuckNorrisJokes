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


    //moving the live data from the repository class into
    // the remote data source which is the api client


    //Livedata
    private MutableLiveData<List<JokeModel>> mJokes;


    //singleton pattern
    private static JokeApiClient instance;

    //make a runnable request
    private RetrieveJokesRunnable retrieveJokesRunnable;


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

    //this method will be called in various classes that is the ViewModel, repository, UI controller
    public void searchJokesApi(String query) {
        if (retrieveJokesRunnable != null) {
            retrieveJokesRunnable = null;
        }

        retrieveJokesRunnable = new RetrieveJokesRunnable(query);


        final Future myHandler = AppExecutors.getInstance().networkIO().submit(retrieveJokesRunnable);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                //thread for cancelling the retrofit call

                myHandler.cancel(true);

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

            try {
                Response response = getJokes(query).execute();

                if (cancelRequest) {
                    return;
                }

                if (response.code() == 200) {
                    List<JokeModel> list = new ArrayList<>(((JokeSearchResponse) response.body()).getJokes());

                    //Sending data to live data
                    //using the postValue method for background thread
                    mJokes.postValue(list);
                } else {
                    String error = response.errorBody().string();
                    Log.v("Tag", "Error " + error);
                    mJokes.postValue(null);
                }


            } catch (IOException e) {
                e.printStackTrace();
                mJokes.postValue(null);
            }


        }

        // search method/query
        private Call<JokeSearchResponse> getJokes(String query) {
            return Service.getJokeApi().searchMovie(query);
        }


        private void cancelRequest() {
            Log.v("Tag", "Cancelling Search Request");
            cancelRequest = true;
        }


    }
}

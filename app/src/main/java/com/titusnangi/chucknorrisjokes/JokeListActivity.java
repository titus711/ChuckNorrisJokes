package com.titusnangi.chucknorrisjokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.titusnangi.chucknorrisjokes.models.JokeModel;
import com.titusnangi.chucknorrisjokes.models.Result;
import com.titusnangi.chucknorrisjokes.request.Service;
import com.titusnangi.chucknorrisjokes.response.JokeSearchResponse;
import com.titusnangi.chucknorrisjokes.viewmodels.JokeListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeListActivity extends AppCompatActivity {

    //created a button for testing the search response with the help of the Logcat
    Button myButton;

    //ViewModel
    private JokeListViewModel jokeListViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.testing_button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchJokesApi("kick");
            }
        });


        // creating an instance of the viewmodel
        jokeListViewModel = new ViewModelProvider(this).get(JokeListViewModel.class);

        // calling the observers
        ObserveAnyChange();


    }

    //Observing any data change
    private void ObserveAnyChange() {
        jokeListViewModel.getJokes().observe(this, new Observer<List<JokeModel>>() {
            @Override
            public void onChanged(List<JokeModel> jokeModels) {
                if (jokeModels != null){
                    for (JokeModel jokeModel: jokeModels){
                        //Get the data in log
                        Log.v("Tag", "onChanged: " + jokeModel.getValue());
                    }
                }


            }
        });
    }

    //calling the searchJokesApi method in the main activity and it declared in the view-model class
    private void searchJokesApi(String query){
        jokeListViewModel.searchJokesApi(query);
    }


//    private void getRetrofitResponse() {
//
//        JokeApi jokeApi = Service.getJokeApi();
//
//        Call<JokeSearchResponse> responseCall = jokeApi
//                .searchMovie("Chuck Norris");
//
//        responseCall.enqueue(new Callback<JokeSearchResponse>() {
//            @Override
//            public void onResponse(Call<JokeSearchResponse> call, Response<JokeSearchResponse> response) {
//                if (response.code() == 200){
//                    Log.v("Tag","the response" + response.body().toString());
//
//                    List<JokeModel> jokes = new ArrayList<>(response.body().getJokes());
//
//                    for (JokeModel joke: jokes ){
//                        Log.v("Tag" , "The id " + joke.getId());
//                        Log.v("Tag" , "The value " + joke.getValue());
//                        Log.v("Tag" , "The url " + joke.getUrl());
//
//
//                    }
//                }
//
//                else {
//                    try {
//                        Log.v("Tag", "Error" + response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<JokeSearchResponse> call, Throwable t) {
//
//            }
//        });
//    }

}
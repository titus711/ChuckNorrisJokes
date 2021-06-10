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


        // creating an instance of the view-model
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
                        Log.v("Tag", "onChanged: " + jokeModel.getId());


                    }
                }


            }
        });
    }

    //calling the searchJokesApi method in the main activity and it declared in the view-model class
    private void searchJokesApi(String query){
        jokeListViewModel.searchJokesApi(query);
    }




}
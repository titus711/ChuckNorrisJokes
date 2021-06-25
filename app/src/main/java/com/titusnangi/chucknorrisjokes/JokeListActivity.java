package com.titusnangi.chucknorrisjokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.titusnangi.chucknorrisjokes.adapters.JokeRecyclerView;
import com.titusnangi.chucknorrisjokes.adapters.OnJokeListener;
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

public class JokeListActivity extends AppCompatActivity implements OnJokeListener {

    //creating a recyclerView to add joke items for scrolling
    private RecyclerView recyclerview;

    private JokeRecyclerView jokeRecyclerAdapter;

    //ViewModel
    private JokeListViewModel jokeListViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding a ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        recyclerview = findViewById(R.id.recyclerView);

        // creating an instance of the view-model
        jokeListViewModel = new ViewModelProvider(this).get(JokeListViewModel.class);



        // calling the observers
        ObserveAnyChange();

        //calling the recyclerView method
        configureRecyclerView();




        //calling the search method containing the query to be searched
        searchJokesApi("Chuck Norris");


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


                        jokeRecyclerAdapter.setJokes(jokeModels);


                    }
                }


            }
        });
    }

    //calling the searchJokesApi method in the main activity and it declared in the view-model class
    private void searchJokesApi(String query){
        jokeListViewModel.searchJokesApi(query);
    }

    @Override
    public void onJokeClick(int position) {

    }


    //initializing the recyclerview and adding data to it
    private void configureRecyclerView(){
        jokeRecyclerAdapter = new JokeRecyclerView(this);
        recyclerview.setAdapter(jokeRecyclerAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }


}
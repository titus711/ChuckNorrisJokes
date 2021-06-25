package com.titusnangi.chucknorrisjokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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


    //Adapter
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

        // Adding a SearchView to get input from the user
        setUpSearchView();


        //Referencing the RecyclerView
        recyclerview = findViewById(R.id.recyclerView);

        // creating an instance of the view-model
        jokeListViewModel = new ViewModelProvider(this).get(JokeListViewModel.class);

        //calling the recyclerView method
        configureRecyclerView();

        // calling the observers
        ObserveAnyChange();

    }


    //Observing any data change
    private void ObserveAnyChange() {
        jokeListViewModel.getJokes().observe(this, new Observer<List<JokeModel>>() {
            @Override
            public void onChanged(List<JokeModel> jokeModels) {

                //Observing for any data changes
                if (jokeModels != null) {
                    for (JokeModel jokeModel : jokeModels) {

                        jokeRecyclerAdapter.setJokes(jokeModels);
                        //Get the data in log
                        Log.v("Tag", "onChanged: " + jokeModel.getId());

                    }
                }
            }
        });
    }

    //initializing the recyclerview and adding data to it
    private void configureRecyclerView() {
        jokeRecyclerAdapter = new JokeRecyclerView(this);
        recyclerview.setAdapter(jokeRecyclerAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onJokeClick(int position) {

    }


    //Get data from searchView and query the api to get the results (Jokes)
    private void setUpSearchView() {
        final SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                jokeListViewModel.searchJokesApi(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }


}
package com.titusnangi.chucknorrisjokes.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.titusnangi.chucknorrisjokes.models.JokeModel;
import com.titusnangi.chucknorrisjokes.request.JokeApiClient;

import java.util.List;

public class JokeRepository {
    //this class is used as the repository

    //creating a singleton
    private static JokeRepository instance;


    //creating an instance of the JokeApiClient class
    private  JokeApiClient jokeApiClient;


    public static JokeRepository getInstance() {
        if (instance == null) {
            instance = new JokeRepository();
        }
        return instance;
    }

    //constructor
    private JokeRepository() {
        jokeApiClient = JokeApiClient.getInstance();
    }

    //getter
    public MutableLiveData<List<JokeModel>> getJokes() {
        return jokeApiClient.getJokes();
    }
}

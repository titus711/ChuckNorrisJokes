package com.titusnangi.chucknorrisjokes.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.titusnangi.chucknorrisjokes.models.JokeModel;

import java.util.List;

public class JokeRepository {
    //this class is used as the repository



    //creating a singleton

    private static JokeRepository instance;


    // moving the livedata to the repository from the viewmodel

    private MutableLiveData<List<JokeModel>> mJokes;


    public static JokeRepository getInstance() {
        if (instance == null) {
            instance = new JokeRepository();
        }
        return instance;
    }

    //constructor

    private JokeRepository() {
        mJokes = new MutableLiveData<>();
    }

    //getter

    public MutableLiveData<List<JokeModel>> getJokes() {
        return mJokes;
    }
}

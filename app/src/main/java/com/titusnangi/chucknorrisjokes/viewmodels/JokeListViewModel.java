package com.titusnangi.chucknorrisjokes.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.titusnangi.chucknorrisjokes.models.JokeModel;
import com.titusnangi.chucknorrisjokes.repositories.JokeRepository;

import java.util.List;

public class JokeListViewModel extends ViewModel {
    //this class is  used as the viewmodel


    //creating an instance of the repository
    private JokeRepository jokeRepository;


    //constructor
    public JokeListViewModel() {
        jokeRepository = JokeRepository.getInstance();

    }

    //getter
    public MutableLiveData<List<JokeModel>> getJokes() {
        return jokeRepository.getJokes();
    }


}

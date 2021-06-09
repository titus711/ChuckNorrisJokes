package com.titusnangi.chucknorrisjokes.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.titusnangi.chucknorrisjokes.models.JokeModel;

import java.util.List;

public class JokeListViewModel extends ViewModel {
    //this class is  used as the VIEWMODEL

    // making an instance of the LiveData
    private MutableLiveData<List<JokeModel>> mJokes = new MutableLiveData<>();

    //constructor
    public JokeListViewModel() {

    }

    //getter
    public MutableLiveData<List<JokeModel>> getJokes() {
        return mJokes;
    }


}

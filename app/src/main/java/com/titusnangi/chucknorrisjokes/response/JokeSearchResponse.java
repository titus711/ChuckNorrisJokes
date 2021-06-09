package com.titusnangi.chucknorrisjokes.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.titusnangi.chucknorrisjokes.models.JokeModel;

import java.util.List;


public class JokeSearchResponse {
    //This class is for displaying multiple jokes (Jokes List)
    //- searching for jokes matching keyword


    @SerializedName("result")
    @Expose
    private List<JokeModel> jokes;

    public List<JokeModel> getJokes(){
        return jokes;
    }


    @Override
    public String toString() {
        return "JokeSearchResponse{" +
                "jokes=" + jokes +
                '}';
    }
}

package com.titusnangi.chucknorrisjokes.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.titusnangi.chucknorrisjokes.models.JokeModel;

public class JokeResponse {
    //This class is for single joke response
    // Finding the joke object

    @SerializedName("result")
    @Expose

    private JokeModel joke;

    public JokeModel getJoke(){
        return joke;
    }

    @Override
    public String toString() {
        return "JokeResponse{" +
                "joke=" + joke +
                '}';
    }
}

package com.titusnangi.chucknorrisjokes.models;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokeModel {
    //this is the root model class that is mapping the JSON objects into Java objects

    private String value;
    private String url;
    private String id;

    public JokeModel(String value, String url, String id) {
        this.value = value;
        this.url = url;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }



}

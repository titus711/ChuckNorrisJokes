package com.titusnangi.chucknorrisjokes.models;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//this is the root model class that is mapping the JSON objects into Java objects
public class JokeModel {



    @SerializedName("total")
    @Expose
    private int total;

    @SerializedName("result")
    @Expose
    private List<Result> mResultList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Result> getResultList() {
        return mResultList;
    }

    public void setResultList(List<Result> resultList) {
        mResultList = resultList;
    }
}

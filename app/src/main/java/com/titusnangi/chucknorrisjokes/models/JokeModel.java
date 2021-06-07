package com.titusnangi.chucknorrisjokes.models;

import android.os.Parcel;
import android.os.Parcelable;

public class JokeModel implements Parcelable {

    //implementing the Parcelable interface allows data to be passed
    // from one activity to another


    private String joke_value;
    private String url;
    private String joke_id;


    //constructor
    public JokeModel(String joke_value, String url, String joke_id) {
        this.joke_value = joke_value;
        this.url = url;
        this.joke_id = joke_id;
    }




    protected JokeModel(Parcel in) {
        joke_value = in.readString();
        url = in.readString();
        joke_id = in.readString();
    }

    public static final Creator<JokeModel> CREATOR = new Creator<JokeModel>() {
        @Override
        public JokeModel createFromParcel(Parcel in) {
            return new JokeModel(in);
        }

        @Override
        public JokeModel[] newArray(int size) {
            return new JokeModel[size];
        }
    };

    //getters
    public String getJoke_value() {
        return joke_value;
    }

    public String getUrl() {
        return url;
    }

    public String getJoke_id() {
        return joke_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(joke_value);
        parcel.writeString(url);
        parcel.writeString(joke_id);
    }
}

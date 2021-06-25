package com.titusnangi.chucknorrisjokes.models;



import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokeModel implements Parcelable {
    //this is the root model class that is mapping the JSON objects into Java and is
    //implementing the Parcelable interface allows data to be passed
    // from one activity to another

    private String value;
    private String url;
    private String id;

    public JokeModel(String value, String url, String id) {
        this.value = value;
        this.url = url;
        this.id = id;
    }

    protected JokeModel(Parcel in) {
        value = in.readString();
        url = in.readString();
        id = in.readString();
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

    public String getValue() {
        return value;
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(value);
        parcel.writeString(url);
        parcel.writeString(id);
    }
}

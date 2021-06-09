package com.titusnangi.chucknorrisjokes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.titusnangi.chucknorrisjokes.models.JokeModel;
import com.titusnangi.chucknorrisjokes.models.Result;
import com.titusnangi.chucknorrisjokes.request.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeListActivity extends AppCompatActivity {

    //created a button for testing the search response with the help of the Logcat

    Button myButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.testing_button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //method being called to test the search response by clicking the button above

                retrieveJson("Chuck");
            }
        });
    }

     // Testing the search response, retrieving results for the joke value, id and category

    public void retrieveJson(String query) {
        Call<JokeModel> call = Service.getService().getApi().getResultList(query);
        call.enqueue(new Callback<JokeModel>() {
            @Override
            public void onResponse(Call<JokeModel> call, Response<JokeModel> response) {
                if (response.isSuccessful() && response.body().getResultList() != null) {




                    List<Result> jokes = new ArrayList<>(response.body().getResultList());
                    Log.v("Tag", "The response " + response.body().toString());


                    for (Result joke : jokes) {
                        Log.v("Tag", "The searched joke is: " + joke.getValue().toString());
                        Log.v("Tag","The category is " + joke.getCategories().toString());
                        Log.v("Tag","The id is " + joke.getId().toString());
                    }

                } else {

                    try {
                        Log.v("Tag", "Error " + response.errorBody().string());

                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void onFailure(Call<JokeModel> call, Throwable t) {

            }
        });

    }

}
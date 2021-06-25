package com.titusnangi.chucknorrisjokes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.titusnangi.chucknorrisjokes.R;
import com.titusnangi.chucknorrisjokes.models.JokeModel;

import java.util.List;

public class JokeRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<JokeModel> mJokes;
    private OnJokeListener onJokeListener;


    public JokeRecyclerView(OnJokeListener onJokeListener) {
        this.onJokeListener = onJokeListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_list_item
        ,parent,false);
        return new JokeViewHolder(view,onJokeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((JokeViewHolder)holder).jokeValue.setText(mJokes.get(position).getValue());

        Glide.with(holder.itemView.getContext())
                .load("https://api.chucknorris.io/jokes/" + mJokes.get(position).getUrl())
                .into(((JokeViewHolder)holder).jokeImage);
    }

    @Override
    public int getItemCount() {
        if (mJokes != null){
            return mJokes.size();
        }
        return 0;
    }

    public void setJokes(List<JokeModel> jokes) {
        mJokes = jokes;
    }
}

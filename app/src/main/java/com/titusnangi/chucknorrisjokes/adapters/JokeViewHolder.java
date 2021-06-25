package com.titusnangi.chucknorrisjokes.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.titusnangi.chucknorrisjokes.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class JokeViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    //declaring widgets
    TextView jokeValue;
    CircleImageView jokeImage;

    //click listener
    OnJokeListener onJokeListener;

    public JokeViewHolder(@NonNull View itemView,OnJokeListener onJokeListener) {
        super(itemView);

        //instantiating the widgets
        jokeValue = itemView.findViewById(R.id.joke_value);
        jokeImage = itemView.findViewById(R.id.joke_image);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        onJokeListener.onJokeClick(getAdapterPosition());

    }
}

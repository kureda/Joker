package com.kureda.udacity.joker.androidlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Serg on 8/4/2016.
 */
public class JokeFragment extends Fragment {

    public JokeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(getString(R.string.JOKE));
        TextView jokeTextView = (TextView) view.findViewById(R.id.joke_text_view);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
        return view;
    }

}

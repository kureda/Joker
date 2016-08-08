package com.kureda.udacity.joker.androidlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Serg on 8/4/2016.
 */
public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        // If your minSdkVersion is below 11 use:
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

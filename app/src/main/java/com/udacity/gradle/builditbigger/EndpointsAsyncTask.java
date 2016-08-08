package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.kureda.udacity.joker.androidlib.JokeActivity;
import com.kureda.udacity.joker.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Serg on 8/5/2016.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;
    public static String MY_IP_ADDRESS = "192.168.178.72";

    public EndpointsAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            startApiService();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    private void startApiService() {

        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("http://" + MY_IP_ADDRESS + ":8080/_ah/api/")

//        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                new AndroidJsonFactory(), null)
//                // options for running against local devappserver
//                // - 10.0.2.2 is localhost's IP address in Android emulator
//                // - turn off compression when running against local devappserver
//                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?>
                                                   abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
        // end options for devappserver
        myApiService = builder.build();
    }

    @Override
    protected void onPostExecute(String joke) {
        Intent jokeIntent = new Intent(mContext, JokeActivity.class);
        jokeIntent.putExtra(mContext.getString(R.string.JOKE), joke);
        mContext.startActivity(jokeIntent);
    }
}
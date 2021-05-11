package com.example.android.simpleasynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {

    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProgressBar;
    private static final int CHUNK = 100;

    SimpleAsyncTask(TextView tv, ProgressBar pb) {
        mTextView    = new WeakReference<>(tv);
        mProgressBar = new WeakReference<>(pb);
    }

    @Override
    protected String doInBackground(Void... voids) {

        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;
        int chunks = s/CHUNK;

        for (int i = 0; i < CHUNK; i++) {
            try {
                Thread.sleep(chunks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            publishProgress(i+1);
        }

        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onProgressUpdate(Integer... values) { mProgressBar.get().setProgress(values[0]); }

    @Override
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}

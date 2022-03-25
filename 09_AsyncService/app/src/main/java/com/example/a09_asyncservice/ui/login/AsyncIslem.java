package com.example.a09_asyncservice.ui.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class AsyncIslem extends AsyncTask<String, Void, String> {

    ProgressDialog dialog;

    public AsyncIslem(Context context) {
        dialog = new ProgressDialog(context);
        dialog.setMessage("Yükleniyor");
        dialog.setCancelable(false);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if(dialog.isShowing())
            dialog.dismiss();
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);

        if(dialog.isShowing())
            dialog.dismiss();
    }
}

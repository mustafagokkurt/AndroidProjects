package com.example.a09_asyncservice.data.service;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WebService {

    OkHttpClient client = new OkHttpClient();

    Context fContext;

    private JSONObject responseObject;

    private Response response;

    private boolean fIsLoading = false;
    private AsyncTask fCurrentAsyncTask;

    public interface DataLoadEvents {
        void onLoadingDataFinished();
    }

    public DataLoadEvents fDataLoadEvents;

    public JSONObject getResponseJsonObject() {
        return responseObject;
    }

    public Response getResponse() {
        return response;
    }

    public AsyncTask getCurrentAsyncTask() { return fCurrentAsyncTask; }

    public boolean getIsLoading() {return fIsLoading; }

    public WebService(Context pContext) {
        fContext = pContext;
    }

    public boolean HideProgress = true;
    public boolean ShowProgress = true;

    public void LoadData(Request request) {

        ConnectivityManager cm = (ConnectivityManager) fContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (Controls.InternetControl(cm))
        {

            fCurrentAsyncTask = new HttpAsyncTaskLoadData().execute(request);
        }
        else
        {
        }
    }

    private class HttpAsyncTaskLoadData extends AsyncTask<Request, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(Request... requests) {

            try {
                Request request =  requests[0];

                response = client.newCall(request).execute();

                if(response != null && response.code() == 200)
                {
                    String result =  response.body().string();
                    return new JSONObject(result);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject pResponse) {
            try {
                if (pResponse != null) {
                    responseObject = pResponse;
                }

                fIsLoading = false;
                fDataLoadEvents.onLoadingDataFinished();

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
/*
                if (HideProgress)
                    BLL.UI.HideProgressDialog();*/
            }
        }

        @Override
        protected void onCancelled() {
            fIsLoading = false;

            fDataLoadEvents.onLoadingDataFinished();
            //BLL.UI.HideProgressDialog();
        }
    }
}
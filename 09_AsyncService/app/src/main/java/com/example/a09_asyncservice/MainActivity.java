package com.example.a09_asyncservice;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import android.app.Application;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.a09_asyncservice.data.service.ServiceCallBack;
import com.example.a09_asyncservice.data.service.ServiceData;
import com.example.a09_asyncservice.data.service.WebService;
import com.example.a09_asyncservice.ui.login.AsyncIslem;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://www.elimdengelir.net/Servis/EducationObjectExample.php";

        MakeRequest(url, null, "GET", 1, null);

    }

    public void btnIslemYap(View view) {


        AsyncIslem asyncIslem = new AsyncIslem(this);
        asyncIslem.execute("");

//        ProgressDialog dialog = new ProgressDialog(this);
//        dialog.setMessage("Yükleniyor");
//        dialog.show();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        dialog.dismiss();
    }

    void MakeRequest(String url, JsonObject parameters, String httpMethod, int requestCode, ServiceCallBack serviceCallBack) {

        final WebService webService = new WebService(this);
        webService.fDataLoadEvents = new WebService.DataLoadEvents() {
            @Override
            public void onLoadingDataFinished() {
                Response response = webService.getResponse();

                if(response!= null && response.code()== 200){
                    Gson gson = new Gson();
                    JsonParser jsonParser = new JsonParser();

                    try {
                        JsonObject jsonObject = (JsonObject) jsonParser.parse(webService.getResponseJsonObject().getJSONObject("Veri").toString());

                        ServiceData serviceData = gson.fromJson(webService.getResponseJsonObject().getJSONObject("Veri").toString(), ServiceData.class);

                        Log.d("Veri", jsonObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Request.Builder rb = new Request.Builder();
        rb.url(url);

        if (httpMethod == null) {
            httpMethod = "GET";
        }

        if (httpMethod.equals("POST") && parameters != null) {
            rb.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), parameters.toString()));
        }

        webService.LoadData(rb.build());
    }
}
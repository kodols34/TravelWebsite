package com.example.kodols.visitatateur.data.network;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class NetworkHandler extends Activity{

    public void getObject(Context mContext, String url){
        //String url = BuildConfig.DEBUG + uri;

        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v("http", "Ok");
                        try {
                            String result = "Your IP Address is " + response.getString("ip");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("http", String.valueOf(error));
                        VolleyLog.e("Error: ", error.getMessage());
                    }
        });

        mRequestQueue.add(req);
    }
}

package com.example.kodols.visitatateur.data.network;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.kodols.visitatateur.ui.error.ErrorDialogFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class NetworkHandler extends Activity {

    public void getObject(final Context mContext, final FragmentManager fm, final String url){
        //String url = BuildConfig.DEBUG + uri;

        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v("http", String.valueOf(response));
                        try {
                            String result = "Your IP Address is " + response.getString("ip");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error: ", error.getMessage());

                        //Create DialogFragment pop-up
                        String errorName = "Error " + url;
                        ErrorDialogFragment newFragment = ErrorDialogFragment.newInstance(
                                errorName,
                                String.valueOf(error));
                        newFragment.show(fm, "dialog");

                    }
        });
        mRequestQueue.add(req);
    }
}

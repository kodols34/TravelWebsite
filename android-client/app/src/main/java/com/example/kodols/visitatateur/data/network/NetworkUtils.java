package com.example.kodols.visitatateur.data.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class NetworkUtils {
    public static void GET_METHOD(Context context, String url, final VolleyResponseListener listener)
    {

        // Initialize a new StringRequest
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onErrorResponse(error);

                    }
                })

        {


        };

        // Access the RequestQueue through singleton class.
        NetworkHolder.getInstance(context).addToRequestQueue(stringRequest);
    }
}

package com.example.kodols.visitatateur.data.network;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class NetworkUserUtils extends Activity {

    public static void POST_REGISTER(final Context context, final String url, final String email,
                                     final String password, final String nom, final String prenom,
                                     final String sexe, final int age, final String phone,
                                     final VolleyResponseListener listener) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error_POST_REGISTER: ", error.getMessage());
                        listener.onErrorResponse(error);
                    }
        })

        {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);
                params.put("nom", nom);
                params.put("prenom", prenom);
                params.put("sexe", sexe);
                params.put("age", String.valueOf(age));
                params.put("phone", phone);
                return params;
            }
        };

        // Access the RequestQueue through singleton class.
        NetworkHolder.getInstance(context).addToRequestQueue(stringRequest);
    }

    public static void POST_LOGIN(final Context context, final String url, final String USERNAME,
                                  final String PASSWORD, final VolleyResponseListener listener) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error_POST_LOGIN: ", error.getMessage());
                        listener.onErrorResponse(error);
                    }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //add params <key,value>
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String credentials = USERNAME+":"+PASSWORD;
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(),
                        Base64.NO_WRAP);
                headers.put("Authorization", auth);
                return headers;
            }
        };

        // Access the RequestQueue through singleton class.
        NetworkHolder.getInstance(context).addToRequestQueue(stringRequest);
    }
}

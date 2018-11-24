package com.example.kodols.visitatateur.data.network;

import android.app.Activity;
import android.content.Context;
import android.provider.SyncStateContract;
import android.support.v4.app.FragmentManager;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class NetworkLoginHandler extends Activity {

    public void login(final Context mContext, final FragmentManager fm, final String url,
                      final String USERNAME, final String PASSWORD){

        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ///handle response from service
                        Log.v("dataR", "Success"+String.valueOf(response));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //handle error response
                         VolleyLog.e("Error: ", error.getMessage());
                         Log.v("dataR", "Error"+String.valueOf(error));
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
        mRequestQueue.add(request);
    }
}

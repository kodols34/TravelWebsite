package com.example.kodols.visitatateur.data.network;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kodols.visitatateur.ui.error.ErrorDialogFragment;

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
                        VolleyLog.e("Error: ", error.getMessage());
                        Log.v("dataR", "Error"+String.valueOf(error));
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            //This indicates that the reuest has either time out or there is no connection
                            //Create DialogFragment pop-up
                            String errorName = "Error: check your internet connection";
                            ErrorDialogFragment newFragment = ErrorDialogFragment.newInstance(
                                    errorName,
                                    String.valueOf(error));
                            newFragment.show(fm, "dialog");
                        } else if (error instanceof AuthFailureError) {
                            //Error indicating that there was an Authentication Failure while performing the request
                            Toast toast = Toast.makeText(mContext, "Wrong password", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.BOTTOM, 0,250);
                            toast.show();
                        } else if (error instanceof ServerError) {
                            //Indicates that the server responded with a error response
                            String errorName = "Error: "+String.valueOf(error.networkResponse.statusCode);
                            ErrorDialogFragment newFragment = ErrorDialogFragment.newInstance(
                                    errorName,
                                    "Username not found");
                            newFragment.show(fm, "dialog");

                        } else if (error instanceof NetworkError) {
                            //Indicates that there was network error while performing the request
                        } else if (error instanceof ParseError) {
                            // Indicates that the server response could not be parsed
                        }
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

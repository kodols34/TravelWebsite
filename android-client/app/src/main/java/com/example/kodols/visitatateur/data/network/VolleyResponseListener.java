package com.example.kodols.visitatateur.data.network;

import com.android.volley.VolleyError;

public interface VolleyResponseListener {

    void onResponse(Object response);

    void onErrorResponse(VolleyError error);


}
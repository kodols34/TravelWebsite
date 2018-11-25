package com.example.kodols.visitatateur.data.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkHolder {
    private static NetworkHolder mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private NetworkHolder(Context context)
    {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized NetworkHolder getInstance(Context context)
    {
        if (mInstance == null)
        {
            mInstance = new NetworkHolder(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue()
    {
        if (mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }
}

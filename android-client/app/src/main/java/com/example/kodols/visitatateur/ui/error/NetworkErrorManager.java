package com.example.kodols.visitatateur.ui.error;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

public class NetworkErrorManager {

    public static void loginError(VolleyError error, Context context, FragmentManager fm){
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
            Toast toast = Toast.makeText(context, "Wrong password", Toast.LENGTH_SHORT);
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

    public static void registernError(VolleyError error, Context context, FragmentManager fm){
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
            
        } else if (error instanceof ServerError) {
            //Indicates that the server responded with a error response
            String errorName = "Error: "+String.valueOf(error.networkResponse.statusCode);
            ErrorDialogFragment newFragment = ErrorDialogFragment.newInstance(
                    errorName,
                    "User already exists");
            newFragment.show(fm, "dialog");

        } else if (error instanceof NetworkError) {
            //Indicates that there was network error while performing the request
        } else if (error instanceof ParseError) {
            // Indicates that the server response could not be parsed
        }
    }
}

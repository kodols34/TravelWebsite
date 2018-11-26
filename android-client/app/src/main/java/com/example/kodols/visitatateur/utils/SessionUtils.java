package com.example.kodols.visitatateur.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SessionUtils extends AppCompatActivity {

    final String SESSION_NAME = "NodeSession";

    public final void setSession(Context context, String token){
        SharedPreferences sharedpreferences = context.getSharedPreferences(SESSION_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean("session_status", true); // Storing true value
        editor.putString("token", token); // Storing string value
        editor.commit(); // commit changes
    }

    public final boolean isSessionActive(Context context){
        //clearSession(context);
        SharedPreferences shared = context.getSharedPreferences(SESSION_NAME, Context.MODE_PRIVATE);
        return shared.getBoolean("session_status", false);
    }

    public final void clearSession(Context context){
        context.getSharedPreferences(SESSION_NAME, 0).edit().clear().commit();
    }
}

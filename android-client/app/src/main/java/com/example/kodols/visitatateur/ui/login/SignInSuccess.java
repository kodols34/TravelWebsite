package com.example.kodols.visitatateur.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kodols.visitatateur.MainActivity;
import com.example.kodols.visitatateur.R;
import com.example.kodols.visitatateur.utils.SessionUtils;

public class SignInSuccess extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_success);

        //Set session
        new SessionUtils().setSession(getApplicationContext(), getIntent().getStringExtra("token"));
        TextView email = findViewById(R.id.email);
        email.setText(getIntent().getStringExtra("email"));
        TextView name = findViewById(R.id.name);
        name.setText(getIntent().getStringExtra("last_name")+" "+getIntent().getStringExtra("first_name"));

        // Set layout
        Button btnContinue = findViewById(R.id.btnAccept);
        btnContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAccept:
                // Call activity
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }
    }
}

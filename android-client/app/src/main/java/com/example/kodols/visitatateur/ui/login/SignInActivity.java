package com.example.kodols.visitatateur.ui.login;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kodols.visitatateur.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Create button listener
        Button btnBackLogin = (Button) findViewById(R.id.button_back_login);
        btnBackLogin.setOnClickListener(this);
        // Create button listener
        Button btnRegister = (Button) findViewById(R.id.button_next);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_back_login:
                super.onBackPressed();
                break;
            case R.id.button_next:
                // Need to share login/passwd
                SignInFragment signInFragment = new SignInFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.activity_sign_in, signInFragment);
                fragmentTransaction.commit();
                break;
        }
    }

}

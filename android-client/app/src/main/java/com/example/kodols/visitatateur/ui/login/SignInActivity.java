package com.example.kodols.visitatateur.ui.login;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        // Get elements
        EditText emailET = findViewById(R.id.email);
        EditText passwordET = findViewById(R.id.password);

        switch (v.getId()) {
            case R.id.button_back_login:
                super.onBackPressed();
                break;
            case R.id.button_next:
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();
               //Check if elements are empty
                if ( areElementsEmpty(v, email, password) ) {
                    // Add login/password in bundle to share
                    Bundle bundle = new Bundle();
                    bundle.putString("email", email);
                    bundle.putString("password", password);

                    // Create fragment
                    SignInFragment signInFragment = new SignInFragment();
                    signInFragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.activity_sign_in, signInFragment);
                    fragmentTransaction.commit();
                }
                break;
        }
    }

    public boolean areElementsEmpty(View v, String email, String password){

        if (email.matches("")) {
            Toast toast = Toast.makeText(v.getContext(), "You did not entered a username", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0,250);
            toast.show();
            return false;
        }
        else if(password.matches("")) {
            Toast toast = Toast.makeText(v.getContext(), "You did not entered a password", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0,250);
            toast.show();
            return false;
        }
        return true;
    }

}

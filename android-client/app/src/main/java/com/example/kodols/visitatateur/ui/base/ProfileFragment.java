package com.example.kodols.visitatateur.ui.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.kodols.visitatateur.BuildConfig;
import com.example.kodols.visitatateur.R;
import com.example.kodols.visitatateur.data.network.NetworkUserUtils;
import com.example.kodols.visitatateur.data.network.VolleyResponseListener;
import com.example.kodols.visitatateur.ui.error.NetworkErrorManager;
import com.example.kodols.visitatateur.ui.login.SignInActivity;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        // Create button listener
        Button btnLogin = (Button) v.findViewById(R.id.button_login);
        btnLogin.setOnClickListener(this);
        // Create button listener
        Button btnSignIn = (Button) v.findViewById(R.id.button_sign_up);
        btnSignIn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                // Get elements
                EditText email = getView().findViewById(R.id.email);
                EditText password = getView().findViewById(R.id.password);

                //Check if elements are empty
                if ( areElementsEmpty(v,
                        email.getText().toString(),
                        password.getText().toString())
                        ) {

                    new NetworkUserUtils().POST_LOGIN(v.getContext(),
                            "http://" + BuildConfig.SERVER_URL + ":5000/api/user/authenticate",
                            String.valueOf(email.getText()),
                            String.valueOf(password.getText()),
                            new VolleyResponseListener() {
                                @Override
                                public void onResponse(Object response) {
                                    // Here's OK from server w/ session token
                                }

                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    NetworkErrorManager.loginError(error, getContext(), getFragmentManager());
                                }
                            }
                    );
                }



                break;
            case R.id.button_sign_up:
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);
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

package com.example.kodols.visitatateur.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.kodols.visitatateur.BuildConfig;
import com.example.kodols.visitatateur.R;
import com.example.kodols.visitatateur.data.network.NetworkUserUtils;
import com.example.kodols.visitatateur.data.network.VolleyResponseListener;
import com.example.kodols.visitatateur.ui.error.NetworkErrorManager;
import com.example.kodols.visitatateur.utils.NumberPickerDialog;

public class SignInFragment extends Fragment implements View.OnClickListener{

    int mStackLevel = 0;
    private static final int DIALOG_FRAGMENT = 1;
    private static final int MIN_AGE = 12;
    private static final int MAX_AGE = 100;
    private TextView editText;
    private int age = MIN_AGE;

    public SignInFragment() {
        // Required empty public constructor
    }

    public static SignInFragment newInstance() {
        SignInFragment fragment = new SignInFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sign_in, container, false);

        String email = getArguments().getString("email");
        String password = getArguments().getString("password");


        // Create button listener
        this.editText = (TextView) v.findViewById(R.id.edit_picker);
        editText.setText(String.valueOf(MIN_AGE));
        editText.setOnClickListener(this);
        // Create button listener
        Button btnBackRegister = (Button) v.findViewById(R.id.button_back_register);
        btnBackRegister.setOnClickListener(this);
        // Create button listener
        Button btnRegister = (Button) v.findViewById(R.id.button_register);
        btnRegister.setOnClickListener(this);

        return v;
    }

   // Callback from NumberPickerDialog
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.age = (int) data.getExtras().get("age");
        this.editText.setText(String.valueOf(this.age));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_picker:
                NumberPickerDialog dialogFrag = NumberPickerDialog.newInstance(MIN_AGE,MAX_AGE, age);
                dialogFrag.setTargetFragment(this, DIALOG_FRAGMENT);
                dialogFrag.show(getFragmentManager().beginTransaction(), "dialog");
                break;
            case R.id.button_back_register:
                getActivity().onBackPressed();
                break;
            case R.id.button_register:

                new NetworkUserUtils().POST_REGISTER(v.getContext(),
                        "http://" + BuildConfig.SERVER_URL + ":5000/api/user",
                        "loup.fauries@gmail.com",
                        "orelsan",
                        "Jean",
                        "Pierre",
                        "Men",
                        22,
                        "123-233-2333",
                        new VolleyResponseListener() {

                            @Override
                            public void onResponse(Object response) {
                                Intent intent = new Intent(getActivity(), SignInSuccess.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.v("Error_POST_REGISTER", String.valueOf(error));
                                NetworkErrorManager.registernError(error,getContext(),getFragmentManager());
                            }
                        });
                break;
        }
    }

}

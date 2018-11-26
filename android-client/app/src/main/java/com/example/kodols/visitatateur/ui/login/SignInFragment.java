package com.example.kodols.visitatateur.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.kodols.visitatateur.BuildConfig;
import com.example.kodols.visitatateur.R;
import com.example.kodols.visitatateur.data.network.NetworkUserUtils;
import com.example.kodols.visitatateur.data.network.VolleyResponseListener;
import com.example.kodols.visitatateur.ui.error.NetworkErrorManager;
import com.example.kodols.visitatateur.utils.NumberPickerDialog;

import org.json.JSONException;
import org.json.JSONObject;

public class SignInFragment extends Fragment implements View.OnClickListener{

    int mStackLevel = 0;
    private static final int DIALOG_FRAGMENT = 1;
    private static final int MIN_AGE = 12;
    private static final int MAX_AGE = 100;
    private int age = MIN_AGE;

    private EditText firstName;
    private EditText lastName;
    private RadioGroup radioGroup;
    private TextView agePicker;
    private EditText phoneNumber;
    private EditText bubbleDescription;
    private String email;
    private String password;

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

        // Create button listener
        this.agePicker = (TextView) v.findViewById(R.id.edit_picker);
        agePicker.setText(String.valueOf(MIN_AGE));
        agePicker.setOnClickListener(this);
        // Create button listener
        Button btnBackRegister = (Button) v.findViewById(R.id.button_back_register);
        btnBackRegister.setOnClickListener(this);
        // Create button listener
        Button btnRegister = (Button) v.findViewById(R.id.button_register);
        btnRegister.setOnClickListener(this);

        // Declare fillable fields
        this.firstName = v.findViewById(R.id.first_name);
        this.lastName = v.findViewById(R.id.last_name);
        this.radioGroup = v.findViewById(R.id.radio_group);
        this.phoneNumber = v.findViewById(R.id.phone_number);
        this.bubbleDescription = v.findViewById(R.id.bubble_description);

        this.email = getArguments().getString("email");
        this.password = getArguments().getString("password");

        return v;
    }

   // Callback from NumberPickerDialog
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.age = (int) data.getExtras().get("age");
        this.agePicker.setText(String.valueOf(this.age));
    }


    @Override
    public void onClick(View v) {
        int idChecked = this.radioGroup.getCheckedRadioButtonId();
        RadioButton buttonChecked = getView().findViewById(idChecked);

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
                        email,
                        password,
                        String.valueOf(lastName.getText()),
                        String.valueOf(firstName.getText()),
                        String.valueOf(buttonChecked.getText()),
                        age,
                        String.valueOf(phoneNumber.getText()),
                        new VolleyResponseListener() {

                            @Override
                            public void onResponse(Object response) {
                                // Parse response to collect token and create session
                                String token = null;
                                JSONObject obj = null;
                                try {
                                    obj = new JSONObject((String) response);
                                    token = obj.getString("token");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                // Call activity
                                Intent intent = new Intent(getActivity(), SignInSuccess.class);
                                intent.putExtra("email", getArguments().getString("email"));
                                intent.putExtra("last_name", String.valueOf(lastName.getText()));
                                intent.putExtra("first_name", String.valueOf(firstName.getText()));
                                intent.putExtra("token", token);

                                startActivity(intent);
                            }

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                NetworkErrorManager.registerError(error,getContext(),getFragmentManager());
                            }
                        });
                break;
        }
    }

}

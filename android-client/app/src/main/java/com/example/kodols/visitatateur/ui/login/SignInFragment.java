package com.example.kodols.visitatateur.ui.login;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kodols.visitatateur.R;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sign_in, container, false);

        // Create button listener
        this.editText = (TextView) v.findViewById(R.id.edit_picker);
        editText.setText(String.valueOf(MIN_AGE));
        editText.setOnClickListener(this);

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
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

        }
    }

}

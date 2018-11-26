package com.example.kodols.visitatateur.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kodols.visitatateur.R;

public class ProfileLoggedFragment extends Fragment implements View.OnClickListener {

    private ProfileFragment.OnFragmentInteractionListener mListener;

   public ProfileLoggedFragment() {
        // Required empty public constructor
    }

    public static ProfileLoggedFragment newInstance() {
        ProfileLoggedFragment fragment = new ProfileLoggedFragment();
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
        View v = inflater.inflate(R.layout.fragment_profile_logged, container, false);

        TextView textView = v.findViewById(R.id.textView);
        textView.setText("ON EST PAS LA NOU ?");

        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:

                break;
            case R.id.button_sign_up:

                break;
        }
    }



}

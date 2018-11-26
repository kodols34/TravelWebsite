package com.example.kodols.visitatateur.ui.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kodols.visitatateur.R;
import com.example.kodols.visitatateur.utils.SessionUtils;

public class PlaceFragment extends Fragment {

    public PlaceFragment() {
        // Required empty public constructor
    }

    public static PlaceFragment newInstance() {
        PlaceFragment fragment = new PlaceFragment();
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
        View v = inflater.inflate(R.layout.fragment_place, container, false);

        Log.v("LifeCycle","Fragment: onCreateView");
        TextView textView = v.findViewById(R.id.place_fragment_text);

        if(new SessionUtils().isSessionActive(getContext())) {
            textView.setText("SESSIONOUIBRAVO");
        }
        else {
            textView.setText("PASSESSION");
        }

        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v("LifeCycle","Fragment: onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v("LifeCycle","Fragment: onDestroyView");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v("LifeCycle","Fragment: onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("LifeCycle","Fragment: onStop");
    }

}

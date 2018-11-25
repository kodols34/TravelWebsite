package com.example.kodols.visitatateur.ui.base;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kodols.visitatateur.R;

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
        Log.v("LifeCycle","Fragment: onCreateView");
        return inflater.inflate(R.layout.fragment_place, container, false);
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

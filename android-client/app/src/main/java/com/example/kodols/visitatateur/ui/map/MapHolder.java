package com.example.kodols.visitatateur.ui.map;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kodols.visitatateur.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapView;

public class MapHolder extends Fragment {

    MapView map = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Configuration.getInstance().load(getContext(), PreferenceManager.getDefaultSharedPreferences(getContext()));
        View view = inflater.inflate(R.layout.fragment_map, container, false);


        MapView map = (MapView) view.findViewById(R.id.id_map);

        return inflater.inflate(R.layout.fragment_map_display, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Configuration.getInstance().load(getContext(), PreferenceManager.getDefaultSharedPreferences(getActivity()));
    }
}

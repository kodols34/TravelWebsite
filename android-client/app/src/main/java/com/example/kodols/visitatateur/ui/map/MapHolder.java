package com.example.kodols.visitatateur.ui.map;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kodols.visitatateur.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

public class MapHolder extends Fragment {

    private MapView mMapView;
    private MapController mMapController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map_display, container, false);

        // Setup map view
        mMapView = (MapView) v.findViewById(R.id.id_map);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        mMapView.setBuiltInZoomControls(true);
        // Applying parameters
        mMapController = (MapController) mMapView.getController();
        mMapController.setZoom(16);
        GeoPoint startPoint = new GeoPoint(45.404476, -71.888351);
        mMapController.setCenter(startPoint);

        //Configuration.getInstance().load(getContext(), PreferenceManager.getDefaultSharedPreferences(getContext()));

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Configuration.getInstance().load(getContext(), PreferenceManager.getDefaultSharedPreferences(getActivity()));
    }
}

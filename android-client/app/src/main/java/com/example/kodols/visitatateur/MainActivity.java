package com.example.kodols.visitatateur;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import com.example.kodols.visitatateur.ui.base.MapFragment;
import com.example.kodols.visitatateur.ui.base.PlaceFragment;
import com.example.kodols.visitatateur.ui.base.ProfileFragment;


public class MainActivity extends AppCompatActivity {

    final PlaceFragment placeFragment = new PlaceFragment();
    final MapFragment mapFragment = new MapFragment();
    final ProfileFragment profileFragment = new ProfileFragment();

    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = placeFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_place:
                    fm.beginTransaction().hide(active).show(placeFragment).commit();
                    active = placeFragment;
                    return true;
                case R.id.navigation_map:
                    fm.beginTransaction().hide(active).show(mapFragment).commit();
                    active = mapFragment;
                    return true;
                case R.id.navigation_profile:
                    fm.beginTransaction().hide(active).show(profileFragment).commit();
                    active = profileFragment;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm.beginTransaction().add(R.id.main_container, profileFragment, "3").hide(profileFragment).commit();
        fm.beginTransaction().add(R.id.main_container, mapFragment, "2").hide(mapFragment).commit();
        fm.beginTransaction().add(R.id.main_container,placeFragment, "1").commit();

        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        //final Context mContext = getApplicationContext();

        //final Button button = findViewById(R.id.button2);
        //button.setOnClickListener(new View.OnClickListener() {
        //    public void onClick(View v) {
                // Code here executes on main thread after user presses button
         //       View parent = (View) v.getParent();

         //       AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
         //       builder.setMessage(String.valueOf("ok"));
         //       AlertDialog dialog = builder.create();
         //       new NetworkHandler().getObject(mContext, getSupportFragmentManager(), "http://"+BuildConfig.SERVER_URL+":5000/api/users");
         //   }
        //});
    }



}

package com.example.kodols.visitatateur;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.kodols.visitatateur.ui.base.MapFragment;
import com.example.kodols.visitatateur.ui.base.PlaceFragment;
import com.example.kodols.visitatateur.ui.base.ProfileFragment;
import com.example.kodols.visitatateur.ui.base.ProfileLoggedFragment;
import com.example.kodols.visitatateur.utils.SessionUtils;


public class MainActivity extends AppCompatActivity {

    final PlaceFragment placeFragment = new PlaceFragment();
    final MapFragment mapFragment = new MapFragment();
    final ProfileFragment profileFragment = new ProfileFragment();
    final ProfileLoggedFragment profileLoggedFragment = new ProfileLoggedFragment();

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
                    boolean bool = new SessionUtils().isSessionActive(getApplicationContext());
                    if (bool){
                        fm.beginTransaction().hide(active).show(profileLoggedFragment).commit();
                        active = profileLoggedFragment;
                    }
                    else {
                        fm.beginTransaction().hide(active).show(profileFragment).commit();
                        active = profileFragment;
                    }

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm.beginTransaction().add(R.id.main_container, profileLoggedFragment, "4").hide(profileLoggedFragment).commit();
        fm.beginTransaction().add(R.id.main_container, profileFragment, "3").hide(profileFragment).commit();
        fm.beginTransaction().add(R.id.main_container, mapFragment, "2").hide(mapFragment).commit();
        fm.beginTransaction().add(R.id.main_container, placeFragment, "1").commit();

        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        Log.v("LifeCycle", "onCreate");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.v("LifeCycle", "onResume");

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("LifeCycle", "onDestroy");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.v("LifeCycle", "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.v("LifeCycle", "onStop");
    }
   @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("LifeCycle", "onRestart");
    }



}

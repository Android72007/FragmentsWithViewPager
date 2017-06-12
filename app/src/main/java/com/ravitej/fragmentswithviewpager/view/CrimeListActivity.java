package com.ravitej.fragmentswithviewpager.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.ravitej.fragmentswithviewpager.R;

public class CrimeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_conatiner);

        if(fragment == null){
            fragment = new CrimeListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_conatiner, fragment)
                    .commit();
        }
    }
}

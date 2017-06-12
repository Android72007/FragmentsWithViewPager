package com.ravitej.fragmentswithviewpager.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ravitej.fragmentswithviewpager.R;

public class CrimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        /*Adding CrimeFragment to the CrimeActivity Screen*/

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_conatiner);

        if(fragment == null){
            fragment = new CrimeFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_conatiner, fragment)
                    .commit();
        }
    }
}

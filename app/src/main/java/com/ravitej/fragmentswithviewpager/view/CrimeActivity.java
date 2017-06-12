package com.ravitej.fragmentswithviewpager.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.ravitej.fragmentswithviewpager.R;
import com.ravitej.fragmentswithviewpager.adapter.CrimeRecyclerAdapter;

import java.util.UUID;

public class CrimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        /*Adding CrimeFragment to the CrimeActivity Screen*/

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_conatiner);

        if(fragment == null){
            fragment = newFragmentInstance();
            fm.beginTransaction()
                    .add(R.id.fragment_conatiner, fragment)
                    .commit();
        }
    }

    /*Attaching Arguments to fragments*/
    private Fragment newFragmentInstance(){
        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeRecyclerAdapter.CrimeHolder.CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }

}

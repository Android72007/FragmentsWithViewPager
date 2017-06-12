package com.ravitej.fragmentswithviewpager.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ravitej.fragmentswithviewpager.R;
import com.ravitej.fragmentswithviewpager.adapter.CrimeRecyclerAdapter;
import com.ravitej.fragmentswithviewpager.model.Crime;
import com.ravitej.fragmentswithviewpager.model.CrimeLab;

import java.util.List;

/**
 * Created by No One on 6/12/2017.
 */

public class CrimeListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private CrimeRecyclerAdapter mCrimeRecyclerAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.crime_list_fragment, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.crime_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        mCrimeRecyclerAdapter = new CrimeRecyclerAdapter(crimes, getActivity());
        mRecyclerView.setAdapter(mCrimeRecyclerAdapter);

    }
}

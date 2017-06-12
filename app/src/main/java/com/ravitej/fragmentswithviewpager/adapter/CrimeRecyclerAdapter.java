package com.ravitej.fragmentswithviewpager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ravitej.fragmentswithviewpager.R;
import com.ravitej.fragmentswithviewpager.model.Crime;
import com.ravitej.fragmentswithviewpager.view.CrimeActivity;

import java.util.List;

/**
 * Created by No One on 6/12/2017.
 */

public class CrimeRecyclerAdapter extends RecyclerView.Adapter<CrimeRecyclerAdapter.CrimeHolder> {

    private List<Crime> mCrimes;
    private Context mContext;

    public CrimeRecyclerAdapter(List<Crime> crimes, Context context){
        mCrimes = crimes;
        mContext = context;
    }
    @Override
    public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return new CrimeHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(CrimeHolder holder, int position) {
        Crime crime = mCrimes.get(position);
        holder.bind(crime);
    }

    @Override
    public int getItemCount() {
        return mCrimes.size();
    }

    public class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public static final String CRIME_ID = "crime_id";
        private Crime mCrime;
        private TextView mTitle;
        private TextView mDate;
        public CrimeHolder(LayoutInflater layoutInflater, ViewGroup parent) {
            super(layoutInflater.inflate(R.layout.crime_details, parent, false));
            itemView.setOnClickListener(this);
            mTitle = (TextView)itemView.findViewById(R.id.crime_title_details);
            mDate = (TextView)itemView.findViewById(R.id.crime_date_details);
        }

        public void bind(Crime crime){
            mCrime = crime;
            mTitle.setText(crime.getmTitle());
            mDate.setText(crime.getmDate().toString());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, mCrime.getmTitle(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mContext, CrimeActivity.class);
            intent.putExtra(CRIME_ID, mCrime.getmId());
            mContext.startActivity(intent);
        }
    }
}

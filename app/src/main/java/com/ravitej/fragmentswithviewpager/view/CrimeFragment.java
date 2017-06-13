package com.ravitej.fragmentswithviewpager.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.ravitej.fragmentswithviewpager.R;
import com.ravitej.fragmentswithviewpager.model.Crime;
import com.ravitej.fragmentswithviewpager.model.CrimeLab;

import java.util.UUID;

import static android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * Created by No One on 6/12/2017.
 */

public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mTitleText;
    private Button mDateButton;
    private CheckBox mIsSolved;

    /*Attaching Arguments to fragments*/
    public static Fragment newInstance(UUID crimeId){
        Bundle bundle = new Bundle();
        bundle.putSerializable("Crime_ID", crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID)getArguments().getSerializable("Crime_ID");
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.crime_fragment, container, false);
        /*Getting EditText View instance and adding listner to the EditText*/
        mTitleText = (EditText)view.findViewById(R.id.crime_title);
        mTitleText.setText(mCrime.getmTitle());
        setTitleListner();

        /*Setting Date to the Button and Disabling it*/
        mDateButton = (Button)view.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getmDate().toString());
//        mDateButton.setEnabled(false);

        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                datePickerFragment.show(fm, "DialogDate");
            }
        });

        /*Listneing for check box changes*/
        mIsSolved = (CheckBox)view.findViewById(R.id.crime_issolved);
        mIsSolved.setChecked(mCrime.ismSolved());
        setCheckBoxListner();

        return view;
    }

    /*
    * Adding Listner to the Check Box
    * */
    private void setCheckBoxListner() {
       mIsSolved.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setmSolved(isChecked);
            }
        });
    }


    /*
    *Adding Listner to the EditText Button for CRIME_TITLE
    */
    public void setTitleListner(){
        mTitleText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setmTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

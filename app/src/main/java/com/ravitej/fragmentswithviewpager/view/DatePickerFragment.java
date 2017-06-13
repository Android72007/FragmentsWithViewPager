package com.ravitej.fragmentswithviewpager.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.ravitej.fragmentswithviewpager.R;

/**
 * Created by No One on 6/12/2017.
 */

public class DatePickerFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);
        return new AlertDialog.Builder(getActivity())
                .setTitle("Crime Date")
                .setView(view)
                .setPositiveButton("OK", null)
                .create();
    }
}

package com.renthut.laba5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class InfoDialog extends DialogFragment {
    private static final String ARG_NUMBER = "number";

    public static InfoDialog newInstance(String number) {

        Bundle args = new Bundle();

        InfoDialog fragment = new InfoDialog();
        args.putString(ARG_NUMBER, number);
        fragment.setArguments(args);
        return fragment;
    }

    public InfoDialog() {
    }

    private String number;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            number = getArguments().getString(ARG_NUMBER);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Number")
                .setMessage("You choose number: " + number)
                .setPositiveButton("OK", null)
                .create();
    }
}

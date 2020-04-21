package com.renthut.part3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NotifyDialog extends DialogFragment {

    private static final String ARG_TITLE = "title";
    public static final String ARG_TEXT = "text";

    public NotifyDialog() {
    }

    public static NotifyDialog newInstance(String title, String text) {

        Bundle args = new Bundle();

        NotifyDialog fragment = new NotifyDialog();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    private String title;
    private String text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            text = getArguments().getString(ARG_TEXT);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getContext())
                .setTitle(title)
                .setMessage(text)
                .setPositiveButton("OK", null)
                .create();
    }
}

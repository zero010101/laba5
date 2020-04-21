package com.renthut.part3;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.provider.Settings;

import java.util.Objects;

public class NotificationReceiver extends BroadcastReceiver {
    public NotificationReceiver() {
        super();
    }

    public NotificationReceiver(BroadcastListener mListener) {
        this.mListener = mListener;
    }

    interface BroadcastListener {
        void onAction(String title, String text);
    }

    private BroadcastListener mListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_CAMERA_BUTTON)){
            mListener.onAction("Achtung!", "Camera button is pressed.");
        }

        if (intent.getAction().equals(Intent.ACTION_BATTERY_LOW)) {
            mListener.onAction("Low battery", "Low Battery Level.");
        }

        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            if (Settings.Global.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON, 0) != 0) {
                mListener.onAction("Airplane mode", "Airplane mode is on.");
            } else {
                mListener.onAction("Airplane mode", "Airplane mode is off.");
            }
        }
    }
}

package com.renthut.part3;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements NotificationReceiver.BroadcastListener {

    private NotificationReceiver receiver;

    @Override
    protected void onStart() {
        super.onStart();

        receiver = new NotificationReceiver(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CAMERA_BUTTON);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (receiver != null)
            unregisterReceiver(receiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestCameraPermission();
    }

    @Override
    public void onAction(String title, String text) {
        NotifyDialog dialog = NotifyDialog.newInstance(title, text);
        dialog.show(getSupportFragmentManager(), "receiver");
    }

    private void requestCameraPermission() {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
        }
    }
}

package com.railsfactory.anurag.androidlibrarytutorials;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyComponent component = DaggerMyComponent.builder().build();
        component.inject(this);

        ((TextView) findViewById(R.id.result)).setText(String.format("Speed: %s", vehicle.getSpeed()));

        Toast.makeText(this, "Increasing Speed", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                vehicle.increaseSpeed(60);
                ((TextView) findViewById(R.id.result)).setText(String.format("Speed: %s", vehicle.getSpeed()));
            }
        }, 3000);
    }
}
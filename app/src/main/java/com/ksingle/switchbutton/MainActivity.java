package com.ksingle.switchbutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwitchButton switchButton = (SwitchButton) findViewById(R.id.switchButton);
        switchButton.setText("Left","Right");
        switchButton.setChecked(false);
        switchButton.setColor(Color.parseColor("#CD1280"),Color.parseColor("#564891"));
        switchButton.setMode(SwitchButton.switch_default);
        //switchButton.setMode(SwitchButton.button_like);
    }
}

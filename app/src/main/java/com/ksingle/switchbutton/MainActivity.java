package com.ksingle.switchbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    SwitchButton switchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchButton = (SwitchButton) findViewById(R.id.switchButton);
        switchButton.setText("Left","Right");
        switchButton.setChecked(false);
        switchButton.defColor(R.color.SwitchOnColor,R.color.SwitchOffColor,R.color.TextColor);
        //switchButton.setColor(Color.parseColor("#CD1280"),Color.parseColor("#564891"));
        switchButton.setMode(SwitchButton.button_like);
        //switchButton.setMode(SwitchButton.button_like);

        textView = (TextView) findViewById(R.id.textView);

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = switchButton.isChecked()+"";
                textView.setText(string);
            }
        });

    }
}

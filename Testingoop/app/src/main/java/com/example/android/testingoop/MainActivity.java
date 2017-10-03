package com.example.android.testingoop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView text = new TextView(this);
        text.setText("hello Usman");
        text.setTextColor(Color.GREEN);
        text.setTextSize(20);
        text.setMaxLines(2);
        setContentView(R.layout.activity_main);
    }
}

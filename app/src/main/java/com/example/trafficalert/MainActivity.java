package com.example.trafficalert;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView panicNow;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panicNow = findViewById(R.id.panicNow);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            i++;
            Handler handler= new Handler();
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    i=0;
                }
            };
            if(i==1){
                panicNow.setText("NOT AN EMERGENCY");
                handler.postDelayed(runnable,200);
            }
            else if(i==2){
                panicNow.setText("NEED HELP");
            }

            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}

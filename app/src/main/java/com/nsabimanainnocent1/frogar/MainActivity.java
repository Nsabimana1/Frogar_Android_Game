package com.nsabimanainnocent1.frogar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gameIntent = new Intent(MainActivity.this, GameScreen.class);
                startActivity(gameIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}

package com.nsabimanainnocent1.frogar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {
    private ImageView imageViewRoad;
    private TextView healthTitle, scoreTitle, scoreValueView;
    private Button playButton, restartButton;
    private Integer scoreValue = 0;
    private Float imageX = 0f, imageY = 0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setComponents();

//        imageX = imageViewRoad.getX();
//        imageY = imageViewRoad.getY();
//        scoreValueView.setText(imageX.toString());
//        imageViewRoad.setX(new Float(4555));



//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void setComponents(){
//        imageViewRoad = (ImageView) findViewById(R.id.imageViewRoad);
        healthTitle = findViewById(R.id.heathTitle);
        scoreTitle = findViewById(R.id.scoreTitle);
        scoreValueView = findViewById(R.id.scoreValue);
    }


}

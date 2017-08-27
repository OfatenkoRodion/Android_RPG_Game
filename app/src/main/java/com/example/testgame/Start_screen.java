package com.example.testgame;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start_screen extends AppCompatActivity implements View.OnClickListener {

    Button newGame;
    Button loadGame;
    Button exitGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        newGame=(Button)findViewById(R.id.buttonNewGame);
        loadGame=(Button)findViewById(R.id.buttonLoadGame);
        exitGame=(Button)findViewById(R.id.buttonExit);
        newGame.setOnClickListener(this);
        loadGame.setOnClickListener(this);
        exitGame.setOnClickListener(this);
    }
    @Override
    public void  onClick(View view){

        if(view==newGame){
            startActivity(new Intent(Start_screen.this,ActivityChooseHero.class));
        } else
        if(view==loadGame){

        } else
        if(view==exitGame){
            System.exit(0);
        }
    }
}

package com.example.testgame;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class FightActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt;

   ProgressBar pb;
   int progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       pb=(ProgressBar)findViewById(R.id.progressBar);
        bt=(Button)findViewById(R.id.button);

    }

    @Override
    public void  onClick(View view){
        if (view.getId()==R.id.button){
            pb.setProgress(progress);
            pb.setIndeterminate(false);
            progress+=10;
          }


    }
}
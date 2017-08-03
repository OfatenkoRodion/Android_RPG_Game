package com.example.testgame;

import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Handler;
import android.widget.TextView;

public class FightActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt;
    ProgressBar progressBarPlayer;
    ProgressBar progressBarOponent;
    TextView textViewPlayer;
    TextView textViewOponent;
    Character player;
    NPC oponent;

    Handler h;
    Thread outputHP;

    final  int START_CODE=1;
    int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        progressBarPlayer=(ProgressBar)findViewById(R.id.progressBarCharHP);
        progressBarOponent=(ProgressBar)findViewById(R.id.progressBarOponenHP);
        textViewPlayer=(TextView) findViewById(R.id.textViewPlayerHP);
        textViewOponent=(TextView) findViewById(R.id.textViewOponentHP);

        player = ( Character) getIntent().getParcelableExtra(
                Character.class.getCanonicalName());
        oponent = ( NPC) getIntent().getParcelableExtra(
                NPC.class.getCanonicalName());

        progressBarPlayer.setMax(player.HP);
        progressBarOponent.setMax(oponent.HP);

        progressBarPlayer.setProgress(player.HP);
        progressBarOponent.setProgress(oponent.HP);

        bt=(Button)findViewById(R.id.buttonSt);
        bt.setOnClickListener(this);

        h = new Handler() {
            public void handleMessage(android.os.Message msg) {
                if (msg.what==START_CODE){
                progressBarPlayer.setProgress(player.HP);
                textViewPlayer.setText("HP: "+player.HP);
                progressBarOponent.setProgress(oponent.HP);
               textViewOponent.setText("HP: "+oponent.HP);
                }
            };};

        outputHP = new Thread(new Runnable() {
            public void run() {
                do {
                    h.sendEmptyMessage(1);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (player.isDead()==false && oponent.isDead()==false);
            }
        });

        BattleRound br = new BattleRound(player,oponent);
    }

    @Override
    public void  onClick(View view){
        if (view.getId()==R.id.buttonSt){
           BattleRound br = new BattleRound(player,oponent);
           outputHP.start();
           bt.setClickable(false);
          }
    }
}

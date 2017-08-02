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
    ProgressBar progressBarPlayer;
    ProgressBar progressBarOponent;

    Character player;
    NPC oponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        progressBarPlayer=(ProgressBar)findViewById(R.id.progressBarCharHP);
        progressBarOponent=(ProgressBar)findViewById(R.id.progressBarOponenHP);

        player = ( Character) getIntent().getParcelableExtra(
                Character.class.getCanonicalName());
        oponent = ( NPC) getIntent().getParcelableExtra(
                NPC.class.getCanonicalName());

        progressBarPlayer.setMax(player.HP);
        bt=(Button)findViewById(R.id.buttonSt);
        bt.setOnClickListener(this);

        BattleRound br = new BattleRound(player,oponent);
    }
    @Override
    public void  onClick(View view){
        if (view.getId()==R.id.buttonSt){
            progressBarPlayer.setProgress(player.HP);
            progressBarOponent.setProgress(oponent.HP);
          }
    }
}

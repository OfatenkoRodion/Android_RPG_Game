package com.example.testgame;

import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Handler;
import android.widget.TextView;
import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ActivityFight extends Activity implements View.OnClickListener{

    Button bt;
    ProgressBar progressBarPlayer;
    ProgressBar progressBarOponent;
    TextView textViewPlayer;
    TextView textViewOponent;
    Character player;
    NPC oponent;

    Handler h;
    Thread outputHP;
    BattleRound br;
    final  int START_CODE=1;
    private Animation mEnlargeAnimation;

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

        mEnlargeAnimation = AnimationUtils.loadAnimation(this, R.anim.enlarge);

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

               while (true){
                    if (br.isFinish()==true){
                Intent intent = new Intent();
                intent.putExtra( Character.class.getCanonicalName(), player);
                intent.putExtra( NPC.class.getCanonicalName(), oponent);
                setResult(RESULT_OK, intent);
                finish();}}
            }
        });
    }
    @Override
    public void  onClick(View view){
        if (view.getId()==R.id.buttonSt){
           br = new BattleRound(player,oponent);
           outputHP.start();
           bt.setClickable(false);
            bt.startAnimation(mEnlargeAnimation);
          }
    }
}

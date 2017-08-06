package com.example.testgame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TwoActivity extends Activity implements View.OnClickListener
{
    Button buttonStartFight;
    Character player;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        player = ( Character) getIntent().getParcelableExtra(
                Character.class.getCanonicalName());
        buttonStartFight=(Button)findViewById(R.id.buttonStartFight);


        buttonStartFight.setOnClickListener(this);
    }
    @Override
    public void  onClick(View view){

        if(view.getId()==R.id.buttonStartFight){
            Intent intent = new Intent(TwoActivity.this, FightActivity.class);
            intent.putExtra( Character.class.getCanonicalName(), player);
            intent.putExtra( NPC.class.getCanonicalName(), new NPC_wolf());
            startActivity(intent);
        }
    }
}
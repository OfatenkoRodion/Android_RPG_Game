package com.example.testgame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import java.util.Set;
import java.util.HashSet;
import java.io.*;
import java.net.*;



public class ActivitySpawner extends Activity implements View.OnClickListener
{
    Button buttonStartFight;
    Character player;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spawner);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        player = ( Character) getIntent().getParcelableExtra(
                Character.class.getCanonicalName());
        buttonStartFight=(Button)findViewById(R.id.buttonStartFight);
        buttonStartFight.setOnClickListener(this);

        ((TextView) findViewById(R.id.spawnerInfo)).setText(player.toString());
    }
    @Override
    public void  onRestart(){
        super.onRestart();
        ((TextView) findViewById(R.id.spawnerInfo)).setText(player.toString());
    }

    @Override
    public void  onClick(View view) {

        if(view.getId()==R.id.buttonStartFight){
            Intent intent = new Intent(ActivitySpawner.this, FightActivity.class);
            intent.putExtra( Character.class.getCanonicalName(), player);
            intent.putExtra( NPC.class.getCanonicalName(), new NPC_wolf());
            startActivityForResult(intent, 1);}

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data == null) {return;}
        player = ( Character) data.getParcelableExtra(
                Character.class.getCanonicalName());
    }
}
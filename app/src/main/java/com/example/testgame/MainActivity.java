package com.example.testgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button openVampire;
    Button openGolem;
    Button openReptilian;
    Button test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        openVampire=(Button)findViewById(R.id.vampireButton);
        openVampire.setOnClickListener(this);

        openGolem=(Button)findViewById(R.id.golemButton);
        openGolem.setOnClickListener(this);

        openReptilian=(Button)findViewById(R.id.reptilianButton);
        openReptilian.setOnClickListener(this);

    }
    @Override
    public void  onClick(View view){

        Intent intent = new Intent(MainActivity.this,ActivitySwitchHomeSpawn.class);

        if(view.getId()==R.id.vampireButton){
            Character player = new CharacterVampire();
            intent.putExtra( Character.class.getCanonicalName(), player);
            startActivity(intent);}

        if(view.getId()==R.id.golemButton){
            Character player = new CharacterGolem();
            intent.putExtra( Character.class.getCanonicalName(), player);
            startActivity(intent);}

        if(view.getId()==R.id.reptilianButton){
            Character player = new CharacterReptilian();
            intent.putExtra( Character.class.getCanonicalName(), player);
            startActivity(intent);}


    }
}

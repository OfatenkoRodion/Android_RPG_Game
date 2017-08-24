package com.example.testgame;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityCharacter extends AppCompatActivity implements View.OnClickListener {

    Character player;
    Button buttonStartFight;
    NPC_wolf wolf;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_character);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

       player = ( Character) getIntent().getParcelableExtra(
               Character.class.getCanonicalName());

        wolf = new NPC_wolf();

        buttonStartFight=(Button)findViewById(R.id.buttonStartFight);

        tv=(TextView)findViewById(R.id.textViewCharacterInfo);
        buttonStartFight.setOnClickListener(this);
        ViewCharacterInfo();
    }
    @Override
    public void  onClick(View view){

       if(view.getId()==R.id.buttonGiveExp){

           Intent intent = new Intent(ActivityCharacter.this, FightActivity.class);
           intent.putExtra( Character.class.getCanonicalName(), player);
           intent.putExtra( NPC.class.getCanonicalName(), wolf);
           startActivity(intent);
       }
    }
    private void ViewCharacterInfo(){

        tv.setText(player.toString()+ wolf.toString());
    }


}

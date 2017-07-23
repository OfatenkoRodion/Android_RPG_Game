package com.example.testgame;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CharacterActivity extends AppCompatActivity implements View.OnClickListener {

    Character player;
    Button buttonGiveExp;
    Button fWolf;
    Button status;
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


        buttonGiveExp=(Button)findViewById(R.id.buttonGiveExp);
        status=(Button)findViewById(R.id.buttonStats);
        fWolf=(Button)findViewById(R.id.buttonFightWolf);
        tv=(TextView)findViewById(R.id.textViewCharacterInfo);

        status.setOnClickListener(this);
        fWolf.setOnClickListener(this);
        buttonGiveExp.setOnClickListener(this);
        ViewCharacterInfo();
    }
    @Override
    public void  onClick(View view){

       if(view.getId()==R.id.buttonGiveExp){
           player.Get_exp(50);
           ViewCharacterInfo();
       }
        if(view.getId()==R.id.buttonFightWolf){

            wolf  = new NPC_wolf();
            BattleRound br = new BattleRound(player,wolf);

            CharSequence text = "Бой окончен";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
        }
        if(view.getId()==R.id.buttonStats){
            ViewCharacterInfo();

        }
    }
    private void ViewCharacterInfo(){

        tv.setText(player.toString()+ wolf.toString());
    }


}

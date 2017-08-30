package com.example.testgame;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class ActivityStart_screen extends Activity implements View.OnClickListener {

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
            startActivity(new Intent(ActivityStart_screen.this,ActivityChooseHero.class));
        } else
        if(view==loadGame){
            String expCount=HeroPreferences.getDefaults("exp",getApplicationContext());

            if (expCount!=null || expCount!="" ){
                String heroType=HeroPreferences.getDefaults("type",getApplicationContext());
                try{
                    Class temp= Class.forName(heroType);
                   Character player  = (Character) temp.newInstance();
                    player.add_exp(Integer.valueOf(expCount));

                    Intent intent = new Intent(ActivityStart_screen.this,ActivitySwitchHomeSpawn.class);

                    intent.putExtra( Character.class.getCanonicalName(), player);
                    startActivity(intent);
                }
                catch (ClassNotFoundException e) {
                    Toast.makeText(this,"не найден класс, который хотим получить как \"класс\" героя", Toast.LENGTH_SHORT).show();
                    // не найден класс, который хотим получить как "класс" героя
                }
                catch (Exception e) {
                    Toast.makeText(this,"не вышло создать объект полученного \"класса\"", Toast.LENGTH_SHORT).show();
                    // не вышло создать объект полученного "класса"
                }
            } else  Toast.makeText(this,"Предидущих игр не найденно!", Toast.LENGTH_SHORT).show();
        } else
        if(view==exitGame){
            System.exit(0);
        }
    }
}

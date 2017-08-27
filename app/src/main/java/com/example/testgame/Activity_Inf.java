package com.example.testgame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_Inf extends Activity  {

    Character player;

    TextView info;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

       info =(TextView)findViewById(R.id.info);
        player = ( Character) getIntent().getParcelableExtra(
                Character.class.getCanonicalName());
        info.setText(player.toString());
    }
    @Override
    protected void onRestart() {
        super.onRestart();
       // info.setText("я вернулся");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        info.setText("onActivityResult");
    }
}
package com.example.testgame;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class ActivitySwitchHomeSpawn extends TabActivity {

    Character player;
    Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        player = ( Character) getIntent().getParcelableExtra(
                Character.class.getCanonicalName());
        // получаем TabHost
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("Home");

        intent = new Intent(ActivitySwitchHomeSpawn.this, Activity_Inf.class);
        intent.putExtra( Character.class.getCanonicalName(), player );

        tabSpec.setContent(intent);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Spawn");

        intent = new Intent(ActivitySwitchHomeSpawn.this,ActivitySpawner.class);
        intent.putExtra( Character.class.getCanonicalName(), player );

        tabSpec.setContent(intent);
        tabHost.addTab(tabSpec);
    }


}

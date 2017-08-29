package com.example.testgame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

import java.util.List;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;

public class ActivitySpawner extends Activity
{
    Character player;
    ListView mobslistView;
    SpawnerSystem S_Sys;
    NPC oponent;
    List<String> mobs;
    ListAdapter adapter;

    SharedPreferences sPref;
   public static final String SAVED_HERO_EXP = "hero_exp";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spawner);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        player = ( Character) getIntent().getParcelableExtra(
                Character.class.getCanonicalName());
        mobslistView = (ListView)findViewById(R.id.listView);
        initSpawnersystem();
        ((TextView) findViewById(R.id.spawnerInfo)).setText(player.toString());
        HeroPreferences.setDefaults("type",(player.getClass()).getName().toString(),getApplicationContext());


    }
    private void initSpawnersystem(){
        S_Sys = new  SpawnerSystem();
        mobs =S_Sys.getStringListMobs();
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, mobs);
        mobslistView.setAdapter(adapter);
        mobslistView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                if ((oponent = S_Sys.getOponenthMob(position))!=null){
                    Intent intent = new Intent(ActivitySpawner.this, FightActivity.class);
                    intent.putExtra( Character.class.getCanonicalName(), player);
                    intent.putExtra( NPC.class.getCanonicalName(), oponent);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }
    @Override
    public void  onRestart(){
        super.onRestart();
        ((TextView) findViewById(R.id.spawnerInfo)).setText(player.toString());
        refreshListView();
    }
    private void refreshListView(){
        mobs.clear();
        mobs.addAll(S_Sys.getStringListMobs());
        //adapter.notifyDataSetChanged(); не может найти метод,надо понять почему :C
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, mobs);
        mobslistView.setAdapter(adapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        player = ( Character) data.getParcelableExtra(
                Character.class.getCanonicalName());
        NPC temp=(NPC) data.getParcelableExtra(
                NPC.class.getCanonicalName());
        S_Sys.unblockMob( (NPC) data.getParcelableExtra(
                NPC.class.getCanonicalName()));
        HeroPreferences.setDefaults("exp",String.valueOf(player.getCurrent_experience()),getApplicationContext());
        Toast.makeText(this,"Сохранено", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
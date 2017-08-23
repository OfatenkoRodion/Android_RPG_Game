package com.example.testgame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;

public class ActivitySpawner extends Activity implements View.OnClickListener
{
    Button buttonStartFight;
    Character player;
    ListView mobslistView;
    SpawnerSystem S_Sys;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spawner);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        player = ( Character) getIntent().getParcelableExtra(
                Character.class.getCanonicalName());
        buttonStartFight=(Button)findViewById(R.id.buttonStartFight);
        buttonStartFight.setOnClickListener(this);

        mobslistView = (ListView)findViewById(R.id.listView);

        ((TextView) findViewById(R.id.spawnerInfo)).setText(player.toString());

        S_Sys = new  SpawnerSystem();
        List<String> mobs =npcToString(S_Sys.getListMobs());
        ListAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, mobs);
        mobslistView.setAdapter(adapter);

        mobslistView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                Toast.makeText(getApplicationContext(),position, Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public void  onRestart(){
        super.onRestart();
        ((TextView) findViewById(R.id.spawnerInfo)).setText(player.toString());
    }

    @Override
    public void  onClick(View view) {

       /* if(view.getId()==R.id.buttonStartFight){
            Intent intent = new Intent(ActivitySpawner.this, FightActivity.class);
            intent.putExtra( Character.class.getCanonicalName(), player);
            intent.putExtra( NPC.class.getCanonicalName(), new NPC_wolf());
            startActivityForResult(intent, 1);}
*/
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        player = ( Character) data.getParcelableExtra(
                Character.class.getCanonicalName());
    }

    private List<String> npcToString( List<NPC> npcList ){
        List<String> mobsString = new ArrayList<String>();
        for (int i=0;i<npcList.size();i++){
            mobsString.add(npcList.get(i).toString());
        }
        return mobsString;
    }
}
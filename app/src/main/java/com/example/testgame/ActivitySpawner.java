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

import static java.util.stream.Collectors.*;

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
    public void  onClick(View view){

       /* if(view.getId()==R.id.buttonStartFight){
            Intent intent = new Intent(ActivitySpawner.this, FightActivity.class);
            intent.putExtra( Character.class.getCanonicalName(), player);
            intent.putExtra( NPC.class.getCanonicalName(), new NPC_wolf());
            startActivityForResult(intent, 1);}*/


       /* Set a= ( new Reflections(getApplicationContext().getPackageName()).getSubTypesOf(Adam.class));

        String[] array = (String[])a.toArray(new String[0]);
        String aaa ="";
        for (int i=0;i<array.length;i++){
            aaa+=array[i];
        }
        ((TextView) findViewById(R.id.spawnerInfo)).setText(aaa);*/
        Set<Class<?>> s = loadClasses("com.example.testgame").stream()
                .filter(i->checkAllParents(i, Character.class))
                .collect(Collectors.toSet());

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data == null) {return;}
        player = ( Character) data.getParcelableExtra(
                Character.class.getCanonicalName());
    }

    public static Set<Class<?>> loadClasses(String packageName)
            throws ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<>();
        URL resource = Thread.currentThread()
                .getContextClassLoader()
                .getResource(packageName.replace('.', '/'));
        File directory
                = new File(resource.getFile());
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            return classes;
        }
        for (File file : files) {
            //в другие пакеты уходить ненужно
            if (file.isFile() && file.getName().endsWith(".class")) {
                classes.add(Class
                        .forName(String.format("%s.%s",
                                packageName,
                                file.getName().substring(0, file.getName().indexOf(".")))));
            }
        }
        return classes;
    }
    public static boolean checkAllParents(Class<?> type, Class<?> hasParentType) {
        Class<?> parent = type.getSuperclass();
        if (parent == Object.class) {
            return false;
        }
        if (parent.getClass() == hasParentType.getClass()) {
            return true;
        }
        return checkAllParents(parent, hasParentType);
    }
}
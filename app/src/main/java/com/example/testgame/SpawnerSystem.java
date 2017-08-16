package com.example.testgame;

import android.widget.TextView;

import java.util.ArrayList;

public class SpawnerSystem {

    static int MAX_MOBS_COUNT=6;

    ArrayList<NPC> available_mobs;

    public SpawnerSystem(){
        available_mobs= new ArrayList<NPC>();
    }
    private boolean add_mobs(){
        try {
            RandomNPC rNPC = new RandomNPC();

            for (int i=0;i<MAX_MOBS_COUNT;i++){
            NPC newNPC = (NPC) rNPC.nextCharacter().newInstance();
            available_mobs.add(newNPC);}

            return  true;
            }
        catch (Exception e){
            return  false;
            }
    }
}

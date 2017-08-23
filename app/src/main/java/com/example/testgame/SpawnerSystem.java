package com.example.testgame;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpawnerSystem {

    static int MAX_MOBS_COUNT=6;
   private List<NPC> available_mobs;

    public SpawnerSystem(){
        available_mobs= new ArrayList<NPC>();
        add_mobs();
    }
    public List<NPC> getListMobs(){
        return  available_mobs;
    }
    private boolean add_mobs(){
        try {
            RandomNPC rNPC = new RandomNPC();

            for (int i=0;i<MAX_MOBS_COUNT;i++){
            NPC newNPC = (NPC) rNPC.nextNPC().newInstance();
            available_mobs.add(newNPC);}

            return  true;
            }
        catch (Exception e){
            return  false;
            }
    }
}

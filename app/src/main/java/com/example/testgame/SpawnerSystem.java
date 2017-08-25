package com.example.testgame;

import java.util.ArrayList;
import java.util.List;
import android.os.CountDownTimer;

public class SpawnerSystem {

    static int MAX_MOBS_COUNT=6;
   private List<NPC> available_mobs;
    int blockedMobNomber=-1;

    public SpawnerSystem(){
        available_mobs= new ArrayList<NPC>();
        add_mobs();
    }
    public List<NPC> getNPCListMobs(){
        return  available_mobs;
    }
    public List<String> getStringListMobs(){

        return  npcToString(available_mobs);
    }
    public NPC getOponenthMob(int mobNomber){
        if (mobNomber>6){
            return null;
        }
        if(available_mobs.get(mobNomber)==null){
            return null;
        }
        if (blockedMobNomber!=-1){
            return null;
        }
        blockedMobNomber=mobNomber;
        return available_mobs.get(mobNomber);
    }
    public void unblockMob(NPC npc){
        if (blockedMobNomber!=-1){
            available_mobs.set(blockedMobNomber,npc);
            if (npc.isDead()==true){removeMob(blockedMobNomber);}
            respawnMob(blockedMobNomber);
            blockedMobNomber=-1;
        }
    }
    private void removeMob(int mobNomber ){
        available_mobs.set(mobNomber,null);
    }
    private void respawnMob(final int mobNomber){//final что бы мы не могли поменять параметр в методе,типо:
                                                // какие значение до таймера, такие и гарантируем в конце для его onFinish
        new CountDownTimer(300000, 1000) {
            public void onTick(long millisUntilFinished) {}
            public void onFinish() {
                try{
                RandomNPC rNPC = new RandomNPC();
                NPC newNPC = (NPC) rNPC.nextNPC().newInstance();
                    available_mobs.set(mobNomber,newNPC);
                }
                catch (Exception e){}
            }
        }.start();
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
    private List<String> npcToString( List<NPC> npcList ){
        List<String> mobsString = new ArrayList<String>();
        for (int i=0;i<npcList.size();i++){
            if (npcList.get(i)!=null){
            mobsString.add(npcList.get(i).toString());}
            else { mobsString.add(""); }
        }
        return mobsString;
    }

}

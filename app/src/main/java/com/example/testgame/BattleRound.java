package com.example.testgame;


import android.os.AsyncTask;
import android.os.SystemClock;

public class BattleRound {
    Beat hits_1;
    public BattleRound(Character player,NPC mob){

         hits_1= new Beat();

        hits_1.execute(player,mob);
    }
    public boolean isFinish(){
       if(hits_1.getStatus().toString()=="FINISHED"){
        return  true;
        } else return false;
    }

    public class Beat extends AsyncTask<Adam,Void,Void>{
        Adam attacking;
        Adam defensible;
        private int timer=0;
        private int startHp;
        @Override
        protected Void doInBackground(Adam...params){

            attacking  = params[0];
            defensible = params[1];

            if(attacking instanceof Character){
                startHp=attacking.HP;
            } else startHp=defensible.HP;

           while (defensible.isDead()==false && attacking.isDead()==false){
                if (timer % attacking.At_SPD==0 ){
                attacking.giveDmg(defensible);}
                if (timer % defensible.At_SPD==0 ){
                defensible.giveDmg(attacking);}
                timer++;
                SystemClock.sleep(1000);
        }

            return null;
        }
        @Override
        protected void onPostExecute(Void rez){
            if(attacking instanceof Character){
                attacking.HP=startHp;
                if (defensible.isDead()==true){
                ((Character)attacking).add_exp(((NPC)defensible).ExperienceCost);}
            }
            if(defensible instanceof Character){
                defensible.HP=startHp;
                if (attacking.isDead()==true){
                ((Character)defensible).add_exp(((NPC)attacking).ExperienceCost);}
            }
        }
    }
}

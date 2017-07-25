package com.example.testgame;


import android.os.AsyncTask;
import android.os.SystemClock;

public class BattleRound {
    public BattleRound(Character player,NPC mob){

        Beat hits_1= new Beat();

        hits_1.execute(player,mob);


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
            if(attacking.getClass()==Character.class){
                startHp=attacking.HP;
            } else startHp=defensible.HP;

         /*   while (attacking.isDead()==false || defensible.isDead()==false){

                attacking.giveDmg(defensible);
                SystemClock.sleep((int)(1000*attacking.At_SPD));

            }

*/     while (defensible.isDead()==false && attacking.isDead()==false){
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

            if(attacking.getClass()==Character.class){
                if(attacking.isDead()==false){
                    Character tempCh=(Character)attacking;
                    NPC tempNPC =(NPC) defensible;
                  tempCh.Get_exp(tempNPC.ExperienceCost);
                    tempCh.HP=startHp;

            }

            }


        }

    }



}

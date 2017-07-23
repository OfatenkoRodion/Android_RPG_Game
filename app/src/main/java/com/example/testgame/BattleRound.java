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
        @Override
        protected Void doInBackground(Adam...params){

            attacking  = params[0];
            defensible = params[1];

         /*   while (attacking.isDead()==false || defensible.isDead()==false){

                attacking.giveDmg(defensible);
                SystemClock.sleep((int)(1000*attacking.At_SPD));

            }

*/     while (defensible.isDead()==false && attacking.isDead()==false){
                attacking.giveDmg(defensible);
                defensible.giveDmg(attacking);
                SystemClock.sleep(1000);
        }

            return null;
        }
        @Override
        protected void onPostExecute(Void rez){

        }

    }



}

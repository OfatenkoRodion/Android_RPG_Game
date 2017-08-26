package com.example.testgame;

        import android.os.Parcel;
        import android.os.Parcelable;

public class NPC_Imp  extends NPC{
    public NPC_Imp(){
        HP=171;
        DMG=18;
        At_SPD=2;
        ExperienceCost=43;
    }
    public NPC_Imp(Parcel in) {
        String[] data = new String[4];
        in.readStringArray(data);
        HP = Integer.parseInt(data[0]);
        DMG = Integer.parseInt(data[1]);
        At_SPD = Double.parseDouble(data[2]);
        ExperienceCost = Integer.parseInt(data[3]);
    }
    @Override
    public void  giveDmg(Adam adam){
        adam.takeDmg(this,DMG);
    }
    @Override
    public void takeDmg(Adam adam,int dmg){
        HP=HP-dmg;
    }

    public static final Parcelable.Creator<NPC> CREATOR = new Parcelable.Creator<NPC>() {

        @Override
        public NPC createFromParcel(Parcel source) {
            return new NPC_wolf (source);
        }

        @Override
        public NPC[] newArray(int size) {
            return new NPC_wolf[size];
        }
    };
}


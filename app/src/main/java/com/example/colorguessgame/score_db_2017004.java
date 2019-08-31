package com.example.colorguessgame;

import android.os.Parcel;
import android.os.Parcelable;

class score_db_2017004 implements Parcelable {
    private String date;
    private String time;
    private String score;

    score_db_2017004(){
        this.date="";
        this.time="";
        this.score="";
    }

    score_db_2017004( String date, String time, int score){
        this.date=date;
        this.time=time;
        this.score=Integer.toString(score);
    }

    private score_db_2017004(Parcel in) {
        date = in.readString();
        time = in.readString();
        score = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(time);
        dest.writeString(score);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<score_db_2017004> CREATOR = new Creator<score_db_2017004>() {
        @Override
        public score_db_2017004 createFromParcel(Parcel in) {
            return new score_db_2017004(in);
        }

        @Override
        public score_db_2017004[] newArray(int size) {
            return new score_db_2017004[size];
        }
    };

    String getDate() {
        return date;
    }

    String getTime() {
        return time;
    }

    String getScore() {
        return score;
    }
}

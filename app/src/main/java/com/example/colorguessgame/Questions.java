package com.example.colorguessgame;

import android.os.Parcel;
import android.os.Parcelable;

class Questions implements Parcelable {
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Color correct_ans;

    Questions(String option1, String option2, String option3, String option4, Color correct_ans){
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
        this.correct_ans=correct_ans;
    }

    private Questions(Parcel in) {
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        option4 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeString(option4);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Questions> CREATOR = new Creator<Questions>() {
        @Override
        public Questions createFromParcel(Parcel in) {
            return new Questions(in);
        }

        @Override
        public Questions[] newArray(int size) {
            return new Questions[size];
        }
    };

    String getOption1() {
        return option1;
    }

    String getOption2() {
        return option2;
    }

    String getOption3() {
        return option3;
    }

    String getOption4() {
        return option4;
    }

    Color getCorrect_ans() {
        return correct_ans;
    }


}

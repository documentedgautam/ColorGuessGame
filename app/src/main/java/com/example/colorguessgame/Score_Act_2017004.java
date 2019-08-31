package com.example.colorguessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Score_Act_2017004 extends AppCompatActivity {

    private static final String TAG1=Start_Act_2017004.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score__act_2017004);
        Button back=findViewById(R.id.go_back);
        TextView dtv1=findViewById(R.id.dtv1);
        TextView dtv2=findViewById(R.id.dtv2);
        TextView dtv3=findViewById(R.id.dtv3);
        TextView dtv4=findViewById(R.id.dtv4);
        TextView dtv5=findViewById(R.id.dtv5);
        TextView ttv1=findViewById(R.id.ttv1);
        TextView ttv2=findViewById(R.id.ttv2);
        TextView ttv3=findViewById(R.id.ttv3);
        TextView ttv4=findViewById(R.id.ttv4);
        TextView ttv5=findViewById(R.id.ttv5);
        TextView stv1=findViewById(R.id.stv1);
        TextView stv2=findViewById(R.id.stv2);
        TextView stv3=findViewById(R.id.stv3);
        TextView stv4=findViewById(R.id.stv4);
        TextView stv5=findViewById(R.id.stv5);
        ArrayList<score_db_2017004> score_list = MainActivity_2017004.score_list;
        Log.d(TAG1, "point 1 in date "+score_list.size()+" "+score_list.get(score_list.size()-1).getDate());
        Log.d(TAG1, "point 1 in time "+score_list.size()+" "+score_list.get(score_list.size()-1).getTime());
        Log.d(TAG1, "point 1 in score "+score_list.size()+" "+score_list.get(score_list.size()-1).getScore());
        dtv1.setText(score_list.get(4).getDate());
        dtv2.setText(score_list.get(3).getDate());
        dtv3.setText(score_list.get(2).getDate());
        dtv4.setText(score_list.get(1).getDate());
        dtv5.setText(score_list.get(0).getDate());
        ttv1.setText(score_list.get(4).getTime());
        ttv2.setText(score_list.get(3).getTime());
        ttv3.setText(score_list.get(2).getTime());
        ttv4.setText(score_list.get(1).getTime());
        ttv5.setText(score_list.get(0).getTime());
        stv1.setText(score_list.get(4).getScore());
        stv2.setText(score_list.get(3).getScore());
        stv3.setText(score_list.get(2).getScore());
        stv4.setText(score_list.get(1).getScore());
        stv5.setText(score_list.get(0).getScore());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

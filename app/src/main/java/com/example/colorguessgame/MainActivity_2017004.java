package com.example.colorguessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity_2017004 extends AppCompatActivity {

    public static ArrayList<score_db_2017004> score_list=new ArrayList<>(6);
    public static boolean f=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start=findViewById(R.id.Start);
        Button scores=findViewById(R.id.Score);
        Button Instructions=findViewById((R.id.Inst));
        Button Exit=findViewById(R.id.Exit);
        if(f) {
            for (int k = 0; k < 5; k++) {
                score_list.add(new score_db_2017004());
            }
            f=false;
        }
        if(savedInstanceState!=null){
            score_list=savedInstanceState.getParcelableArrayList("score_list");
        }
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startgame();
            }
        });
        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScores();
            }
        });
        Instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInstructions();
            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void startgame(){
        Intent intent=new Intent(MainActivity_2017004.this, Start_Act_2017004.class);
        startActivity(intent);
    }

    private void showScores(){
        Intent intent=new Intent(MainActivity_2017004.this, Score_Act_2017004.class);
        startActivity(intent);
    }

    private void showInstructions(){
        Intent intent=new Intent(MainActivity_2017004.this, Inst_Act_2017004.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("score_list", score_list);
    }

}

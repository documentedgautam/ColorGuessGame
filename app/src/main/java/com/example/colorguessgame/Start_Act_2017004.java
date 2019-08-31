package com.example.colorguessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

public class Start_Act_2017004 extends AppCompatActivity {
    private static final String TAG=Start_Act_2017004.class.getSimpleName();
    public static Random rand;
    private ArrayList<Color> Color_List=new ArrayList<>();
    private ArrayList<Questions> Ques_List=new ArrayList<>();
    private TextView score;
    private TextView question;
    private int score_count=0;
    private int question_count=1;
    private ImageView q_img;
    private RadioGroup optgroup;
    private RadioButton opt1;
    private RadioButton opt2;
    private RadioButton opt3;
    private RadioButton opt4;
    private ColorStateList OptdefaultColor;
    private Button ConfirmNext;
    private boolean answered;
    private int ind_check;
    public static ArrayList<score_db_2017004> score_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__act_2017004);

        //adding colors
        Color_List.add(new Color("Red",R.drawable.red));
        Color_List.add(new Color("Orange",R.drawable.orange));
        Color_List.add(new Color("Green",R.drawable.green));
        Color_List.add(new Color("Yellow",R.drawable.yellow));
        Color_List.add(new Color("Blue",R.drawable.blue));
        Color_List.add(new Color("White",R.drawable.white));
        Color_List.add(new Color("Violet",R.drawable.violet));
        Color_List.add(new Color("Purple",R.drawable.purple));
        Color_List.add(new Color("Pink",R.drawable.pink));
        Color_List.add(new Color("Brown",R.drawable.brown));
        Color_List.add(new Color("Black",R.drawable.black));
        Color_List.add(new Color("Grey",R.drawable.grey));
        //done
        Log.d(TAG, "point 1 "+Color_List.size());
        score=findViewById(R.id.score_count);
        question=findViewById(R.id.question);
        q_img=findViewById(R.id.quiz_img);
        optgroup=findViewById(R.id.optgroup);
        opt1=findViewById(R.id.opt1);
        opt2=findViewById(R.id.opt2);
        opt3=findViewById(R.id.opt3);
        opt4=findViewById(R.id.opt4);
        opt1.setId(0);
        opt2.setId(1);
        opt3.setId(2);
        opt4.setId(3);
        ConfirmNext=findViewById(R.id.next);
        OptdefaultColor=opt1.getTextColors();
        score_list=MainActivity_2017004.score_list;
        Log.d(TAG, "point 6");
        boolean real=false;
        if(savedInstanceState!=null){
            score_list=savedInstanceState.getParcelableArrayList("score_list");
            Ques_List=savedInstanceState.getParcelableArrayList("ques_list");
            score_count=savedInstanceState.getInt("score_count");
            question_count=savedInstanceState.getInt("ques_count");
            answered= savedInstanceState.getBoolean("ans");
            ind_check=savedInstanceState.getInt("check");
            real=answered;
        }
        if(Ques_List.size()==0) {
            fillQues_list();
        }
        Log.d(TAG, "point 2");
        showNextQuestion();
        if(real){
            if(ind_check==0){
                opt1.setChecked(true);
            }
            else if(ind_check==1){
                opt2.setChecked(true);
            }
            else if(ind_check==2){
                opt3.setChecked(true);
            }
            else if(ind_check==3){
                opt4.setChecked(true);
            }
            RadioButton selected=findViewById(optgroup.getCheckedRadioButtonId());
            if(selected.getText().equals(Ques_List.get(question_count-2).getCorrect_ans().getName())){
                score_count--;
                score.setText(getString(R.string.scoreTV,score_count));
            }
            check();
            Log.d(TAG, "check 2 done!! ");
        }
        Log.d(TAG, "point 3");
        ConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "point 8");
                check();
            }
        });
        Log.d(TAG, "point 4");
    }

    private void fillQues_list(){
        Collections.shuffle(Color_List);
        rand=new Random();
        int i=0,j=11;
        boolean flag=true;
        while(Ques_List.size()!=12){
            if(flag){
                Ques_List.add(new Questions(Color_List.get(i).getName(),
                        Color_List.get(i+2).getName(),
                        Color_List.get(i+4).getName(),
                        Color_List.get(i+6).getName(),
                        Color_List.get(i+2*rand.nextInt(4))
                        )
                );
                i++;
            }
            else{
                Ques_List.add(new Questions(Color_List.get(j).getName(),
                                Color_List.get(j-2).getName(),
                                Color_List.get(j-4).getName(),
                                Color_List.get(j-6).getName(),
                                Color_List.get(j-2*rand.nextInt(4))
                        )
                );
                j--;
            }
            flag=!flag;
        }
    }

    private void showNextQuestion(){
        Log.d(TAG, "show it!! ");
        opt1.setTextColor(OptdefaultColor);
        opt2.setTextColor(OptdefaultColor);
        opt3.setTextColor(OptdefaultColor);
        opt4.setTextColor(OptdefaultColor);
        optgroup.clearCheck();
        if(question_count<Ques_List.size()+1){
            q_img.setImageResource(Ques_List.get(question_count-1).getCorrect_ans().getImage());
            opt1.setText(Ques_List.get(question_count-1).getOption1());
            opt2.setText(Ques_List.get(question_count-1).getOption2());
            opt3.setText(Ques_List.get(question_count-1).getOption3());
            opt4.setText(Ques_List.get(question_count-1).getOption4());
            ConfirmNext.setText(getString(R.string.confirm));
            question.setText(getString(R.string.quesTV,question_count,Ques_List.size()));
            question_count++;
            score.setText(getString(R.string.scoreTV,score_count));
            answered=false;

        }
        else{
            finishquiz();
        }
    }

    private void finishquiz(){
        Calendar calender = Calendar.getInstance();
        calender.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        String cur_date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String cur_time=calender.get(Calendar.HOUR_OF_DAY) + ":" + calender.get(Calendar.MINUTE) +  ":" + calender.getActualMinimum(Calendar.SECOND);
        score_list.add(new score_db_2017004(cur_date, cur_time, score_count));
        if(score_list.size()>5){
            score_list.remove(0);
        }
        finish();
    }

    private void check(){
        Log.d(TAG, "check it!! ");
        if(!answered){
            if(opt1.isChecked() || opt2.isChecked() || opt3.isChecked() || opt4.isChecked()){
                matchwithcorrect();
            }
            else{
                Toast.makeText(Start_Act_2017004.this, "Please Choose an Answer", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            showNextQuestion();
        }
        Log.d(TAG, "check done!! ");
    }
    private void matchwithcorrect(){
        Log.d(TAG, "point 7");
        RadioButton selected=findViewById(optgroup.getCheckedRadioButtonId());
        if(selected.getText().equals(Ques_List.get(question_count-2).getCorrect_ans().getName())){
            score_count++;
            score.setText(getString(R.string.scoreTV,score_count));
        }
        tick_the_correct();
        Log.d(TAG, "match done!! ");
    }

    private void tick_the_correct(){
        Log.d(TAG, "tick it ");
//        if(answered){
//            question_count++;
//        }
        opt1.setTextColor(android.graphics.Color.RED);
        opt2.setTextColor(android.graphics.Color.RED);
        opt3.setTextColor(android.graphics.Color.RED);
        opt4.setTextColor(android.graphics.Color.RED);
        if(opt1.getText().equals(Ques_List.get(question_count-2).getCorrect_ans().getName())){
            opt1.setTextColor(android.graphics.Color.GREEN);
        }
        else if(opt2.getText().equals(Ques_List.get(question_count-2).getCorrect_ans().getName())){
            opt2.setTextColor(android.graphics.Color.GREEN);
        }
        else if(opt3.getText().equals(Ques_List.get(question_count-2).getCorrect_ans().getName())){
            opt3.setTextColor(android.graphics.Color.GREEN);
        }
        else{
            opt4.setTextColor(android.graphics.Color.GREEN);
        }
        if(question_count<Ques_List.size()+1){
            ConfirmNext.setText(getString(R.string.next));
        }
        else{
            ConfirmNext.setText(getString(R.string.finish));
        }
        answered=true;
        Log.d(TAG, "tick done!! ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("score_list", score_list);
        outState.putParcelableArrayList("ques_list", Ques_List);
        outState.putInt("score_count", score_count);
        outState.putInt("ques_count", question_count-1);
        outState.putBoolean("ans", answered);
        outState.putInt("check", optgroup.getCheckedRadioButtonId());
        Log.d(TAG,"noted "+optgroup.getCheckedRadioButtonId());
    }
}

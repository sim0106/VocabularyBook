package org.androidtown.vocabularybook;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Tab4Activity extends Activity{

    Button[] ButtonG = new Button[16];

    int[] btn = new int[16];
    int score=0;
    int file;

    ArrayList<String> arr = new ArrayList<String>();
    List<Integer> list = new ArrayList<Integer>();
    ArrayList<String> compareArr = new ArrayList<String>();
    private Boolean buttonRecognition=false;
    String temp;
    private TextView mScoreTextView = null;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab4_layout);
        mScoreTextView = (TextView)findViewById(R.id.gamescore);
        mScoreTextView.setTypeface(Typeface.createFromAsset(getAssets(), "m12.TTF"));
        mScoreTextView.setText("Score  " + score);
        mScoreTextView.setTextColor(Color.BLACK);

        Log.v("tag", "실행1");
        int button[] = {R.id.Button01, R.id.Button02, R.id.Button03, R.id.Button04, R.id.Button05, R.id.Button06,R.id.Button07, R.id.Button08,R.id.Button09,R.id.Button10,
                R.id.Button11, R.id.Button12, R.id.Button13, R.id.Button14, R.id.Button15,R.id.Button16};
        Log.v("tag", "실행2");



        for(int i=0; i<16; i++){
            ButtonG[i]=(Button)findViewById(button[i]);
            ButtonG[i].setTypeface(Typeface.createFromAsset(getAssets(), "NEXONFootballGothicB.ttf"));
        }


        Log.v("tag", "실행3");
         randNum(list);
        Log.v("tag", "실행4");
         readTextInit(list);
        Log.v("tag", "실행5");

         findText();
        for(int j=0; j<compareArr.size(); j++) {
            temp = ButtonG[j].getText().toString();
            for (int i = 0; i < compareArr.size(); i++) {

                if (temp.equals(compareArr.get(i))) {
                   btn[j]=i;
                }
            }
        }


    for(int i=0; i<16; i++){
        ButtonG[i].setTag(false);
    }



    ButtonG[0].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ((ButtonG[1].getTag()) == buttonRecognition && (ButtonG[2].getTag() == buttonRecognition) && (ButtonG[3].getTag() == buttonRecognition) && (ButtonG[4].getTag() == buttonRecognition) && (ButtonG[5].getTag() == buttonRecognition)
                    && (ButtonG[6].getTag() == buttonRecognition) && (ButtonG[7].getTag() == buttonRecognition) && (ButtonG[8].getTag() == buttonRecognition) && (ButtonG[9].getTag() == buttonRecognition) && (ButtonG[10].getTag() == buttonRecognition)
                    && (ButtonG[11].getTag() == buttonRecognition) && (ButtonG[12].getTag() == buttonRecognition) && (ButtonG[13].getTag() == buttonRecognition) && (ButtonG[14].getTag() == buttonRecognition) && (ButtonG[15].getTag() == buttonRecognition)) {
                ButtonG[0].setTag(true);
                Log.v("tag", "클릭");
            } else if ((Boolean) ButtonG[1].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[1]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[1].setVisibility(View.INVISIBLE);
                        ButtonG[1].setTag(false);
                        ButtonG[0].setTag(false);
                        scoreHandler();
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[1].setTag(false);
                        ButtonG[0].setTag(false);

                    }

                } else {
                    if ((btn[0] - 1) == btn[1]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[1].setVisibility(View.INVISIBLE);
                        ButtonG[1].setTag(false);
                        ButtonG[0].setTag(false);
                        scoreHandler();
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[1].setTag(false);
                        ButtonG[0].setTag(false);

                    }
                }
            } else if ((Boolean) ButtonG[2].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[2]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[2].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[2].setTag(false);
                        scoreHandler();
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[2].setTag(false);

                    }

                } else {
                    if ((btn[0] - 1) == btn[2]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[2].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[2].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[2].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[3].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[3]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[2].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[3].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[3].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[3]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[2].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[3].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[3].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[4].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[4]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[4].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[4].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[4].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[4]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[4].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[4].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[4].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[5].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[5]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[5].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[5].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[5].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[5]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[5].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[5].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[5].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[6].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[6]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[6].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[6].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[6].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[6]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[6].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[6].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[6].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[7].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[7]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[7].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[7].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[7].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[7]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[7].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[7].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[7].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[8].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[8]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[8].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[8].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[8].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[8]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[8].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[8].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[8].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[9].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[9]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[8].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[9].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[9].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[9]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[8].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[9].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[9].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[10].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[10]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[10].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[10].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[10].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[10]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[10].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[10].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[10].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[11].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[11]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[11].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[11].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[11].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[11]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[11].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[11].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[11].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[12].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[12]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[12].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[12].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[12].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[12]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[12].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[12].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[12].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[13].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[13]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[13].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[13].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[13].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[13]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[13].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[13].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[13].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[14].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[14]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[14].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[14].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[14].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[14]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[14].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[14].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[14].setTag(false);
                    }
                }
            } else if ((Boolean) ButtonG[15].getTag()) {
                if ((btn[0] % 2) == 0) {
                    if ((btn[0] + 1) == btn[15]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[15].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[15].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[15].setTag(false);
                    }

                } else {
                    if ((btn[0] - 1) == btn[15]) {
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                        scoreHandler();
                        ButtonG[0].setVisibility(View.INVISIBLE);
                        ButtonG[15].setVisibility(View.INVISIBLE);
                        ButtonG[0].setTag(false);
                        ButtonG[15].setTag(false);
                    } else {
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();
                        ButtonG[0].setTag(false);
                        ButtonG[15].setTag(false);
                    }
                }
            }
            endGame();
        }


    });

    ButtonG[1].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if((ButtonG[0].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                    &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                    &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                ButtonG[1].setTag(true);
            }else if((Boolean)ButtonG[0].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[0]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();
                        ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[0].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[0].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[0]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();
                        ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[0].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[0].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[2].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[2]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();
                        ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[2].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[2].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[2]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();
                        ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[2].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[2].setTag(false);
                    }
                }
            }
            else if((Boolean)ButtonG[3].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[3]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();
                        ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[3].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[3].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[3]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();
                        ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[3].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[3].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[4].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[4]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();
                        ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[4].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[4].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[4]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();
                        ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[4].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[4].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[5].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[5]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[5].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[5].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[5]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[5].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[5].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[6].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[6]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[6].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[6].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[6]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[6].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[6].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[7].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[7]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[7].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[7].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[7]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[7].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[7].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[8].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[8]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[8].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[8].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[8]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[8].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[8].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[9].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[9]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[9].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[9].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[9]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[9].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[9].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[10].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[10]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[10].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[10].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[10]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[10].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[10].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[11].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[11]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[11].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[11].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[11]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[11].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[11].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[12].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[12]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[12].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[12].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[12]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[12].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[12].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[13].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[13]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[13].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[13].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[13]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[13].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[13].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[14].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[14]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[14].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[14].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[14]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[14].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[14].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[15].getTag()){
                if((btn[1]%2)==0){
                    if((btn[1]+1)==btn[15]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[15].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[15].setTag(false);
                    }

                }else{
                    if((btn[1]-1)==btn[15]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[1].setTag(false);ButtonG[15].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[1].setTag(false);ButtonG[15].setTag(false);
                    }
                }

            }
            endGame();
        }
    });
    ButtonG[2].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                    &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                    &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                ButtonG[2].setTag(true);
            }else if((Boolean)ButtonG[1].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[1]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[1].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[1].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[1]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[1].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[1].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[0].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[0]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[0].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[0].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[0]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[0].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[0].setTag(false);
                    }
                }
            }
            else if((Boolean)ButtonG[3].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[3]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[3].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[3].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[3]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[3].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[3].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[4].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[4]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[4].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[4].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[4]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[4].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[4].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[5].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[5]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[5].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[5].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[5]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[5].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[5].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[6].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[6]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[6].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[6].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[6]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[6].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[6].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[7].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[7]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[7].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[7].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[7]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[7].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[7].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[8].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[8]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[8].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[8].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[8]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[8].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[8].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[9].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[9]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[9].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[9].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[9]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[9].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[9].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[10].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[10]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[10].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[10].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[10]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[10].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[10].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[11].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[11]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[11].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[11].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[11]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[11].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[11].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[12].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[12]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[12].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[12].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[12]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[12].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[12].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[13].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[13]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[13].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[13].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[13]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[13].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[13].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[14].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[14]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[14].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[14].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[14]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[14].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[14].setTag(false);
                    }
                }
            }else if((Boolean)ButtonG[15].getTag()){
                if((btn[2]%2)==0){
                    if((btn[2]+1)==btn[15]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[15].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[15].setTag(false);
                    }

                }else{
                    if((btn[2]-1)==btn[15]){
                        Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[2].setTag(false);ButtonG[15].setTag(false);
                    }else{
                        Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[2].setTag(false);ButtonG[15].setTag(false);
                    }
                }
            }
            endGame();
        }
    });

        ButtonG[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[3].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[2].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[3]%2)==0){
                        if((btn[3]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[3]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[3].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[3].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });

        ButtonG[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[4].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[4]%2)==0){
                        if((btn[4]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[4]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[4].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[4].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });

        ButtonG[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[5].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[5]%2)==0){
                        if((btn[5]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[5]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[5].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[5].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });
        ButtonG[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[6].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[6]%2)==0){
                        if((btn[6]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[6]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[6].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[6].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });
        ButtonG[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[7].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[7]%2)==0){
                        if((btn[7]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[7]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[7].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[7].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });


        ButtonG[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[8].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[11].setTag(false);
                        }
                    }else{
                        if((btn[8]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);;ButtonG[8].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[8]%2)==0){
                        if((btn[8]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[8]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[8].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[8].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });
        ButtonG[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[9].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[9]%2)==0){
                        if((btn[9]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[9]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[9].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[9].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });

        ButtonG[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[10].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[10]%2)==0){
                        if((btn[10]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[10]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[10].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[10].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });
        ButtonG[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[11].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[11]%2)==0){
                        if((btn[11]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[11]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[11].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[11].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });

        ButtonG[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)){
                    ButtonG[12].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[12]%2)==0){
                        if((btn[12]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[12]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[12].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[12].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });

        ButtonG[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[13].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[13]%2)==0){
                        if((btn[13]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[13]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[13].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[13].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });

        ButtonG[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)&&(ButtonG[15].getTag()==buttonRecognition)) {
                    ButtonG[14].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[2].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[15].getTag()){
                    if((btn[14]%2)==0){
                        if((btn[14]+1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[15].setTag(false);
                        }

                    }else{
                        if((btn[14]-1)==btn[15]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[14].setTag(false);ButtonG[15].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[14].setTag(false);ButtonG[15].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });

        ButtonG[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ButtonG[1].getTag())==buttonRecognition&&(ButtonG[2].getTag()==buttonRecognition)&&(ButtonG[3].getTag()==buttonRecognition)&&(ButtonG[4].getTag()==buttonRecognition)&&(ButtonG[5].getTag()==buttonRecognition)
                        &&(ButtonG[6].getTag()==buttonRecognition)&&(ButtonG[7].getTag()==buttonRecognition)&&(ButtonG[8].getTag()==buttonRecognition)&&(ButtonG[9].getTag()==buttonRecognition)&&(ButtonG[10].getTag()==buttonRecognition)
                        &&(ButtonG[11].getTag()==buttonRecognition)&&(ButtonG[12].getTag()==buttonRecognition)&&(ButtonG[13].getTag()==buttonRecognition)&&(ButtonG[14].getTag()==buttonRecognition)&&(ButtonG[0].getTag()==buttonRecognition)) {
                    ButtonG[15].setTag(true);
                }else if((Boolean)ButtonG[1].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[1].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[1]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[1].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[1].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[1].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[0].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[0].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[0]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[0].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[0].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[0].setTag(false);
                        }
                    }
                }
                else if((Boolean)ButtonG[3].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[3].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[3]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[3].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[3].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[3].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[4].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[4].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[4]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[4].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[4].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[4].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[5].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[5].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[5]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[5].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[5].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[5].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[6].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[6].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[6]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[6].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[6].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[6].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[7].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[7].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[7]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[7].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[7].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[7].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[8].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[8].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[8]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[8].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[8].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[8].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[9].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[9].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[9]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[9].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[9].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[9].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[10].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[10].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[10]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[10].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[10].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[10].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[11].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[11].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[11]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[11].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[11].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[11].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[12].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[12].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[12]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[12].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[12].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[12].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[13].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[13].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[13]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[13].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[13].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[13].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[14].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[14].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[14]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[14].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[14].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[14].setTag(false);
                        }
                    }
                }else if((Boolean)ButtonG[2].getTag()){
                    if((btn[15]%2)==0){
                        if((btn[15]+1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);ButtonG[2].setTag(false);
                        }

                    }else{
                        if((btn[15]-1)==btn[2]){
                            Toast.makeText(Tab4Activity.this, "정답", Toast.LENGTH_SHORT).show();
                            scoreHandler();ButtonG[15].setVisibility(View.INVISIBLE);ButtonG[2].setVisibility(View.INVISIBLE);ButtonG[15].setTag(false);ButtonG[2].setTag(false);
                        }else{
                            Toast.makeText(Tab4Activity.this, "오답", Toast.LENGTH_SHORT).show();ButtonG[15].setTag(false);
                            ButtonG[2].setTag(false);
                        }
                    }
                }
                endGame();
            }
        });



    }




    public void readTextInit(List<Integer> list){
        double rand = Math.random();
        int num = 1+(int)((rand*5));
        if(num==1) {
            try {
                file=1;
                Resources resources = getResources();
                BufferedReader br = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.game1), "EUC-KR"));
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    arr.add(readLine + "\n");
                }
                br.close();
                for (int i = 0; i < 16; i++) {
                    ButtonG[i].setText(arr.get(list.get(i)));
                }


                // button1.setText(arr.get(2));
            } catch (Exception e) {

            }
        }
        else if(num==2){
            try {
                file=2;
                Resources resources = getResources();
                BufferedReader br = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.game2), "EUC-KR"));
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    arr.add(readLine + "\n");
                }
                br.close();
                for (int i = 0; i < 16; i++) {
                    ButtonG[i].setText(arr.get(list.get(i)));
                }


                // button1.setText(arr.get(2));
            } catch (Exception e) {

            }
        }
        else if(num==3){
            try {
                file=3;
                Resources resources = getResources();
                BufferedReader br = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.game3), "EUC-KR"));
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    arr.add(readLine + "\n");
                }
                br.close();
                for (int i = 0; i < 16; i++) {
                    ButtonG[i].setText(arr.get(list.get(i)));
                }


                // button1.setText(arr.get(2));
            } catch (Exception e) {

            }
        }
        else if(num==4){
            try {
                file=4;
                Resources resources = getResources();
                BufferedReader br = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.game4), "EUC-KR"));
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    arr.add(readLine + "\n");
                }
                br.close();
                for (int i = 0; i < 16; i++) {
                    ButtonG[i].setText(arr.get(list.get(i)));
                }


                // button1.setText(arr.get(2));
            } catch (Exception e) {

            }
        }
        else if(num==5){
            try {
                file=5;
                Resources resources = getResources();
                BufferedReader br = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.game5), "EUC-KR"));
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    arr.add(readLine + "\n");
                }
                br.close();
                for (int i = 0; i < 16; i++) {
                    ButtonG[i].setText(arr.get(list.get(i)));
                }


                // button1.setText(arr.get(2));
            } catch (Exception e) {

            }
        }
    }

    public List<Integer> randNum(List<Integer> randList){
        for(int i=0; i<16; i++){
            list.add(i);
        }
        Collections.shuffle(randList);

        return randList;
    }

    public ArrayList<String> findText(){
        if(file==1) {
            try {
                Resources resources = getResources();
                BufferedReader br = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.game1), "EUC-KR"));
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    compareArr.add(readLine + "\n");
                }
                br.close();


                // button1.setText(arr.get(2));
            } catch (Exception e) {

            }
            return compareArr;
        }
        else if(file==2){
            try {
                Resources resources = getResources();
                BufferedReader br = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.game2), "EUC-KR"));
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    compareArr.add(readLine + "\n");
                }
                br.close();


                // button1.setText(arr.get(2));
            } catch (Exception e) {

            }
            return compareArr;
        }
        else if(file==3){
            try {
                Resources resources = getResources();
                BufferedReader br = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.game3), "EUC-KR"));
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    compareArr.add(readLine + "\n");
                }
                br.close();


                // button1.setText(arr.get(2));
            } catch (Exception e) {

            }
            return compareArr;
        }
        else if(file==4){
            try {
                Resources resources = getResources();
                BufferedReader br = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.game4), "EUC-KR"));
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    compareArr.add(readLine + "\n");
                }
                br.close();


                // button1.setText(arr.get(2));
            } catch (Exception e) {

            }
            return compareArr;
        }
        else{
            try {
                Resources resources = getResources();
                BufferedReader br = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.game5), "EUC-KR"));
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    compareArr.add(readLine + "\n");
                }
                br.close();


                // button1.setText(arr.get(2));
            } catch (Exception e) {

            }
            return compareArr;
        }
    }

    public void scoreHandler(){
        score+=50;
        mScoreTextView.setText("Score " + score);
    }

    private void endGame(){
      if(score==400)

        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("학습을 완료했습니다.");
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
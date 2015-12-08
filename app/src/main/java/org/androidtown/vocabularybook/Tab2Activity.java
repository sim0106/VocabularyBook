package org.androidtown.vocabularybook;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by studio on 2015-11-22.
 */
public class Tab2Activity extends Activity {


    private MyView vw;
    ArrayList<Vertex> arrayVertex;
    Button btn1,btn2,btn3,btn4;
    LinearLayout linear1,linear2;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        linear1 = new LinearLayout(this);
        linear1.setOrientation(LinearLayout.VERTICAL);

        linear2 = new LinearLayout(this);
        linear2.setOrientation(LinearLayout.HORIZONTAL);
        linear1.addView(linear2);
        vw= new MyView(this);
        linear1.addView(vw);
        linear1.setBackgroundColor(Color.WHITE);

        setContentView(linear1);
        arrayVertex = new ArrayList<Vertex>();
    }


    public class Vertex{//점 하나에 대한 정보가진 클래스
        float x,y;
        boolean Draw;
        int color;

        Vertex(float ax, float ay, boolean ad, int color){
            x=ax;
            y=ay;
            Draw = ad;
            this.color = color;
        }
    }

    protected class MyView extends View implements View.OnClickListener{
        Paint mPaint;
        boolean clear;
        int co;
        public MyView(Context context){
            super(context);

            mPaint = new Paint();
            mPaint.setStrokeWidth(3);
            mPaint.setAntiAlias(true);

            clear = false;
            co= Color.BLACK;

            LinearLayout.LayoutParams paramtext= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            btn1 = new Button(context);
            btn1.setBackgroundResource(R.drawable.eraser);
            linear2.addView(btn1, paramtext);
            btn1.setOnClickListener(this);

            btn2 = new Button(context);
            btn2.setBackgroundResource(R.drawable.pencilblack);
            linear2.addView(btn2, paramtext);
            btn2.setOnClickListener(this);

            btn3 = new Button(context);
            btn3.setBackgroundResource(R.drawable.pencilred);
            linear2.addView(btn3, paramtext);
            btn3.setOnClickListener(this);

            btn4 = new Button(context);
            btn4.setBackgroundResource(R.drawable.pencilblue);
            linear2.addView(btn4, paramtext);
            btn4.setOnClickListener(this);

        }

        public void onDraw(Canvas canvas){
            canvas.drawARGB(225, 251, 234, 142);
            mPaint.setColor(Color.LTGRAY);
            int j=80;
            while(j< getHeight()) {
                canvas.drawLine(0, j, canvas.getWidth(), j, mPaint);
                j+=40;
            }
            mPaint.setARGB(250, 229, 87, 59);
            canvas.drawLine((canvas.getWidth() / 8) - 5, 45, (canvas.getWidth() / 8) - 5, canvas.getHeight(), mPaint);
            canvas.drawLine((canvas.getWidth() / 8), 45, (canvas.getWidth() / 8), canvas.getHeight(), mPaint);
            mPaint.setARGB(250, 11, 20, 101);
            canvas.drawRect(0, 0, canvas.getWidth(), 45, mPaint);
            mPaint.setColor(Color.LTGRAY);
            mPaint.setTypeface(Typeface.createFromAsset(getAssets(), "Surfing Capital.ttf"));
            canvas.drawText("Vocabulary Book",canvas.getWidth()-120,15,mPaint);

            for(int i=0; i<arrayVertex.size();i++){
                if(arrayVertex.get(i).Draw){
                    mPaint.setColor(arrayVertex.get(i).color);

                    canvas.drawLine(arrayVertex.get(i-1).x, arrayVertex.get(i-1).y, arrayVertex.get(i).x, arrayVertex.get(i).y, mPaint);
                }
            }
        }

        public boolean onTouchEvent(MotionEvent event){
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                arrayVertex.add(new Vertex(event.getX(),event.getY(),false,co));
                return true;
            }
            if(event.getAction()==MotionEvent.ACTION_MOVE){
                arrayVertex.add(new Vertex(event.getX(), event.getY(), true, co));
                invalidate();
                return true;

            }return false;
        }

        @Override
        public void onClick(View v){
            if(v==btn1){
                arrayVertex.clear();
                invalidate();
            }else if (v == btn2) {
                co=Color.BLACK;
            }else if (v == btn3) {
                co=Color.RED;
            }else if (v == btn4) {
                co=Color.BLUE;
            }
        }
    }

}




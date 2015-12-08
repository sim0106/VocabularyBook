package org.androidtown.vocabularybook;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class TabWidgetActivity extends TabActivity implements TabHost.OnTabChangeListener{
    TabHost tabHost;
    Resources res;
    TabHost.TabSpec spec;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Parse.initialize(this, "zM54uKzksfuRmkODVZV8sqmidQIfnJDXdjNbb9ML", "iAhEINfLL3tPFDN6kCrBaxBmuMAdNVhQyR1Vy7tT");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, IntroActivity.class));
        res = getResources();
        tabHost = getTabHost();


        intent = new Intent().setClass(this, Tab1Activity.class);
        spec = tabHost.newTabSpec("tab1")
                .setIndicator(new MyTabView(this,1))
                .setContent(intent);

        tabHost.addTab(spec);

        intent = new Intent().setClass(this, Tab2Activity.class);
        spec = tabHost.newTabSpec("tab2")
                .setIndicator(new MyTabView(this,2))
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, Tab3Activity.class);
        spec = tabHost.newTabSpec("tab3")
                .setIndicator(new MyTabView(this,3))
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, Tab4Activity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        spec = tabHost.newTabSpec("tab4")
                .setIndicator(new MyTabView(this,4))
                .setContent(intent);
        tabHost.addTab(spec);



        for(int tab=0; tab<tabHost.getTabWidget().getChildCount(); ++tab){//탭높이 조절
            tabHost.getTabWidget().getChildAt(tab).getLayoutParams().height = 100;
        }
        tabHost.setCurrentTab(0); //초기 선택 탭 설정


    }
    @Override
    public void onTabChanged(String tabld){
        if(tabld == "tab1" ){
            tabHost.getTabWidget().setBackgroundResource(R.drawable.wordbook);
        }else if(tabld=="tab2"){
            tabHost.getTabWidget().setBackgroundResource(R.drawable.notebook);
        }else if(tabld=="tab3"){
            tabHost.getTabWidget().setBackgroundResource(R.drawable.dic);
        }else if(tabld=="tab4"){
            tabHost.getTabWidget().setBackgroundResource(R.drawable.game);
        }

    }
    private class MyTabView extends LinearLayout{
        public MyTabView(Context c,int drawble){
            super(c);
            ImageView iv = new ImageView(c);
            if(drawble==1) {
                iv.setBackgroundResource(R.drawable.wordbook);
            }else if(drawble==2){
                iv.setBackgroundResource(R.drawable.notebook);
            }else if(drawble==3){
                iv.setBackgroundResource(R.drawable.dic);
            }else if(drawble==4){
                iv.setBackgroundResource(R.drawable.game);
            }

            setOrientation(LinearLayout.VERTICAL);
            addView(iv);

        }
    }

}



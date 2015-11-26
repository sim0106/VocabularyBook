package org.androidtown.vocabularybook;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class TabWidgetActivity extends TabActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Parse.initialize(this, "zM54uKzksfuRmkODVZV8sqmidQIfnJDXdjNbb9ML", "iAhEINfLL3tPFDN6kCrBaxBmuMAdNVhQyR1Vy7tT");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();  //리소스 객체 생성
        TabHost tabHost = getTabHost();  //TabHost 객체 생성
        TabHost.TabSpec spec;    //TabHost.TabSpec 선언
        Intent intent;      //Intent 선언

        intent = new Intent(this, Tab1Activity.class);
        spec = tabHost.newTabSpec("tab1")
                .setIndicator("단어장", res.getDrawable(android.R.drawable.sym_action_chat))
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent(this, Tab2Activity.class);
        spec = tabHost.newTabSpec("tab2")
                .setIndicator("사전", res.getDrawable(android.R.drawable.sym_action_email))
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent(this, Tab3Activity.class);
        spec = tabHost.newTabSpec("tab3")
                .setIndicator("게임", res.getDrawable(android.R.drawable.sym_action_call))
                .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0); //초기 선택 탭 설정
    }


}



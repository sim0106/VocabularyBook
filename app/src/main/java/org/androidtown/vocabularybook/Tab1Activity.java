package org.androidtown.vocabularybook;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by studio on 2015-11-22.
 */
public class Tab1Activity extends Activity {
    PlusButtonActivity plusButtonDialog;
    SendMailActivity sendMailDialog;

    ImageButton showDialog;
    ImageButton deleteWord;
    ImageButton hideMeaning;
    ImageButton showMeaning;
    Button sendEmail;

    private DBAdapter mDb;
    private ArrayList<Info> mInfo;
    private ArrayAdapter<Info> mAdapter;

    ListView listView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1_layout);



        listView=(ListView)findViewById(R.id.listView);

        mDb= new DBAdapter(this);
        mInfo = mDb.getAllInfo();
        mAdapter = new ArrayAdapter<Info>(this, R.layout.simplelist,mInfo);
        listView.setAdapter(mAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        showDialog=(ImageButton)findViewById(R.id.showDialog);
        deleteWord=(ImageButton)findViewById(R.id.deleteWord);
        hideMeaning=(ImageButton)findViewById(R.id.hideMeaning);
        showMeaning=(ImageButton)findViewById(R.id.showMeaning);
        sendEmail=(Button)findViewById(R.id.sendEmail);

        sendMailDialog = new SendMailActivity(Tab1Activity.this);
        sendMailDialog.setTitle("메일 전송");

        sendMailDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (sendMailDialog.getMailTitle().toString().isEmpty() || sendMailDialog.getMail().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "빈 항목을 추가해 주십시오 ", Toast.LENGTH_SHORT).show();
                } else {
                    Intent it = new Intent(Intent.ACTION_SEND);
                    it.setType("plain/text");

                    String[] mail = {sendMailDialog.getMail().toString()};
                    it.putExtra(Intent.EXTRA_EMAIL, mail);

                    it.putExtra(Intent.EXTRA_SUBJECT, sendMailDialog.getMailTitle().toString());
                    it.putExtra(Intent.EXTRA_TEXT, mDb.getAllInfo().toString());

                    startActivity(it);
                }
            }
        });

        sendMailDialog.setOnCancelListener(new DialogInterface.OnCancelListener(){
            @Override
            public void onCancel(DialogInterface dialog){

            }
        });
        //다이얼로그 객체 생성
        plusButtonDialog = new PlusButtonActivity(Tab1Activity.this);
        plusButtonDialog.setTitle("단어추가");

        plusButtonDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (plusButtonDialog.getWordMean().toString().isEmpty() || plusButtonDialog.getWordName().isEmpty()) {
                    Log.v("tag", "실행");
                    Toast.makeText(getApplicationContext(), "단어가 추가 될 수 없습니다. ", Toast.LENGTH_SHORT).show();
                    refreshList();
                } else {

                    mDb.insertInfo(plusButtonDialog.getWordName().toString(), plusButtonDialog.getWordMean().toString());
                    Log.v("tag", "실행");
                    Toast.makeText(getApplicationContext(), "단어를 추가했습니다. ", Toast.LENGTH_SHORT).show();
                    refreshList();

                }
            }
        });



        plusButtonDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(getApplicationContext(), "단어를 추가하지 않았습니다. ", Toast.LENGTH_SHORT).show();

                refreshList();
            }
        });

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusButtonDialog.show();
            }
        });

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMailDialog.show();
            }
        });

        deleteWord.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int pos = listView.getCheckedItemPosition();
                if(pos != ListView.INVALID_POSITION){
                    Info i = mInfo.get(pos);
                    //mInfo.remove(pos);

                    mDb.deleteInfo(i.getId());
                    //mDb.deleteInfo(pos);
                    refreshList();
                    listView.clearChoices();
                    mAdapter.notifyDataSetChanged();


                }

            }
        });

        hideMeaning.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mInfo.clear();
                mInfo.addAll(mDb.getWord());
                mAdapter.notifyDataSetChanged();
                }
        });

        showMeaning.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mInfo.clear();
                mInfo.addAll(mDb.getAllInfo());
                mAdapter.notifyDataSetChanged();
            }
        });



    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0, 1, 0, "All delete!");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        mDb.deleteAll();
        refreshList();
        return super.onOptionsItemSelected(item);
    }

    protected void onDestroy(){
        mDb.close();
        super.onDestroy();
    }

    private void refreshList() {
        mInfo.clear();
        mInfo.addAll(mDb.getAllInfo());
        mAdapter.notifyDataSetInvalidated();

    }




}




package org.androidtown.vocabularybook;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by studio on 2015-11-22.
 */
public class Tab1Activity extends Activity {
    PlusButtonActivity plusButtonDialog;
    Button showDialog;
    Button deleteWord;
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
        mAdapter = new ArrayAdapter<Info>(this, android.R.layout.simple_list_item_single_choice,mInfo);
        listView.setAdapter(mAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        showDialog=(Button)findViewById(R.id.showDialog);
        deleteWord=(Button)findViewById(R.id.deleteWord);
        //다이얼로그 객체 생성
        plusButtonDialog = new PlusButtonActivity(Tab1Activity.this);
        plusButtonDialog.setTitle("단어추가");

        plusButtonDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mDb.insertInfo(plusButtonDialog.getWordName().toString(), plusButtonDialog.getWordMean().toString());
                Log.v("tag", "실행");
                Toast.makeText(getApplicationContext(), "단어를 추가했습니다. ", Toast.LENGTH_SHORT).show();
                refreshList();
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

        deleteWord.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int pos = listView.getCheckedItemPosition();
                if(pos != ListView.INVALID_POSITION){
                    mInfo.remove(pos);
                    listView.clearChoices();
                    mAdapter.notifyDataSetChanged();
                }
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




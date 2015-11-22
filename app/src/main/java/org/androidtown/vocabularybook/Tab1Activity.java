package org.androidtown.vocabularybook;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        mAdapter = new ArrayAdapter<Info>(this, android.R.layout.simple_list_item_1,mInfo);
        listView.setAdapter(mAdapter);

        showDialog=(Button)findViewById(R.id.showDialog);
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

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Info i = mInfo.get(position);
                Toast.makeText(Tab1Activity.this, "delete " + i.getWord(), Toast.LENGTH_SHORT).show();
                mDb.deleteInfo(i.getId());
                refreshList();
                return false;
            }
        });

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusButtonDialog.show();
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




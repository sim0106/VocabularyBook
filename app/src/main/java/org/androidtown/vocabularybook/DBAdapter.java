package org.androidtown.vocabularybook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by studio on 2015-11-22.
 */
public class DBAdapter extends SQLiteOpenHelper {
    private static final String DB_NAME = "wordbook1.db";
    private static final int VERSION = 1;
    private static final String ID = "_id";
    private static final String WORD = "word";
    private static final String MEANING = "meaning";

    private static final String TABLE_NAME = "wordbook";
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    ID + " integer primary key autoincrement, " +
                    WORD + " text not null, " +
                    MEANING + " text not null )";

    private SQLiteDatabase db;

    public DBAdapter(Context context) {
        super(context, DB_NAME, null, VERSION);
        db = this.getWritableDatabase();
    }

    @Override
    public synchronized void close() {
        db.close();
        super.close();
    }

    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // create
    public boolean insertInfo(String word, String meaning) {
        ContentValues cv = new ContentValues();
        cv.put(WORD, word);
        cv.put(MEANING, meaning);
        return db.insert(TABLE_NAME, null, cv) != -1;
    }

    // read
    public ArrayList<Info> getAllInfo() {
        ArrayList<Info> info = new ArrayList<Info>();
        Cursor c = db.query(TABLE_NAME, new String[] {ID, WORD, MEANING}, null, null, null, null, ID + " DESC");

        if (c.moveToFirst()) {
            final int indexId = c.getColumnIndex(ID);
            final int indexMeeting = c.getColumnIndex(WORD);
            final int indexTime = c.getColumnIndex(MEANING);

            do {
                int id = c.getInt(indexId);
                String meeting = c.getString(indexMeeting);
                String time = c.getString(indexTime);
                info.add(new Info(id, meeting, time));
            } while (c.moveToNext());
        }
        c.close();

        return info;
    }

    // update
    public boolean updateInfo(Info i) {
        ContentValues cv = new ContentValues();
        cv.put(WORD, i.getWord());
        cv.put(MEANING, i.getMeaning());
        String[] params = new String[] { Integer.toString(i.getId()) };
        int result = db.update(TABLE_NAME, cv, ID + "=?", params);
        return result > 0;
    }

    // delete
    public boolean deleteInfo(int id) {
        String[] params = new String[] { Integer.toString(id) };
        int result = db.delete(TABLE_NAME, ID + "=?", params);
        return result > 0;
    }

    public boolean deleteAll() {
        int result=db.delete(TABLE_NAME, null, null);
        return result > 0;
    }
}

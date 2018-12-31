package com.example.a9011_20.aba_ep1_trial.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.a9011_20.aba_ep1_trial.Word;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(@Nullable Context context) {
        super(context, "testDB", null, 1);
    }

    String[] data = new String[]{"김밥","초밥","뻐꾸기","기린","감자탕","글씨","마마무","침팬치","챔피언","그림동화","모래성","알라딘","코리아","한국","음악","기타","바이올린","첼로","우크라이나","스리랑카"};

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createClientTable = "create table if not exists client(id text primary key, name text, age text, score text)";
        String createWordsTable = "create table if not exists words(word text primary key, image text, enable boolean)";

        db.execSQL(createClientTable);
        db.execSQL(createWordsTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addData(){
        SQLiteDatabase db = getWritableDatabase();



        for(int i=0;i<data.length;i++) {

            String word = data[i];

            try {
                db.execSQL("insert into words values('"+word+"','000','0')");
            } catch (SQLiteConstraintException e) {

            }
        }
    }


    public ArrayList<Word> readData(){
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Word> wordList = new ArrayList<>();


        Cursor cursor = db.rawQuery("select * from words",null);

        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            do {
                String data = cursor.getString(cursor.getColumnIndex("word"));
                String imageUrl = cursor.getString(cursor.getColumnIndex("image"));

                wordList.add(new Word(data,imageUrl));

            } while (cursor.moveToNext());

            return wordList;

        }else{
            return null;
        }
    }

}

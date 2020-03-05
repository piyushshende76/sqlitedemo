package com.example.piyushstark.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper{
    
    private static final String databasename="info.db";
    private static final int databaseVersion=1;
    private static final String tablename="info_table";

    public DatabaseHelper(Context context) {
        super(context, databasename, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+tablename+"(name TEXT,city TEXT,number NUMBER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query="DROP TABLE IF EXISTS "+tablename;
        db.execSQL(query);
        onCreate(db);
    }


    public void saveData(String name,String city,int number){
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("city",city);
        contentValues.put("number",number);

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.insert(tablename,null,contentValues);

    }

    public StringBuffer getData(){

        String query="SELECT * FROM "+tablename;

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);

        StringBuffer stringBuffer=new StringBuffer();

        if(cursor !=null)
        {
            cursor.moveToFirst();
            do {

                String name=cursor.getString(cursor.getColumnIndex("name"));
                stringBuffer.append("Name: "+name+ "\n");

                String city=cursor.getString(cursor.getColumnIndex("city"));
                stringBuffer.append("City: "+city+ "\n");

                String number=cursor.getString(cursor.getColumnIndex("number"));
                stringBuffer.append("Number: " + number + "\n");
                stringBuffer.append("___________________\n");
            }while (cursor.moveToNext());

            cursor.close();
        }
        return stringBuffer;
    }



}

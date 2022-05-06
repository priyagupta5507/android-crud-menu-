package com.exam.employeetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class employeedb extends SQLiteOpenHelper {
    public employeedb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "employee", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table emp (eid integer primary key autoincrement,ename text, designation text, phoneno integer, email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists emp");
        onCreate(sqLiteDatabase);
    }

    public void addData(String name,String designation, int phoneno, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ename",name);
        cv.put("designation",designation);
        cv.put("phoneno",phoneno);
        cv.put("email",email);
        db.insert("emp",null,cv);
        db.close();
    }

    public List<String> displaynames(){
        List<String> namelist = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select ename from emp",null);
        while(result.moveToNext()){
            namelist.add(result.getString(0));
        }
        return namelist;
    }

    public Cursor findbyname(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from emp where ename=?",new String[]{name});
        return result;

    }
}

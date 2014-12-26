package com.example.uchetsotrudnikov.activities;

import com.example.uchetsotrudnikov.R;
import com.example.uchetsotrudnikov.databases.DatabaseHelper2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

public class EditEmployee extends FragmentActivity{
	DatabaseHelper2 dbHelper;
	SQLiteDatabase sdb;
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.temporary);
	        
	        dbHelper = new DatabaseHelper2(this, "mydatabase.db", null, 1);
	       
	         sdb = dbHelper.getReadableDatabase();
	         //sdb.delete(dbHelper.getDatabaseName(), null, null);
	         ContentValues newValues = new ContentValues();//занесение во временное хранилище

	         
	         newValues.put(dbHelper.NAME_COLUMN, "Леонид Якубович Порошенко");
	         newValues.put(dbHelper.INFO_COLUMN, "Родился в Украине в 1949 г.");
	         newValues.put(dbHelper.PHOTO_COLUMN, "Путь к фотографии2");
	         sdb.insert("users", null, newValues);
	         //newValues.remove(key)
	         
	         
	        }
	 //метод только для чтения 
	 public void onClickOk(View v){
		 
		 Cursor cursor = sdb.query("users", new String []{dbHelper.NAME_COLUMN, 
				 dbHelper.INFO_COLUMN, dbHelper.PHOTO_COLUMN}, 
				 null, null, null, null, null);
		 cursor.moveToFirst();
		 
		
		 String name = cursor.getString(cursor.getColumnIndex(dbHelper.NAME_COLUMN));
		 String info = cursor.getString(cursor.getColumnIndex(dbHelper.INFO_COLUMN));
		 //String photo = cursor.getString(cursor.getColumnIndex(dbHelper.PHOTO_COLUMN));
		 
		 cursor.moveToNext();
		 String name3 = cursor.getString(cursor.getColumnIndex(dbHelper.NAME_COLUMN));
		 String info3 = cursor.getString(cursor.getColumnIndex(dbHelper.INFO_COLUMN));
		 
		 cursor.moveToLast();
		 String name2 = cursor.getString(cursor.getColumnIndex(dbHelper.NAME_COLUMN));
		 String info2 = cursor.getString(cursor.getColumnIndex(dbHelper.INFO_COLUMN));
		 //String photo2 = cursor.getString(cursor.getColumnIndex(dbHelper.PHOTO_COLUMN));
		 
		 EditText edTxt = (EditText)findViewById(R.id.app_edit_info);
		 edTxt.setText(name + " " + info + "\n " 
		 + name2 + " " + info2 + "\n " 
		 + name3 + " " + info3);
		 //edTxt.setText(name2 + " " + info2 + "\n ");
		 
		 
		 
		 
	 }
	 
	 public void onclickAdd(View v){
		 
	 }
	 
	 public void onClickDelete(View v){
		 
		 sdb.execSQL("DROP TABLE IF EXISTS users");
	 }

}

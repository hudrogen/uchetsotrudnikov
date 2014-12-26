package com.example.uchetsotrudnikov.databases;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DatabaseHelper2 extends SQLiteOpenHelper implements BaseColumns{
	private static final String DATABASE_NAME = "mydatabase.db";
	private static final String DATABASE_TABLE = "users";
	
	public static final String NAME_COLUMN = "name";
	public static final String INFO_COLUMN = "info";
	public static final String PHOTO_COLUMN = "photo";
	
	private static final String DATABASE_CREATE_SCRIPT = "create table "
			+ DATABASE_TABLE + " (" + BaseColumns._ID
			+ " integer primary key autoincrement, " + NAME_COLUMN
			+ " text not null, " + INFO_COLUMN + " text not null, " + PHOTO_COLUMN
			+ " text not null);";
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE_SCRIPT);

	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// ������� � ������
		Log.w("SQLite", "����������� � ������ " + oldVersion + " �� ������ " + newVersion);
		
		// ������� ������ ������� � ������ �����
		db.execSQL("DROP TABLE IF IT EXIST " + DATABASE_TABLE);
		// ������ ����� �������
		onCreate(db);

	}
	
	//�����������
	public DatabaseHelper2(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		// TODO Auto-generated constructor stub
	}
	//�����������
	public DatabaseHelper2(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
}

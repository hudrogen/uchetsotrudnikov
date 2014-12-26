package com.example.uchetsotrudnikov.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EmployeersDataBase extends SQLiteOpenHelper{
	
	private static final String DATABASE_NAME = "employeers_app.db";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_TABLE = "table1";
	
	// поля таблицы
	public static final String COLUMN_ID = "_id";
	//public static final String COLUMN_CATEGORY = "category";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_INFO = "info";
	
	//выносим запрос на создание базы данных в строку
	private static final String DATABASE_CREATE = "create table "
			+ DATABASE_TABLE + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " 
			+ COLUMN_NAME + " text not null,"
			+ COLUMN_INFO + " text not null" + ");";
	
	public EmployeersDataBase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(EmployeersDataBase.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion
				+ ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS todos");
		onCreate(db);
	}
	
	/**
	 * Создаёт новый элемент - сотрудник. Если создан успешно - возвращается
	 * номер строки rowId, иначе -1
	 */
	public long createNewLine(String summary,
			String description) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues initialValues = createContentValues(summary, description);
		
		long row = db.insert(DATABASE_TABLE, null, initialValues);
		db.close();

		return row;
	}
	
	/**
	 * Обновляет список
	 */
	public boolean updateTodo(long rowId, String summary,
			String description) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues updateValues = createContentValues(summary,
				description);

		return db.update(DATABASE_TABLE, updateValues, COLUMN_ID + "=" + rowId,
				null) > 0;
	}
	
	/**
	 * Удаляет элемент списка
	 */
	public void deleteTodo(long rowId) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(DATABASE_TABLE, COLUMN_ID + "=" + rowId, null);
		db.close();
	}
	
	/**
	 * Возвращает курсор со всеми элементами списка дел
	 * 
	 * @return курсор с результатами всех записей
	 */
	public Cursor getAllTodos() {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.query(DATABASE_TABLE, new String[] { COLUMN_ID,
				COLUMN_NAME, COLUMN_INFO }, null,
				null, null, null, null);
	}
	
	/**
	 * Возвращает курсор с указанной записи
	 */
	public Cursor getTodo(long rowId) throws SQLException {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor mCursor = db.query(true, DATABASE_TABLE,
				new String[] { COLUMN_ID, COLUMN_NAME,
						COLUMN_INFO }, COLUMN_ID + "=" + rowId, null,
				null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	/*
	 * Создаёт пару ключ-значение и записывает в базу
	 */
	private ContentValues createContentValues(String summary,
			String description) {
		ContentValues values = new ContentValues();
		//values.put(COLUMN_CATEGORY, category);
		values.put(COLUMN_NAME, summary);
		values.put(COLUMN_INFO, description);
		return values;
	}

}

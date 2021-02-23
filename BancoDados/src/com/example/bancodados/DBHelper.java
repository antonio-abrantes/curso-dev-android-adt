package com.example.bancodados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	
	private static final String CREATE_SQL =
			"CREATE TABLE contato (_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, "
			+ "telefone INTEGER NOT NULL)";
	
	private static final String DELETE_SQL = "DROP TABLE contato";

	public DBHelper(Context context, String name, int version) {
		super(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DELETE_SQL);
		db.execSQL(CREATE_SQL);
	}

}

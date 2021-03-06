package com.example.shooter;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Fetch_DB extends SQLiteOpenHelper {
	// get data from table
	private static final String DB_NAME = "game.db";
	private static final int SCHEMA_VERSION = 1;// data base
	ArrayList<String> data=new ArrayList<String>();
	ArrayList<ArrayList> achieve=new ArrayList<ArrayList>();
	ArrayList<String> id=new ArrayList<String>();
	ArrayList<String> title=new ArrayList<String>();
	ArrayList<String> desc=new ArrayList<String>();
	ArrayList<String> finish=new ArrayList<String>();
	public Fetch_DB(Context context) {
		super(context, DB_NAME, null, SCHEMA_VERSION);
		}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	
	public ArrayList<String> get_row() {


		Cursor cursor;

		try {
			cursor = getReadableDatabase().rawQuery("SELECT * FROM `achievements`  WHERE finish= '0' order by id asc LIMIT 1", null);
			cursor.moveToFirst();
			if (!cursor.isAfterLast())
			{
				do {
					data.add(cursor.getString(0));
					data.add(cursor.getString(1));
					data.add(cursor.getString(2));
					data.add(cursor.getString(3));
					
				} while (cursor.moveToNext());
			}
			cursor.close();
			
		} catch (SQLException e){
			Log.e("Sbi_po_DB:get_single_row()", e.toString());
		}
		return data;
	}
	public ArrayList<String> get_row_by_id(String id) {


		Cursor cursor;

		try {
			cursor = getReadableDatabase().rawQuery("SELECT * FROM `achievements` WHERE id='"+id+"'", null);
			cursor.moveToFirst();
			if (!cursor.isAfterLast())
			{
				do {
					data.add(cursor.getString(0));
					data.add(cursor.getString(1));
					data.add(cursor.getString(2));
					data.add(cursor.getString(3));
					
				} while (cursor.moveToNext());
			}
			cursor.close();
			
		} catch (SQLException e){
			Log.e("Sbi_po_DB:get_single_row()", e.toString());
		}
		return data;
	}
	// ********************** GET SINGLE ROW ********************** //
	public void set_row(String id) {


		Cursor cursor;

		try {
			cursor = getReadableDatabase().rawQuery("UPDATE achievements SET finish='1' WHERE id='"+id+"'", null);
			cursor.moveToFirst();
			cursor.close();
		} catch (SQLException e){
			Log.e("Sbi_po_DB:get_single_row()", e.toString());
		}
	}
	public void set_row(int kill,int score) {


		Cursor cursor;

		try {
			cursor = getReadableDatabase().rawQuery("UPDATE achievements SET finish=finish+"+kill+" WHERE id='21'", null);
			cursor.moveToFirst();
			cursor = getReadableDatabase().rawQuery("UPDATE achievements SET finish=finish+"+score+" WHERE id='22'", null);
			cursor.moveToFirst();
			cursor.close();
		} catch (SQLException e){
			Log.e("Sbi_po_DB:get_single_row()", e.toString());
		}
	}
	public ArrayList<ArrayList> get_achievements() {


		Cursor cursor;

		try {
			cursor = getReadableDatabase().rawQuery("SELECT * FROM `achievements` order by id asc", null);
			cursor.moveToFirst();
			if (!cursor.isAfterLast())
			{
				do {
					id.add(cursor.getString(0));
					title.add(cursor.getString(1));
					desc.add(cursor.getString(2));
					finish.add(cursor.getString(4));
					
					
				} while (cursor.moveToNext());
			}
			cursor.close();
			achieve.add(id);
			achieve.add(title);
			achieve.add(desc);
			achieve.add(finish);
			
		} catch (SQLException e){
			Log.e("Sbi_po_DB:get_single_row()", e.toString());
		}
		return achieve;
	}
	
}

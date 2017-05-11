package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> alNotes;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView
		lv = (ListView)findViewById(R.id.lv);

		DBHelper db = new DBHelper(SecondActivity.this);
		alNotes = db.getAllNotes();

		aa = new RevisionNotesArrayAdapter(this, R.layout.row, alNotes);
		lv.setAdapter(aa);
		aa.notifyDataSetChanged();
		db.close();
	}


}

package com.udsfgecw.ktusyllabus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class Sem extends AppCompatActivity implements OnClickListener {

	static String sem = "";

	static String dir = "syllabus/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sem);
		Toolbar mytoolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(mytoolbar);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		dir = "syllabus/";
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Intent intent = new Intent(Sem.this, Branch.class);

		switch (v.getId()) {

		case R.id.firstyear:
			sem = "firstYear";
			startActivity(new Intent(Sem.this,Subject.class));

			break;

		case R.id.sem3:
			sem = "semester3";
			startActivity(intent);
			break;

		case R.id.sem4:
			sem = "semester4";
			startActivity(intent);
			break;
			
		case R.id.sem5:
			sem = "semester5";
			startActivity(intent);
			break;

		case R.id.sem6:
			sem = "semester6";
			startActivity(intent);
			break;
			
			
		case R.id.sem7:
			sem = "semester7";
			startActivity(intent);
			break;

		case R.id.sem8:
			sem = "semester8";
			startActivity(intent);
			break;
			
			
		case R.id.pq:
			//startactivity pdf
			dir="pqp/";
			sem="firstYear";
			startActivity(new Intent(Sem.this,Subject.class));
			
			break;

		}

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.main_menu, menu);

		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
			startActivity(new Intent(Sem.this,About.class));
			return true;

		}

		return false;

	}

	
}

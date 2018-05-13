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

public class Branch extends AppCompatActivity implements OnClickListener {

	static String br = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.branch);
		Toolbar mytoolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(mytoolbar);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Intent intent = new Intent(Branch.this, Subject.class);

		switch (v.getId()) {
		case R.id.cse:
			br = Sem.dir+"cse/";
			startActivity(intent);
			break;

		case R.id.ece:
			br = Sem.dir+"ece/";
			startActivity(intent);

			break;
		case R.id.eee:
			br = Sem.dir+"eee/";
			startActivity(intent);

			break;

		case R.id.me:
			br = Sem.dir+"mech/";
			startActivity(intent);

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
			startActivity(new Intent(Branch.this,About.class));
			return true;

		}

		return false;

	}

	
}

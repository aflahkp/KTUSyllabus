package com.udsfgecw.ktusyllabus;

import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Text extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);

		TextView syllabus = (TextView) findViewById(R.id.stext);
		
		
		String stext="";
		if(Sem.sem=="firstYear"){
			stext = Sem.dir+Sem.sem+"/"+Subject.sub;
		}
		else{
		stext = Branch.br+Sem.sem+"/"+Subject.sub;
		}
		
		Subject.sub="";

		AssetManager assetmanager = getAssets();
		InputStream input;
		String text = "not read";

		try {
			input = assetmanager.open(stext + ".txt");
			int size = input.available();
			byte[] buffer = new byte[size];
			input.read(buffer);
			
			input.close();
			text = new String(buffer);
			

		}

		catch (Exception e) {
			// TODO: handle exception;
			e.printStackTrace();

		}
		syllabus.setText(text);

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
			startActivity(new Intent(Text.this,About.class));
			return true;

		}

		return false;

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}

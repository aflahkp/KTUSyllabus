package com.udsfgecw.ktusyllabus;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Subject extends AppCompatActivity implements OnClickListener {

	static String sub = "";
	String[] subjectlist = { "sub1", "sub2", "sub3", "sub4", "", "",
			"", "sub8", "sub9","sub10","sub11", "sub12", "sub13", "sub14", "sub15",
			"sub16", "sub17", "sub18", "sub19", "sub20" };
	String line = "notSetProperly";
	
	
	
	String subjects = Branch.br + Sem.sem + ".txt";

	TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15,
			t16, t17, t18, t19, t20;
	

	// TextView t1,t2,t3,t4,t5,t6,t7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		if (Sem.sem.equals("firstYear")) {

			if(Sem.dir.equals("pqp/")){
				subjects = "pqp/pqp.txt";
				setContentView(R.layout.subq);
				
			}
			else{
			subjects = "syllabus/firstYear.txt";
			setContentView(R.layout.subf);
			}
			
			

		} else {
			setContentView(R.layout.sub);
		}
		
		Toolbar mytoolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(mytoolbar);

		t1 = (TextView) findViewById(R.id.sub1);
		t2 = (TextView) findViewById(R.id.sub2);
		t3 = (TextView) findViewById(R.id.sub3);
		t4 = (TextView) findViewById(R.id.sub4);
		t5 = (TextView) findViewById(R.id.sub5);
		t6 = (TextView) findViewById(R.id.sub6);
		t7 = (TextView) findViewById(R.id.sub7);

		if (Sem.sem.equals("firstYear")) {
			
			t8 = (TextView) findViewById(R.id.sub8);
			t9 = (TextView) findViewById(R.id.sub9);
			t10 = (TextView) findViewById(R.id.sub10);
			if(!Sem.dir.equals("pqp/")){
			t11= (TextView) findViewById(R.id.sub11);
			t12= (TextView) findViewById(R.id.sub12);
			t13 = (TextView) findViewById(R.id.sub13);
			t14 = (TextView) findViewById(R.id.sub14);
			t15 = (TextView) findViewById(R.id.sub15);
			t16 = (TextView) findViewById(R.id.sub16);
			t17= (TextView) findViewById(R.id.sub17);
			t18= (TextView) findViewById(R.id.sub18);
			t19= (TextView) findViewById(R.id.sub19);
			t20= (TextView) findViewById(R.id.sub20);
			}
		}
		
		ReadSub();

		SetTexts();
		

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent intent;
		
		if(Sem.dir.equals("pqp/")){
			intent=	new Intent(Subject.this, Pdf.class);
		}
		else{
	intent=	new Intent(Subject.this, Text.class);
		}
		switch (v.getId()) {

		case R.id.sub1:
			sub = "subject1";
			startActivity(intent);

			break;

		case R.id.sub2:
			sub = "subject2";
			startActivity(intent);

			break;

		case R.id.sub3:

			sub = "subject3";
			startActivity(intent);

			break;

		case R.id.sub4:

			sub = "subject4";
			startActivity(intent);

			break;

		case R.id.sub5:

			sub = "subject5";
			startActivity(intent);
			break;
			
			
			
		case R.id.sub6:
			sub = "subject6";
			startActivity(intent);

			break;

		case R.id.sub7:
			sub = "subject7";
			startActivity(intent);

			break;

		case R.id.sub8:

			sub = "subject8";
			startActivity(intent);

			break;

		case R.id.sub9:

			sub = "subject9";
			startActivity(intent);

			break;

		case R.id.sub10:

			sub = "subject10";
			startActivity(intent);
			break;

		case R.id.sub11:
			sub = "subject11";
			startActivity(intent);

			break;

		case R.id.sub12:
			sub = "subject12";
			startActivity(intent);

			break;

		case R.id.sub13:

			sub = "subject13";
			startActivity(intent);

			break;

		case R.id.sub14:

			sub = "subject14";
			startActivity(intent);

			break;

		case R.id.sub15:

			sub = "subject15";
			startActivity(intent);
			break;
			
			
			
		case R.id.sub16:
			sub = "subject16";
			startActivity(intent);

			break;

		case R.id.sub17:
			sub = "subject17";
			startActivity(intent);

			break;

		case R.id.sub18:

			sub = "subject18";
			startActivity(intent);

			break;

		case R.id.sub19:

			sub = "subject19";
			startActivity(intent);

			break;

		case R.id.sub20:

			sub = "subject20";
			startActivity(intent);

			break;
			
			
		}

	}

	public void SetTexts() {

		t1.setText(subjectlist[0]);
		t2.setText(subjectlist[1]);
		t3.setText(subjectlist[2]);
		t4.setText(subjectlist[3]);
		t5.setText(subjectlist[4]);
		t6.setText(subjectlist[5]);
		t7.setText(subjectlist[6]);
		
		if (Sem.sem.equals("firstYear")) {
			
			
			t8.setText(subjectlist[7]);
			t9.setText(subjectlist[8]);
			t10.setText(subjectlist[9]);
			
			if(!Sem.dir.equals("pqp/")){
				
			
			t11.setText(subjectlist[10]);
			t12.setText(subjectlist[11]);
			t13.setText(subjectlist[12]);
			t14.setText(subjectlist[13]);
			t15.setText(subjectlist[14]);
			t16.setText(subjectlist[15]);
			t17.setText(subjectlist[16]);
			t18.setText(subjectlist[17]);
			t19.setText(subjectlist[18]);
			t20.setText(subjectlist[19]);
			}
		}

	}

	public void ReadSub() {

		int count = 0;

		try {
			InputStream ips = getAssets().open(subjects);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					ips));
			// String line="NiL";

			do {
				line = buffer.readLine();
				subjectlist[count] = line;
				
				count++;

			} while (line != null);

		} catch (Exception e) {

			e.getMessage();
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
			startActivity(new Intent(Subject.this,About.class));
			return true;

		}

		return false;

	}

	
	
}

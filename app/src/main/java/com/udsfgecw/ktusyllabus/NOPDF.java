package com.udsfgecw.ktusyllabus;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NOPDF extends Activity implements OnClickListener{

	Button b;
	Uri adobe=Uri.parse("https://play.google.com/store/apps/details?id=com.adobe.reader&hl=en");
	Intent intent=new Intent(Intent.ACTION_VIEW,adobe);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nopdf);
		b=(Button) findViewById(R.id.getpdf);
		b.setOnClickListener(this);
		
	}

	
	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.getpdf){
		//goto adobe download
			startActivity(intent);
			
		}
		
	}
	

}

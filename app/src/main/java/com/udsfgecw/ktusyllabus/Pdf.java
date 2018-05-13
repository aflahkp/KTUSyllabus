package com.udsfgecw.ktusyllabus;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Pdf extends Activity {
	static File file;
	static boolean pdfflag=false;
	String filename;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		filename="pqp/"+Subject.sub;
		
		//Toast.makeText(getApplicationContext(), filename, Toast.LENGTH_LONG).show();
		copyReadAssets();
/*
		File file = new File("sdcard/s6.pdf");
		Uri path = Uri.fromFile(file);
		Intent intent = new Intent(Intent.ACTION_VIEW);
		Intent nopdf = new Intent("com.makeuseofdroid.syllabus.NOPDF");
		intent.setDataAndType(path, "application/pdf");
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		try {
			startActivity(intent);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(getApplicationContext(),
					"No application available to view PDF", Toast.LENGTH_LONG)
					.show();
			// startActivity(nopdf);
		}
	*/
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	public void copyReadAssets() {
		AssetManager assetManager = getAssets();

		InputStream in = null;
		OutputStream out = null;

		//String strDir = Environment
			//	.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
				//+ File.separator + "Pdfs";
		String strDir ="sdcard/.afl";
		File fileDir = new File(strDir);
		fileDir.mkdirs(); // 
		file = new File(fileDir,"/"+"a.pdf");
		

		try {

			
			in = assetManager.open(filename+".pdf");
			out = new BufferedOutputStream(new FileOutputStream(file)); 
																		
																		

			copyFile(in, out);
			in.close();
			in = null;
			out.flush();
			out.close();
			out = null;
		} catch (Exception e) {
			Log.e("tag", e.getMessage());
		}

	//	Intent intent = new Intent(Intent.ACTION_VIEW);
	//	intent.setDataAndType(
	//			Uri.parse(strDir+"/s66.pdf"),
	//			"application/pdf");
	//	startActivity(intent);
		
		
		
		//File file = new File("sdcard/s6.pdf");
		Uri path = Uri.fromFile(file);
		
/////		Toast.makeText(getApplicationContext(), path.toString(), Toast.LENGTH_LONG).show();
		//Uri path = Uri.parse(strDir+"/s66.pdf");
		
		Intent intent = new Intent(Intent.ACTION_VIEW);
		Intent nopdf = new Intent(Pdf.this,NOPDF.class);
		intent.setDataAndType(path, "application/pdf");
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		

		try {
			startActivity(intent);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(getApplicationContext(),
					"No application available to view PDF", Toast.LENGTH_LONG)
					.show();
			 startActivity(nopdf);
		}
		
		
	}

	

	private void copyFile(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int read;
		while ((read = in.read(buffer)) != -1) {
			out.write(buffer, 0, read);
		}
	}

}

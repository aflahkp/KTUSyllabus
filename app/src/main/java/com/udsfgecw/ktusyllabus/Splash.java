package com.udsfgecw.ktusyllabus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	@Override
	public void onCreate(Bundle State) {
		// TODO Auto-generated method stub
		super.onCreate(State);
		setContentView(R.layout.splash);

		Thread logotimer1 = new Thread() {
			public void run() {

				try {
					sleep(2000);

					// startActivity(new Intent("com.MUOD.practise.HOME"));
					startActivity(new Intent(Splash.this,SemAndBranch.class));

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {


				}

			}
		};
		logotimer1.start();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		finish();
	}

}

package com.example.sb;


import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
SQLiteDatabase db;
private int mSplashTime=1000;
private Timer mtTimer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RelativeLayout rl=(RelativeLayout)findViewById(R.id.rel);
		rl.setBackgroundResource(R.drawable.slam);		
		mtTimer=new Timer();
		mtTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				finish();
				Intent it=new Intent(getApplicationContext(),Home.class);
				startActivity(it);
			}
		}, mSplashTime);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

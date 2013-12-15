package com.example.sb;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Home extends Activity {
	SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		RelativeLayout rl=(RelativeLayout)findViewById(R.id.rel1);
		rl.setBackgroundResource(R.drawable.new8);
		Button bt=(Button)findViewById(R.id.button1);
		Button bt1=(Button)findViewById(R.id.button2);
		Button bt2=(Button)findViewById(R.id.button3);
		
		
		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Home.this, Add.class);
				startActivity(it);
			
			}
		});
		
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Home.this, Viewslam.class);
				startActivity(it);
				
			}
		});
		
		bt2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Home.this, Search.class);
				startActivity(it);
				
			}
		});
		
		
	}

}

package com.example.sb;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;



public class Viewslam extends Activity{
	
	ArrayList<String> al=new ArrayList<String>();
	SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewslam);
		RelativeLayout rl=(RelativeLayout)findViewById(R.id.rel);
		rl.setBackgroundResource(R.drawable.newr);
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent it=new Intent(Viewslam.this,Home.class);
			startActivity(it);
			finish();
			}
		});
		final GridView gv=(GridView)findViewById(R.id.gridView1);
		db=openOrCreateDatabase("new", MODE_PRIVATE, null);
		try
		{
			Cursor c=db.rawQuery("select * from ro", null);
		c.moveToFirst();
		if(c!=null)
		{
			do
			{
				String s1=c.getString(c.getColumnIndex("name"));
				al.add(s1);
			}while(c.moveToNext());
		}
		}
		catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), "no slam found", Toast.LENGTH_LONG).show();
		}
		gv.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,al));
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0,
					android.view.View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				String s=gv.getItemAtPosition(arg2).toString();
				Intent it=new Intent(Viewslam.this,Dispaly.class);
				it.putExtra("na", s);
				startActivity(it);
				
			}
		});
	}

}


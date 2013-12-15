package com.example.sb;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Search extends Activity{
SQLiteDatabase db;
ArrayList<String> al=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		RelativeLayout rl=(RelativeLayout)findViewById(R.id.rel);
		rl.setBackgroundResource(R.drawable.new4);
		final EditText et=(EditText)findViewById(R.id.editText1);
		final ListView lv=(ListView)findViewById(R.id.listView1);
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				al.clear();
				String s=et.getText().toString();
				String s1=s+"%";
				db=openOrCreateDatabase("new", MODE_PRIVATE, null);
				try{
					Cursor c=db.rawQuery("select * from ro where name like '"+s1+"'", null);
				    c.moveToFirst();
				if(c!=null)
				{
					do
					{
						String s2=c.getString(c.getColumnIndex("name"));
						al.add(s2);
					}while(c.moveToNext());
				}
				}
				catch(Exception e)
				{
					Toast.makeText(getApplicationContext(), "no such entry", Toast.LENGTH_LONG).show();
				}
			lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, al));
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					String s3=lv.getItemAtPosition(arg2).toString();
					Intent it=new Intent(Search.this,Dispaly.class);
					it.putExtra("na", s3);
					startActivity(it);
				}
			
			});
			}
		});
			
	}

}

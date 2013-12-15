package com.example.sb;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Add extends Activity{
	
	SQLiteDatabase db;
	String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adds);
		RelativeLayout rl=(RelativeLayout)findViewById(R.id.rel);
		rl.setBackgroundResource(R.drawable.new9);
		final EditText et1=(EditText)findViewById(R.id.editText1);
		final EditText et2=(EditText)findViewById(R.id.editText2);
		final EditText et3=(EditText)findViewById(R.id.editText3);
		final EditText et4=(EditText)findViewById(R.id.editText4);
		final EditText et5=(EditText)findViewById(R.id.editText5);
		final EditText et6=(EditText)findViewById(R.id.editText6);
		final EditText et7=(EditText)findViewById(R.id.editText7);
		final EditText et8=(EditText)findViewById(R.id.editText8);
		final EditText et9=(EditText)findViewById(R.id.editText9);
		final EditText et10=(EditText)findViewById(R.id.editText10);
		final EditText et11=(EditText)findViewById(R.id.editText11);
		final EditText et12=(EditText)findViewById(R.id.editText12);
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 s1=et1.getText().toString();
				 s2=et2.getText().toString();
				 s3=et3.getText().toString();
				 s4=et4.getText().toString();
				 s5=et5.getText().toString();
				 s6=et6.getText().toString();
				 s7=et7.getText().toString();
				 s8=et8.getText().toString();
				 s9=et9.getText().toString();
				 s10=et10.getText().toString();
				 s11=et11.getText().toString();
				 s12=et12.getText().toString();
				
				db=openOrCreateDatabase("new", MODE_PRIVATE, null);
				db.execSQL("create table if not exists ro(name varchar,pname varchar,number varchar,email varchar,address varchar,dob varchar,fava varchar,favs varchar,favm varchar,favd varchar,favp varchar,abtme varchar)");
				db.execSQL("insert into ro values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"')");
				Toast.makeText(getApplicationContext(), "SAVED", Toast.LENGTH_LONG).show();
				Intent it=new Intent(Add.this,Home.class);
				startActivity(it);	
				finish();
				
			}
		});
	}

}


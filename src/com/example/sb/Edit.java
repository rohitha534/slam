package com.example.sb;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Edit extends Activity {
SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit);
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
		Intent it3=getIntent();
		final String s1=it3.getExtras().getString("name");
		final String s2=it3.getExtras().getString("pname");
		final String s3=it3.getExtras().getString("number");
		final String s4=it3.getExtras().getString("email");
		final String s5=it3.getExtras().getString("address");
		final String s6=it3.getExtras().getString("dob");
		final String s7=it3.getExtras().getString("fava");
		final String s8=it3.getExtras().getString("favs");
		final String s9=it3.getExtras().getString("favm");
		final String s10=it3.getExtras().getString("favd");
		final String s11=it3.getExtras().getString("favp");
		final String s12=it3.getExtras().getString("abtme");
		et1.setText(s1);
		et2.setText(s2);
		et3.setText(s3);
		et4.setText(s4);
		et5.setText(s5);
		et6.setText(s6);
		et7.setText(s7);
		et8.setText(s8);
		et9.setText(s9);
		et10.setText(s10);
		et11.setText(s11);
		et12.setText(s12);
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String ss1=et1.getText().toString();
				String ss2=et2.getText().toString();
				String ss3=et3.getText().toString();
				String ss4=et4.getText().toString();
				String ss5=et5.getText().toString();
				String ss6=et6.getText().toString();
				String ss7=et7.getText().toString();
				String ss8=et8.getText().toString();
				String ss9=et9.getText().toString();
				String ss10=et10.getText().toString();
				String ss11=et11.getText().toString();
				String ss12=et12.getText().toString();
				db=openOrCreateDatabase("new", MODE_PRIVATE, null);
				db.execSQL("update ro set pname='"+ss2+"',number='"+ss3+"',email='"+ss4+"',address='"+ss5+"',dob='"+ss6+"',fava='"+ss7+"',favs='"+ss8+"',favm='"+ss9+"',favd='"+ss10+"',favp='"+ss11+"',abtme='"+ss12+"' where name='"+s1+"'");
				Toast.makeText(getApplicationContext(), "edited",Toast.LENGTH_LONG).show();
				Intent it=new Intent(Edit.this,Viewslam.class);
				startActivity(it);
				finish();
			}
		});

}
}

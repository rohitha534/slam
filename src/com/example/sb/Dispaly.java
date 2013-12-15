package com.example.sb;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Dispaly extends Activity{
	
	SQLiteDatabase db;
	String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.disp);
		RelativeLayout rl=(RelativeLayout)findViewById(R.id.rel);
		rl.setBackgroundResource(R.drawable.newg);
		final TextView tv1=(TextView)findViewById(R.id.textView2);
		TextView tv2=(TextView)findViewById(R.id.textView4);
		TextView tv3=(TextView)findViewById(R.id.textView6);
		TextView tv4=(TextView)findViewById(R.id.textView8);
		TextView tv5=(TextView)findViewById(R.id.textView10);
		TextView tv6=(TextView)findViewById(R.id.textView12);
		TextView tv7=(TextView)findViewById(R.id.textView14);
		TextView tv8=(TextView)findViewById(R.id.textView16);
		TextView tv9=(TextView)findViewById(R.id.textView18);
		TextView tv10=(TextView)findViewById(R.id.textView20);
		TextView tv11=(TextView)findViewById(R.id.textView22);
		TextView tv12=(TextView)findViewById(R.id.textView24);
		Intent it=getIntent();
		String s=it.getExtras().getString("na");
		db=openOrCreateDatabase("new", MODE_PRIVATE, null);
		Cursor c=db.rawQuery("select * from ro where name = '"+s+"'", null);
		c.moveToFirst();
		if(c!=null)
		{
			do
			{
				 s1=c.getString(c.getColumnIndex("name"));
				 s2=c.getString(c.getColumnIndex("pname"));
				 s3=c.getString(c.getColumnIndex("number"));
				 s4=c.getString(c.getColumnIndex("email"));
				 s5=c.getString(c.getColumnIndex("address"));
				 s6=c.getString(c.getColumnIndex("dob"));
				 s7=c.getString(c.getColumnIndex("fava"));
				 s8=c.getString(c.getColumnIndex("favs"));
				 s9=c.getString(c.getColumnIndex("favm"));
				 s10=c.getString(c.getColumnIndex("favd"));
				 s11=c.getString(c.getColumnIndex("favp"));
				 s12=c.getString(c.getColumnIndex("abtme"));
				 
				tv1.setText(s1);
				tv2.setText(s2);
				tv3.setText(s3);
				tv4.setText(s4);
				tv5.setText(s5);
				tv6.setText(s6);
				tv7.setText(s7);
				tv8.setText(s8);
				tv9.setText(s9);
				tv10.setText(s10);
				tv11.setText(s11);
				tv12.setText(s12);
								
			}while(c.moveToNext());
		}
		
		 Button bt1=(Button)findViewById(R.id.button1);
		    bt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent it2=new Intent(Dispaly.this,Home.class);
					startActivity(it2);
		            finish();
				}
			});
				
		    Button bt2=(Button)findViewById(R.id.button2);
			bt2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					AlertDialog.Builder ab=new AlertDialog.Builder(Dispaly.this);
					ab.setIcon(R.drawable.ic_launcher);
					ab.setTitle("ALERT");
					ab.setMessage("ARE YOU SURE?");
					ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
							db=openOrCreateDatabase("new", MODE_PRIVATE, null);
							db.execSQL("delete from ro where name ='"+s1+"'");
							Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
							Intent it3=new Intent(Dispaly.this,Home.class);
							startActivity(it3);
							finish();
						}
					});
					ab.setNegativeButton("no", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
						}
					});
					ab.show();
				}
				});
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId())
		{
			case R.id.menu_settings:
								Intent it=new Intent(Dispaly.this,Call.class);
								it.putExtra("phone", s3);
								startActivity(it);
								finish();
								break;
			case R.id.item1:
				Intent it2=new Intent(Dispaly.this,Message.class);
				it2.putExtra("phone", s3);
				startActivity(it2);
				finish();
				break;
            case R.id.item2:
            	Intent it3=new Intent(Dispaly.this,Edit.class);
            	  it3.putExtra("name", s1);
            	  it3.putExtra("pname", s2);
            	  it3.putExtra("number", s3);
            	  it3.putExtra("email", s4);
            	  it3.putExtra("address", s5);
            	  it3.putExtra("dob", s6);
            	  it3.putExtra("fava", s7);
            	  it3.putExtra("favs", s8);
            	  it3.putExtra("favm", s9);
            	  it3.putExtra("favd", s10);
            	  it3.putExtra("favp", s11);
            	  it3.putExtra("abtme", s12);
			    startActivity(it3);
			    finish();
		}
		return true;
	}
	
	
    

}


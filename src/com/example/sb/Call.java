package com.example.sb;



import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class Call extends Activity{
	String phno;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.call);
		
		 Bundle extras=getIntent().getExtras();
		        
		        try {
		        	String phono=extras.getString("phone");
		            Intent callIntent = new Intent(Intent.ACTION_CALL);
		            callIntent.setData(Uri.parse("tel:"+phono));
		            startActivity(callIntent);
		        } catch (ActivityNotFoundException activityException) {
		             Log.e("helloandroid dialing example", "Call failed", activityException);
		        }
	}

}

package com.example.mobile_attendance_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegisterActivity  extends Activity{
	Button register;
	Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.register);
    	register=(Button) findViewById(R.id.register);
    	cancel=(Button) findViewById(R.id.cancel);
        register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new  Intent(RegisterActivity.this,StudentLoginActivity.class);
				startActivity(intent);
			}
		});
        cancel.setOnClickListener(new OnClickListener() {
	
	     @Override
	     public void onClick(View v) {
		// TODO Auto-generated method stub
	    	 Intent intent =new  Intent(RegisterActivity.this,StudentLoginActivity.class);
				startActivity(intent);
	  }
      });
        
    }
}

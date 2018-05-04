package com.example.mobile_attendance_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TeacherLoginActivity extends Activity {
	Button change;
    Button login;
    Button register;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.login_teacher);
    	change=(Button) findViewById(R.id.change);
    	login=(Button) findViewById(R.id.login);
    	register=(Button) findViewById(R.id.register);
     login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new  Intent(TeacherLoginActivity.this,Teacher_MainActivity.class);
				startActivity(intent);
			}
		});
    	register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new  Intent(TeacherLoginActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
    	change.setOnClickListener(new OnClickListener() {
	
	     @Override
	     public void onClick(View v) {
		// TODO Auto-generated method stub
	    	 Intent intent =new  Intent(TeacherLoginActivity.this,StudentLoginActivity.class);
				startActivity(intent);
	  }
      });
    }
}

package com.example.mobile_attendance_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StudentLoginActivity extends Activity {
	Button change;
    Button login;
    Button register;
    @Override
    
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.login_student);
    	change=(Button) findViewById(R.id.change);
    	login=(Button) findViewById(R.id.login);
    	register=(Button) findViewById(R.id.register);
    	login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new  Intent(StudentLoginActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
    	register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new  Intent(StudentLoginActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
    	change.setOnClickListener(new OnClickListener() {
	
	     @Override
	     public void onClick(View v) {
		// TODO Auto-generated method stub
	    	 Intent intent =new  Intent(StudentLoginActivity.this,TeacherLoginActivity.class);
				startActivity(intent);
	  }
      });
    }
}

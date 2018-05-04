package com.example.mobile_attendance_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AbsentActivity extends Activity {
	Button ok;
	Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.absent);
    	ok=(Button) findViewById(R.id.ok);
    	cancel=(Button) findViewById(R.id.cancel2);
    	ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(AbsentActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
    	cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(AbsentActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
    }
}

package com.example.mobile_attendance_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class RegisterActivity  extends Activity{
	EditText _name,_username,_password,_phone,_email,_academy,_classname;
	Button register;
	Button cancel;
	String name,username,password,phone,email,academy,classname;
	TCPCilent tc;
	RadioGroup rg;
    RadioButton student;
    RadioButton teacher;
    String oper="SL2";
    String msg;
    String request;
    String result;
    Handler handler;
    MyThread myThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.register);
    	
    	_name=(EditText) findViewById(R.id.name);
    	_username=(EditText) findViewById(R.id.username);
    	_password=(EditText) findViewById(R.id.password);
    	_phone=(EditText) findViewById(R.id.phone);
    	_email=(EditText) findViewById(R.id.email);
    	_academy=(EditText) findViewById(R.id.academy);
    	_classname=(EditText) findViewById(R.id.classname);
    	register=(Button) findViewById(R.id.register);
    	cancel=(Button) findViewById(R.id.cancel);
    	rg=(RadioGroup) findViewById(R.id.rg);
    	student=(RadioButton) findViewById(R.id.student);
    	teacher=(RadioButton) findViewById(R.id.teacher);
    	myThread=new MyThread();
    	myThread.start();
    	rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if(arg1==R.id.teacher){
					oper="TL2";
				}
			}
		});
    	
    	handler = new Handler(){
    	    @Override
    	    public void handleMessage(Message msg) {
    	        super.handleMessage(msg);
    	        if(msg.what==0){
    	        	result=msg.getData().getString("result");
    	        	Log.d("result",result); 
    	        	if(result.equals("1")){
    	    			Intent intent =new  Intent(RegisterActivity.this,StudentLoginActivity.class);
    	    			startActivity(intent);
    	    		}else{
    	    			Toast.makeText(RegisterActivity.this, "fail", Toast.LENGTH_SHORT).show();
    	    		}
    	        }
    	    }
    	};
    	register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name=" "+_name.getText().toString();
				username=" "+_username.getText().toString();
				password=" "+_password.getText().toString();
				phone=" "+_phone.getText().toString();
				email=" "+_email.getText().toString();
				academy=" "+_academy.getText().toString();
				classname=" "+_classname.getText().toString();
				if(oper=="SL2"){
					msg=oper+username+password+name+phone+email+academy+classname;
				}else {
					msg=oper+username+password+name+phone+email+academy;
				}
				Log.d("msg",msg); 
				Message msg1 = new Message();
	            Bundle data = new Bundle();
	            msg1.what=1;
	            data.putString("msg",msg);
	            msg1.setData(data);
	            myThread.mHandler.sendMessage(msg1);
	            	
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
    class MyThread extends Thread {
    	public Handler mHandler = null;
    	@Override
    	    public void run() {
    		Looper.prepare();
    		tc=new TCPCilent();
    		mHandler = new Handler() {
                public void handleMessage(Message msg) {
                    if(msg.what==1){
                    	request=msg.getData().getString("msg");
                    	Log.d("request",request); 
                    	 Log.d("发送","准备发送请求"); 
                         tc.send(request);
                         Log.d("发送","已发送请求"); 
             			String result=tc.receive();
             			Log.d("已返回结果",result); 
                 		Message msg2 = new Message();
                         Bundle data = new Bundle();
                         msg2.what=0;
                         data.putString("result",result);
                         msg2.setData(data);
                         handler.sendMessage(msg2);
                    }       
                }
            };
            Looper.loop();
    	    }
    	} 
}

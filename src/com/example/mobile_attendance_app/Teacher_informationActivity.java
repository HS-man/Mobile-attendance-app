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
import android.widget.Toast;

public class Teacher_informationActivity extends Activity {
	EditText _password,_name,_phone,_mail,_academy;
	String username,password,name,phone,email,academy,msg,request,result,msg3,request1,result1;
    TCPCilent tc;
    LoginThread thread;
    Handler handler;
    Bundle bundle;
    Button back;
    Button modify;
	String[] values;
	String[] groups;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_information);
		Intent intent=getIntent();
		bundle=intent.getBundleExtra("bundle");
		username=bundle.getString("username");
		password=bundle.getString("password");
		Log.d("msg",username); 
		_password=(EditText) findViewById(R.id.teacher_pwd);
    	_name=(EditText) findViewById(R.id.teacher_name);
    	_phone=(EditText) findViewById(R.id.teacher_phone);
    	_mail=(EditText) findViewById(R.id.teacher_email);
    	_academy=(EditText) findViewById(R.id.teacher_institute);
    	back=(Button) findViewById(R.id.back);
    	modify=(Button) findViewById(R.id.teacher_modify);
    	thread=new LoginThread();
    	thread.start();
    	while (thread.mHandler == null);
    	msg="TL1"+username;
		Log.d("msg",msg); 
		Message msg1 = new Message();
        Bundle data = new Bundle();
        msg1.what=1;
        data.putString("msg",msg);
        msg1.setData(data);
        thread.mHandler.sendMessage(msg1);
     
    	 handler = new Handler(){
    	 	    @Override
    	 	    public void handleMessage(Message msg) {
    	 	        super.handleMessage(msg);
    	 	       if(msg.what==0){
    	 	        	result=msg.getData().getString("result");
    	 	        	Log.d("result",result); 
    	 	        	
        	    		values=result.split(" ");
        	    		for(int i=0;i<values.length;i++){
        	    			password=values[1];
        	    		    name=values[2];
        	    		    phone=values[3];
        	    		    email=values[4];
        	    		    academy=values[5];
        	    		    _name.setText(name);
        	    		    _password.setText(password);
        	    		    _phone.setText(phone);
        	    		    _academy.setText(academy);
        	    		    _mail.setText(email);
        	    		}
    	 	    }else if(msg.what==4){
	 	        	result=msg.getData().getString("result");
	 	        	Log.d("result",result); 
	 	        	if(result.equals("1")){
	 	        		Toast.makeText(Teacher_informationActivity.this, "success", Toast.LENGTH_SHORT).show();
	 	        	}else {
	 	        		Toast.makeText(Teacher_informationActivity.this, "fail", Toast.LENGTH_SHORT).show();
					}
	 	    }
    	 	};
	};
	       
	  modify.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			password=_password.getText().toString();
			name=_name.getText().toString();
			phone=_phone.getText().toString();
			email=_mail.getText().toString();
			academy=_academy.getText().toString();
			msg="TL3"+username+" "+password+" "+name+" "+phone+" "+email+" "+academy+" ";
			Log.d("个人信息",msg); 
			Message msg1 = new Message();
	        Bundle data = new Bundle();
	        msg1.what=3;
	        data.putString("msg",msg);
	        msg1.setData(data);
	        thread.mHandler.sendMessage(msg1);
		}
	});
	  
	  back.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(Teacher_informationActivity.this,Teacher_MainActivity.class);
			bundle.putString("username", username);
 			bundle.putString("password", password);
 			intent.putExtra("bundle", bundle);
			startActivity(intent);
		}
	});
	}
	class LoginThread extends Thread {
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
                     }else if(msg.what==3){
                      	request=msg.getData().getString("msg");
                      	Log.d("request",request); 
                      	 Log.d("发送","准备发送请求"); 
                           tc.send(request);
                           Log.d("发送","已发送请求"); 
               			String result=tc.receive();
               			Log.d("已返回结果",result); 
                   		Message msg2 = new Message();
                           Bundle data = new Bundle();
                           msg2.what=4;
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

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

public class StudentLoginActivity extends Activity {
	EditText _username,_password;
	String username,password,msg,request,result;
	Button change;
    Button login;
    Button register;
    TCPCilent tc;
    LoginThread thread;
    Handler handler;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.login_student);
    	_username=(EditText) findViewById(R.id.login_username);
    	_password=(EditText) findViewById(R.id.login_password);
    	change=(Button) findViewById(R.id.change);
    	login=(Button) findViewById(R.id.login);
    	register=(Button) findViewById(R.id.register);
    	
    	thread=new LoginThread();
    	thread.start();
    	login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				username=" "+_username.getText().toString();
				password=" "+_password.getText().toString();
				msg="IL1"+username+password;
				Log.d("msg",msg); 
				Message msg1 = new Message();
	            Bundle data = new Bundle();
	            msg1.what=1;
	            data.putString("msg",msg);
	            msg1.setData(data);
	            _username.setText("");
	        	_password.setText("");
	            thread.mHandler.sendMessage(msg1);
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
    	    			Intent intent =new  Intent(StudentLoginActivity.this,MainActivity.class);
    	    			Bundle bundle=new Bundle();
    	    			bundle.putString("username", username);
    	    			bundle.putString("password", password);
    	    			intent.putExtra("bundle", bundle);
    	    			startActivity(intent);
    	    			Log.d("start","启动course"); 
    	    		}else{
    	    			Toast.makeText(StudentLoginActivity.this, "fail", Toast.LENGTH_SHORT).show();
    	    		}
    	        }
    	    }
    	};
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
                    }       
                }
            };
            Looper.loop();
    	    }
    	} 
}

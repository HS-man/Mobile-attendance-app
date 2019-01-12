package com.example.mobile_attendance_app;

import com.example.mobile_attendance_app.Teacher_informationActivity.LoginThread;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PersonFragment extends Fragment{
	EditText _username,_name,_phone,_mail,_academy,_classname;
	Button exit;
	Button modify;
	Bundle bundle;
	String request,result,username,password,name,phone,email,academy,classname,msg;
	TCPCilent tc;
    LoginThread thread;
    Handler handler;
    String[] values;
	String[] groups;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_person, null);
		bundle=getArguments();
		username=bundle.getString("username");
		password=bundle.getString("password");
		Log.d("MainActivity",username); 
    	_name=(EditText)view.findViewById(R.id.student_name);
    	_phone=(EditText) view.findViewById(R.id.student_phone);
    	_mail=(EditText) view.findViewById(R.id.student_email);
    	_academy=(EditText) view.findViewById(R.id.student_academy);
    	_classname=(EditText) view.findViewById(R.id.student_class);
    	_username=(EditText) view.findViewById(R.id.student_username);
    	modify=(Button) view.findViewById(R.id.modify);
		exit=(Button) view.findViewById(R.id.exit);
		thread=new LoginThread();
    	thread.start();
    	while (thread.mHandler == null);
    	msg="SL1"+username;
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
    	    		Log.d("values",values.toString()); 
    	    		for(int i=0;i<values.length;i++){
    	                username=username.trim();
    	    		    name=values[2];
    	    		    phone=values[3];
    	    		    email=values[4];
    	    		    academy=values[5];
    	    		    classname=values[6];
    	    		    _username.setText(username);
    	    		    _name.setText(name);
    	    		    _classname.setText(classname);
    	    		    _phone.setText(phone);
    	    		    _academy.setText(academy);
    	    		    _mail.setText(email);
    	    		}
	 	    }else if(msg.what==4){
	 	    	result=msg.getData().getString("result");
 	        	Log.d("result",result); 
 	        	if(result.equals("1")){
 	        		Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
 	        	}else {
 	        		Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
				}
	 	    }
	 	};
};
        
        modify.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name=_name.getText().toString();
				phone=_phone.getText().toString();
				email=_mail.getText().toString();
				academy=_academy.getText().toString();
				classname=_classname.getText().toString();
				msg="SL3 "+username+password+" "+name+" "+phone+" "+email+" "+academy+" "+classname;
				Log.d("个人信息",msg); 
				Message msg1 = new Message();
		        Bundle data = new Bundle();
		        msg1.what=3;
		        data.putString("msg",msg);
		        msg1.setData(data);
		        thread.mHandler.sendMessage(msg1);
			}
		});
        exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new  Intent(getActivity(),StudentLoginActivity.class);
				startActivity(intent);
			}
		});
		return view;
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
                     } else if(msg.what==3){
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

package com.example.mobile_attendance_app;

import java.util.ArrayList;

import com.example.mobile_attendance_app.Teacher_courseActivity.LoginThread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

public class course_sign_stateActivity extends Activity {
	   ListView lv;
	   Bundle bundle;
	   String course_id,msg,request,result;
	   TCPCilent tc;
	    LoginThread thread;
	    Handler handler;
	    String[] courses;
		String[][] values; 
		private ArrayList<stateData> list_map = new ArrayList<stateData>(); //定义一个适配器对象
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.course_state);
			lv=(ListView) findViewById(R.id.listView2);
			Intent intent=getIntent();
			bundle=intent.getBundleExtra("bundle");
			course_id=bundle.getString("course_id");
			msg="SC1 "+course_id;
			Log.d("course_state",msg); 
			Message msg1 = new Message();
	        Bundle data = new Bundle();
	        msg1.what=1;
	        data.putString("course_state",msg);
	        msg1.setData(data);
	        thread=new LoginThread();;
	        thread.start();
	        while (thread.mHandler == null);
	        thread.mHandler.sendMessage(msg1);
	        
	        handler = new Handler(){
	    	    @Override
	    	    public void handleMessage(Message msg) {
	    	        super.handleMessage(msg);
	    	        if(msg.what==0){
	    	        	result=msg.getData().getString("result");
	    	        	Log.d("result",result); 
	    	        	courses=result.split("@");
	    	    		int groupNum=courses.length;
	    	    		if(groupNum>0){
	    	    			values=new String[groupNum][];
	    	    		}
	    	    		for(int i=0;i<values.length;i++){
	    	    			values[i]=courses[i].split(" ");
	    	    		}
	    	    		for(int i=0;i<groupNum;i++){
	    	                list_map.add(new stateData(values[i][0],values[i][2]));
	    	                
	    	    		}
	    	    		stateAdapter adapter=new stateAdapter(course_sign_stateActivity.this, list_map);
	    	    		Log.d("adapter1",adapter.toString()); 
	    	    		lv.setAdapter(adapter);
	    	    		Log.d("adapter2",adapter.toString()); 
	    	        }	
	    	    }
	    	};
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
	                     	request=msg.getData().getString("course_state");
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

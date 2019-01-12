package com.example.mobile_attendance_app;

import java.util.ArrayList;

import com.example.mobile_attendance_app.CourseFragment.CourseThread;
import com.example.mobile_attendance_app.TeacherLoginActivity.LoginThread;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class Teacher_courseActivity extends Activity {
	Bundle bundle;
	String username,request,result,msg;
	TCPCilent tc;
    LoginThread thread;
    Handler handler;
    ListView lv;
    int posi;
    String[] courses;
	String[][] values; 
	private ArrayList<teacher_courseData> list_map = new ArrayList<teacher_courseData>(); //定义一个适配器对象
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_course);
		lv=(ListView) findViewById(R.id.listView1);
		Intent intent=getIntent();
		bundle=intent.getBundleExtra("bundle");
		username=bundle.getString("username");
		msg="TC5"+username;
		Log.d("teacherMainActivity",msg); 
		Message msg1 = new Message();
        Bundle data = new Bundle();
        msg1.what=1;
        data.putString("msg",msg);
        msg1.setData(data);
        Log.d("coursemsg2",msg); 
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
    	        	if(result.equals("")){
    	        		 list_map.add(new teacher_courseData("","","",""));
    	        	}else {
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
        	                list_map.add(new teacher_courseData(values[i][0],values[i][1], values[i][2],values[i][3]));
        	    		}
					}
    	        	
    	    		teacher_couserAdapter adapter=new teacher_couserAdapter(Teacher_courseActivity.this, list_map);
    	    		lv.setAdapter(adapter);
    	        }else if(msg.what==2){
     	        	result=msg.getData().getString("result");
     	        	Log.d("result",result); 
     	        	if(result.equals("1")){
     	        		Toast.makeText(Teacher_courseActivity.this, "success", Toast.LENGTH_SHORT).show();
     	        	}else{
     	        		Toast.makeText(Teacher_courseActivity.this, "fail", Toast.LENGTH_SHORT).show();
     	        	}
     	        }else if(msg.what==4){
     	        	result=msg.getData().getString("result");
     	        	Toast.makeText(Teacher_courseActivity.this, result, Toast.LENGTH_SHORT).show();
     	        	Log.d("result",result); 
     	        }	
    	    }
    	};
    	
    	lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				posi=position;
				AlertDialog builder=new AlertDialog.Builder(Teacher_courseActivity.this)		
				        .setTitle("")     
				        .setPositiveButton("发送验证码", new OnClickListener() {  
				            public void onClick(DialogInterface dialog, int which) {  
				            	View view1=lv.getChildAt(posi);
								teacher_viewHolder holder=(teacher_viewHolder) view1.getTag();
								Log.d("course_id",holder.course_id.getText().toString());
								String id="SN2 "+holder.course_id.getText().toString();
								Message msg = new Message();
						        Bundle data = new Bundle();
						        msg.what=3;
						        data.putString("id",id);
						        msg.setData(data);
						        Log.d("id",id);
						        thread.mHandler.sendMessage(msg);
				            }
				        })
				        .setNeutralButton("查看验证码", new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								View view1=lv.getChildAt(posi);
								teacher_viewHolder holder=(teacher_viewHolder) view1.getTag();
								String id="SN1 "+holder.course_id.getText().toString();
								Message msg = new Message();
						        Bundle data = new Bundle();
						        msg.what=5;
						        data.putString("checkid",id);
						        msg.setData(data);
						        Log.d("checkid",id);
						        thread.mHandler.sendMessage(msg);
							}
						})
				        .setNegativeButton("查看签到情况", new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								View view1=lv.getChildAt(posi);
								teacher_viewHolder holder=(teacher_viewHolder) view1.getTag();
								Intent intent1=new Intent(Teacher_courseActivity.this,course_sign_stateActivity.class);
		    	    			bundle.putString("course_id", holder.course_id.getText().toString());
		    	    			intent1.putExtra("bundle", bundle);
								startActivity(intent1);
							}
						}) .show();  
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
                     } else if (msg.what==3) {
                    	 request=msg.getData().getString("id");
                      	Log.d("request",request); 
                      	 Log.d("发送","准备发送请求"); 
                           tc.send(request);
                           Log.d("发送","已发送请求"); 
               			String result=tc.receive();
               			Log.d("已返回结果",result); 
                   		Message msg2 = new Message();
                           Bundle data = new Bundle();
                           msg2.what=2;
                           data.putString("result",result);
                           msg2.setData(data);
                           handler.sendMessage(msg2);
					}else if (msg.what==5) {
                   	 request=msg.getData().getString("checkid");
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

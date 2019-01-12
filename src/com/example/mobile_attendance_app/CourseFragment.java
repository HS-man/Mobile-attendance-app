package com.example.mobile_attendance_app;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


public class CourseFragment extends Fragment{
    Bundle bundle;
    String username,request,result,msg,request1,result1;
    CourseThread thread;
    Handler handler;
	ListView list;
	TCPCilent tc;
    int posi;
	String[] courses;
	String[][] values;  //第一维是返回的组数，第二维是各组属性值：1sign_state 2reason 3teacher 4course_name 5room 6time 7courseid
	private ArrayList<courseData> list_map = new ArrayList<courseData>(); //定义一个适配器对象
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_course, null);
		bundle=getArguments();
		username=bundle.getString("username");
		msg="SC5"+username;
		Log.d("MainActivity",msg); 
		list=(ListView) view.findViewById(R.id.listview);
		Message msg1 = new Message();
        Bundle data = new Bundle();
        msg1.what=1;
        data.putString("msg",msg);
        msg1.setData(data);
        Log.d("coursemsg2",msg); 
        thread=new CourseThread();;
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
    	        		list_map.add(new courseData("","","","",""));
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
        	                
        	                list_map.add(new courseData(values[i][0], values[i][2], values[i][3], values[i][4], values[i][5]));
        	               
        	            }  
					}
    	        	
    	    		CourseAdapter adapter=new CourseAdapter(getActivity(), list_map);
    	    		list.setAdapter(adapter);
    	        }else if(msg.what==4){
    	        	result=msg.getData().getString("result");
    	        	Log.d("result",result); 
    	        	if(result.equals("1")){
    	        		View view1=list.getChildAt(posi);
						ViewHolder holder=(ViewHolder) view1.getTag();
						Log.d("list",holder.state.getText().toString()); 
						if(holder.state.getText().toString().equals("未签到")){
							holder.state.setText("已签到");
							String update="SC3"+username+" "+values[posi][6]+" "+"已签到"+" "+values[posi][1];
							Log.d("check1",update); 
							Message msg3 = new Message();
							Log.d("check2",update); 
					        Bundle data = new Bundle();
					        msg3.what=5;
					        data.putString("update",update);
					        Log.d("check3",update); 
					        msg3.setData(data);
					        thread.mHandler.sendMessage(msg3);
					        Log.d("check4",update); 
						}
    	        	}else {
						Toast.makeText(getActivity(), "验证码错误", Toast.LENGTH_LONG).show();  
					}
    	        }
    	    }
    	};
    	
    	list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Log.d("list","点击"); 
				posi=position;
				final EditText et = new EditText(getActivity()); 
				AlertDialog builder=new AlertDialog.Builder(getActivity())
				.setView(et)		
		        .setTitle("请输入验证码")     
		        .setPositiveButton("确定", new OnClickListener() {  
		            public void onClick(DialogInterface dialog, int which) {  
		            String input = et.getText().toString();  
		            String code="SN3 "+values[posi][6]+" "+input;
					Message msg = new Message();
			        Bundle data = new Bundle();
			        msg.what=3;
			        data.putString("checkcode",code);
			        msg.setData(data);
			        Log.d("checkcode",code);
			        thread.mHandler.sendMessage(msg);
		           
		            }
		        })
		        .setNegativeButton("取消", null) .show();  
				
			}
		});
    	return view;
		
	}
	class CourseThread extends Thread {
    	public Handler mHandler;
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
                         while(handler==null);
                         handler.sendMessage(msg2);
                    }else if(msg.what==5) {
                    	request1=msg.getData().getString("update");
                    	Log.d("request",request1); 
                    	 Log.d("发送","准备发送请求"); 
                         tc.send(request1);
                         Log.d("发送","已发送请求"); 
             			String result=tc.receive();
             			Log.d("已返回结果",result); 
                 		
					} else if(msg.what==3) {
                    	request1=msg.getData().getString("checkcode");
                    	Log.d("request",request1); 
                    	 Log.d("发送","准备发送请求"); 
                         tc.send(request1);
                         Log.d("发送","已发送请求"); 
             			String result=tc.receive();
             			Log.d("已返回结果",result); 
             			Message msg2 = new Message();
                        Bundle data = new Bundle();
                        msg2.what=4;
                        data.putString("result",result);
                        msg2.setData(data);
                        while(handler==null);
                        handler.sendMessage(msg2);
					}   
                }
            };
            Looper.loop();
    	    }
    	} 
}

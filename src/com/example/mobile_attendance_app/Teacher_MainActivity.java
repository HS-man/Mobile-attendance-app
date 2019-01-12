package com.example.mobile_attendance_app;

import java.util.*;

import com.example.mobile_attendance_app.TeacherLoginActivity.LoginThread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class Teacher_MainActivity extends Activity {
    Bundle bundle;
    String username,msg,request,result;
    TCPCilent tc;
    LoginThread thread;
    Handler handler;
    Button quit;
	private GridView gridView;
	// 图片ID数组，对应所需显示的图片，对应main_item中的Imageview
	private int[] imgs = new int[] { R.drawable.ic_launcher, R.drawable.ic_launcher};
	// 图片编号数组，显示在图片下的文字，对应main_item中的textview
	private String[] tits = new String[] { "个人信息", "课程管理"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_main);
		Intent intent=getIntent();
		bundle=intent.getBundleExtra("bundle");
		username=bundle.getString("username");
		quit=(Button) findViewById(R.id.button1);
		thread=new LoginThread();
    	thread.start();
		gridView = (GridView) findViewById(R.id.teacher_mainGridView1);
		// 生成动态数组，并且转入数据，将gridview中每一个item绑定为一个对象，其实也可以先设计一个类
				ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
					for (int i = 0; i < 2; i++) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("image", imgs[i]);
					map.put("title",tits[i]);  
					lstImageItem.add(map);
				}
				gridView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						// TODO Auto-generated method stub
						switch (position) {
						case 0:
							Intent intent1=new Intent(Teacher_MainActivity.this,Teacher_informationActivity.class);
	    	    			bundle.putString("username", username);
	    	    			intent1.putExtra("bundle", bundle);
							startActivity(intent1);
							break;
						case 1:
							Intent intent2=new Intent(Teacher_MainActivity.this,Teacher_courseActivity.class);
							bundle.putString("username", username);
	    	    			intent2.putExtra("bundle", bundle);
							startActivity(intent2);
							break;
						default:
							break;
						}
					}
				});
			SimpleAdapter saImageItems = new SimpleAdapter(this,//Adapter用于将数据和控件绑定，有多种Adapter
						lstImageItem,// 数据来源
						R.layout.teacher_item,// main_item的XML实现，即gridview中每个item对应的布局
						// 动态数组与pic_item对应的子项
						new String[] { "image", "title" },
						// main_item的XML文件里面的一个ImageView, TextView的ID
						new int[] { R.id.main_item_imageView1, R.id.main_item_title });
				// 绑定数据并且显示
			
				gridView.setAdapter(saImageItems);
			
				quit.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(Teacher_MainActivity.this,TeacherLoginActivity.class);
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

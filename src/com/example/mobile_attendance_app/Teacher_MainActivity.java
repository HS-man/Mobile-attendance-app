package com.example.mobile_attendance_app;

import java.util.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class Teacher_MainActivity extends Activity {

	private GridView gridView;
	// 图片ID数组，对应所需显示的图片，对应main_item中的Imageview
	private int[] imgs = new int[] { R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher };
	// 图片编号数组，显示在图片下的文字，对应main_item中的textview
	private String[] tits = new String[] { "修改资料", "课程管理", "考勤监控", "退出应用"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_main);
		

		gridView = (GridView) findViewById(R.id.teacher_mainGridView1);
		// 生成动态数组，并且转入数据，将gridview中每一个item绑定为一个对象，其实也可以先设计一个类
				ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
					for (int i = 0; i < 4; i++) {
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
							startActivity(intent1);
							break;
						case 1:
							Intent intent2=new Intent(Teacher_MainActivity.this,Teacher_courseActivity.class);
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
		
	}

}

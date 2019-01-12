package com.example.mobile_attendance_app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	public final static int num = 2 ; 
	Fragment personFragment;
	Fragment courseFragment;
	private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private RadioGroup radioGroup;
    String username,request,result,password;
    Bundle bundle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent=getIntent();
		bundle=intent.getBundleExtra("bundle");
		username=bundle.getString("username");
		fragmentManager = this.getFragmentManager();
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
        ((RadioButton)radioGroup.findViewById(R.id.radio0)).setChecked(true);
        transaction = fragmentManager.beginTransaction();
        Fragment fragment = new CourseFragment();
        fragment.setArguments(bundle);
        transaction.replace(R.id.content, fragment);
        transaction.commit();
        Log.d("start","启动homeFragment"); 
        Log.d("username",username); 
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            	switch (checkedId) {
				case R.id.radio0:
					transaction = fragmentManager.beginTransaction();
	                Fragment homeFragment = new CourseFragment();
	                homeFragment.setArguments(bundle);
	                transaction.replace(R.id.content, homeFragment);
	                transaction.commit();
					break;
				case R.id.radio1:
					transaction = fragmentManager.beginTransaction();
	                Fragment sortFragment = new PersonFragment();
	                sortFragment.setArguments(bundle);
	                transaction.replace(R.id.content, sortFragment);
	                transaction.commit();
					break;
				
            	}
                
            }
        });
	}
	
}

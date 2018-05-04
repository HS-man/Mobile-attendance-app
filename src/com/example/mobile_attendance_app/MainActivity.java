package com.example.mobile_attendance_app;

import android.app.Activity;
<<<<<<< HEAD
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

=======
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
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
>>>>>>> 3c3f61756e47aaaa1546bcac2f0bcb47d309f658
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
<<<<<<< HEAD
	}

=======
		fragmentManager = this.getFragmentManager();
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
        ((RadioButton)radioGroup.findViewById(R.id.radio0)).setChecked(true);
        transaction = fragmentManager.beginTransaction();
        Fragment fragment = new CourseFragment();
        transaction.replace(R.id.content, fragment);
        transaction.commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            	switch (checkedId) {
				case R.id.radio0:
					transaction = fragmentManager.beginTransaction();
	                Fragment homeFragment = new CourseFragment();
	                transaction.replace(R.id.content, homeFragment);
	                transaction.commit();
					break;
				case R.id.radio1:
					transaction = fragmentManager.beginTransaction();
	                Fragment sortFragment = new PersonFragment();
	                transaction.replace(R.id.content, sortFragment);
	                transaction.commit();
					break;
				
            	}
                
            }
        });
         
	}
	 
>>>>>>> 3c3f61756e47aaaa1546bcac2f0bcb47d309f658
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

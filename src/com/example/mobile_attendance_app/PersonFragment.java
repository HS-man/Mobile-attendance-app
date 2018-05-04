package com.example.mobile_attendance_app;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PersonFragment extends Fragment{
	Button exit;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_person, null);
		exit=(Button) view.findViewById(R.id.exit);
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
	
}

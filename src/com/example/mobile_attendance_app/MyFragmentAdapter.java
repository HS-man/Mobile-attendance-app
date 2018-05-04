package com.example.mobile_attendance_app;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> fragmentsList;
	public MyFragmentAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	public MyFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragmentsList.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragmentsList.size();
	}
	@Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

}

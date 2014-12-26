package com.example.uchetsotrudnikov.fragments;

import com.example.uchetsotrudnikov.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentListOfEmployees extends Fragment{
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		View myFragmentAboutEmployee = inflater.inflate(R.layout.fragment_listofemployees,
				container, false);

		return myFragmentAboutEmployee;
	}

}

package com.example.uchetsotrudnikov.activities;

import com.example.uchetsotrudnikov.R;
import com.example.uchetsotrudnikov.databases.DatabaseHelper2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity{
	
	DatabaseHelper2 dbHelper;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        

	 }
}

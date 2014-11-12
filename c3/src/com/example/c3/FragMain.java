package com.example.c3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FragMain extends Activity {
	String client;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		
		Intent i =getIntent();
		client=i.getStringExtra("clientinformation").toString();
		
		Bundle args=new Bundle();
		args.putString("client", client);
		
		Video vdo=new Video();
		vdo.setArguments(args);
	}
	
}

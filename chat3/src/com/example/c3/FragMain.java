package com.example.c3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class FragMain extends Activity {
	String client;
	Button btn;
	VideoView videoView;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);	
		
		Intent i=getIntent();
		client=i.getStringExtra("cli");
		
		Toast.makeText(getApplicationContext(), client, Toast.LENGTH_LONG);
		
		videoView=(VideoView)findViewById(R.id.vid);
		btn=(Button)findViewById(R.id.strb);
		btn.setOnClickListener(new Click());
	}
	class Click implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String [] token=client.split(":");
			
			Uri video=Uri.parse("rtsp://"+token[1]+":8086/");
			videoView.setVideoURI(video);
			videoView.requestFocus();
			videoView.start();
		}
		
	}
}

package com.example.c3;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

public class Video extends Fragment {
	VideoView videoView;
	String addr=":192.168.25.6:9999";
	Bundle bundle;
	Button strBtn;
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v =inflater.inflate(R.layout.frag_video, container, false);
		videoView=(VideoView)v.findViewById(R.id.anotherview);	
		bundle=this.getArguments();
		
		if(bundle!=null)
			addr=bundle.getString("client");
		
		strBtn=(Button)v.findViewById(R.id.button1);
		strBtn.setOnClickListener(new clickhandler());
		return v;
	}
	class clickhandler implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String[] token=addr.split(":");
			
			Uri video=Uri.parse("rtsp://"+token[1]+":8086/");
			videoView.setVideoURI(video);
			videoView.requestFocus();
			videoView.start();
		}
		
	}

}

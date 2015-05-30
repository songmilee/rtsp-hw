package com.example.c3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

public class FragMain extends Activity {
	Button send;
	ListView listview;
	EditText message;
	String name;
	
	Socket soc;
	int port=9999;
	PrintWriter cpw;
	BufferedReader cbr;
	SocketHandler sh;
	
	//list
	ArrayList<String>list;
	ArrayAdapter<String> adapter;
	
	String addr;
	Button btn;
	VideoView videoView;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);	
		Intent i=getIntent();
		addr=i.getStringExtra("id");
		name=i.getStringExtra("name");
		//Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
		
		videoView=(VideoView)findViewById(R.id.vid);
		btn=(Button)findViewById(R.id.strb);
		btn.setOnClickListener(new Click());
		

		list=new ArrayList<String>();
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
		send=(Button)findViewById(R.id.send);
		message=(EditText)findViewById(R.id.message);
		listview=(ListView)findViewById(R.id.chatting);
		listview.setAdapter(adapter);
		
		send.setOnClickListener(new ClickHandler());
		adapter.notifyDataSetChanged();
		
		sh=new SocketHandler();
		sh.start();
	}
	class ClickHandler implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String sndmsg=name+" : "+message.getText().toString();
			Log.i("blalbla", "abcd");
			list.add(sndmsg);
			listview.smoothScrollToPosition(list.size());
			cpw.println(sndmsg);
			message.setText("");
			adapter.notifyDataSetChanged();
		}
		
	}
	class SocketHandler extends Thread{
		public void run()
		{
			try{
				soc=new Socket("192.168.25.6", port);
				cpw=new PrintWriter(soc.getOutputStream(),true);
				cbr=new BufferedReader(new InputStreamReader(soc.getInputStream()));
				String msg;
				while((msg=cbr.readLine())!=null)
				{
					list.add(msg);
					runOnUiThread(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							adapter.notifyDataSetChanged();
						}
						
					});
				}			
			}catch(Exception e){
				Log.i("myTag", e.toString());
			
			}
		}
	}
	class Click implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Uri video=Uri.parse("rtsp://"+addr+":8086/");
			videoView.setVideoURI(video);
			videoView.requestFocus();
			videoView.start();
		}
		
	}
}

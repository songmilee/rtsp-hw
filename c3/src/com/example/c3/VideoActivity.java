package com.example.c3;

import net.majorkernelpanic.streaming.Session;
import net.majorkernelpanic.streaming.SessionBuilder;
import net.majorkernelpanic.streaming.audio.AudioQuality;
import net.majorkernelpanic.streaming.gl.SurfaceView;
import net.majorkernelpanic.streaming.video.VideoQuality;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends Activity/** implements Callback */ implements net.majorkernelpanic.streaming.Session.Callback, Callback{
	SurfaceView mSurfaceView;
	Session mSession;
	VideoView videoview;
	Button strbtn;
	Button minebtn;
	String clientinfo;
	protected void onCreate(Bundle savedonState){
		super.onCreate(savedonState);
		setContentView(R.layout.activity_view);
		
		//client 정보를 받아온다.
		Intent i=getIntent();
		clientinfo=i.getStringExtra("clientinformation");
		//Toast.makeText(getApplicationContext(), clientinfo, Toast.LENGTH_LONG).show();
		
		videoview=(VideoView)findViewById(R.id.anotherview);
		strbtn=(Button)findViewById(R.id.startbtn);
		minebtn=(Button)findViewById(R.id.mine);
		mSurfaceView=(SurfaceView)findViewById(R.id.new_preview);
		
		//자신의 영상을 내보낸다.
		mSurfaceView.getHolder().addCallback(this);
		mSession=SessionBuilder.getInstance()
				.setCallback(this)
				.setSurfaceView(mSurfaceView)
				.setContext(getApplicationContext())
				.setAudioEncoder(SessionBuilder.AUDIO_NONE)
				.setAudioQuality(new AudioQuality(16000,32000))
				.setVideoEncoder(SessionBuilder.VIDEO_H264)
				.setVideoQuality(new VideoQuality(320,240,20,5000000))
				.build();
		
		//상대방 쪽의 영상을 출력
		String[] token=clientinfo.split(":");
		Uri video=Uri.parse("rtsp://"+token[1]+":"+token[2]+"/");
		videoview.setVideoURI(video);
		videoview.requestFocus();
		videoview.start();
	}
	@Override
	public void onBitrareUpdate(long bitrate) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSessionError(int reason, int streamType, Exception e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPreviewStarted() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSessionConfigured() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSessionStarted() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSessionStopped() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}
}
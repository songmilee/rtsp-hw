package com.example.c3;

import net.majorkernelpanic.streaming.Session;
import net.majorkernelpanic.streaming.Session.Callback;
import net.majorkernelpanic.streaming.SessionBuilder;
import net.majorkernelpanic.streaming.audio.AudioQuality;
import net.majorkernelpanic.streaming.gl.SurfaceView;
import net.majorkernelpanic.streaming.video.VideoQuality;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;

public class Rtsp extends Fragment implements Callback, android.view.SurfaceHolder.Callback {
	SurfaceView mSurfaceView;
	Session mSession;
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View v =inflater.inflate(R.layout.frag_surf, container, false);
		mSurfaceView=(SurfaceView)v.findViewById(R.id.new_preview);
		
		mSession=SessionBuilder.getInstance()
				.setCallback(this)
				.setSurfaceView(mSurfaceView)
				.setContext(getActivity())
				.setAudioEncoder(SessionBuilder.AUDIO_NONE)
				.setAudioQuality(new AudioQuality(16000,32000))
				.setVideoEncoder(SessionBuilder.VIDEO_H264)
				.setVideoQuality(new VideoQuality(320,240,20,5000000))
				.build();
		mSurfaceView.getHolder().addCallback(this);
		
		return v;
		
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
		mSession.startPreview();
		
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		mSession.stop();
	}
}

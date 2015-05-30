package com.example.c3;

import net.majorkernelpanic.streaming.rtsp.RtspServer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText edt_id;
	EditText edt_name;
	String name;
	String id;
	Button startbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.startService(new Intent(this,RtspServer.class));
		edt_id=(EditText)findViewById(R.id.id);
		edt_name=(EditText)findViewById(R.id.name);
		startbtn=(Button)findViewById(R.id.startbtn);
		startbtn.setOnClickListener(new ClickHandler());
		
	}
	class ClickHandler implements OnClickListener{
		public void onClick(View v){
			Intent i=new Intent(getApplicationContext(), FragMain.class);
			id=edt_id.getText().toString();
			name=edt_name.getText().toString();
			i.putExtra("id", id);
			i.putExtra("name", name);
			startActivity(i);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

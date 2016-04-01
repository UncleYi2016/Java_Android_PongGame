package com.example.java_android_ponggame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PongGame extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pong_game);
		PongDrawingView pdv = (PongDrawingView)findViewById(R.id.drawView);
		
	}
	
	protected void onResume(){
		super.onResume();
		PongDrawingView pdv = (PongDrawingView)findViewById(R.id.drawView);
		pdv.startTicker();
	}
	
	protected void onPause(){
		super.onPause();
		PongDrawingView pdv = (PongDrawingView)findViewById(R.id.drawView);
		pdv.stopTicker();
	}
}

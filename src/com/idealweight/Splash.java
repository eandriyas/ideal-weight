package com.idealweight;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_layout);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
					
					
				} catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent i = new Intent("com.idealweight.MENU");
					startActivity(i);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

}

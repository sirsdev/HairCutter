package com.sirsdev.haircutter;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;


public class HairCutter extends Activity {

	Vibrator vibro;
	ToggleButton stopStartButton;
	boolean running=false;
	long[] infiniteLoopPattern = {0,60000,0,60000};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibro = (Vibrator)  getSystemService(Context.VIBRATOR_SERVICE);
        stopStartButton = (ToggleButton) findViewById(R.id.StopStartButton);
        stopStartButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
				vibro.vibrate(infiniteLoopPattern,0);
		    	running=true;
		    	}else{
		    		vibro.cancel();
		    		running=false;
		    	}
				}
			});
     
    }
    
     @Override
    protected void onDestroy() {
    	super.onDestroy();
    	vibro.cancel();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	vibro.cancel();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

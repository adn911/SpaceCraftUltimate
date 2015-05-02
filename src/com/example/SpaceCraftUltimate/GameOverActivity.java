package com.example.SpaceCraftUltimate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends Activity implements OnClickListener{
    
	Button replay;
	Button quit;
	TextView view;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	    setContentView(R.layout.gameover);
	    
	    float score=getIntent().getFloatExtra("score",0);
	    
	    view=(TextView) findViewById(R.id.textView2);
	    view.setText("YOUR SCORE "+score);
	    
	    replay=(Button) findViewById(R.id.button1);
	    replay.setOnClickListener(this);
	    
	    quit=(Button) findViewById(R.id.button2);
	    quit.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v==replay)
		{   
			this.finish();
			Intent i=new Intent(this,GameActivity.class);
			startActivity(i);
			
		}
		
		else if(v==quit)
		{
			this.finish();
			
		}
	}
	
	

}

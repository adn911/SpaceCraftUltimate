package com.example.SpaceCraftUltimate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    private Button startbtn;
    private Button exitbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.startpage);

        SoundEffect.initSounds(this);

        startbtn = (Button) findViewById(R.id.button1);
        startbtn.setOnClickListener(this);

        exitbtn = (Button) findViewById(R.id.button2);
        exitbtn.setOnClickListener(this);
    }


    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

        SoundEffect.release();
    }


    @Override
    public void onClick(View view) {

        if (view == startbtn) {
            Intent game = new Intent(this.getApplicationContext(), GameActivity.class);
            startActivity(game);
            SoundEffect.fireSound();
        } else if (view == exitbtn) {
            SoundEffect.fireSound();
            finish();
        }
    }


}

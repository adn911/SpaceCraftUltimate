package com.example.SpaceCraftUltimate;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;


public class GameActivity extends Activity {

    private GameView view;
    public static int HEIGHT, WIDTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        HEIGHT = getWindowManager().getDefaultDisplay().getHeight();
        WIDTH = getWindowManager().getDefaultDisplay().getWidth();

        SoundEffect.initSounds(this);

        view = new GameView(this);
        setContentView(view);

    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
        SoundEffect.initSounds(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

        SoundEffect.release();
    }


    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.activity_game, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        super.onOptionsItemSelected(item);


        switch (item.getItemId()) {
            case R.id.menu: {


            }

            case R.id.togglestate: {

                if (Game.state == GameState.INGAME) {

                } else if (Game.state == GameState.PAUSED) {


                }

                break;
            }

            case R.id.restart: {


            }


        }

        return true;

    }


}

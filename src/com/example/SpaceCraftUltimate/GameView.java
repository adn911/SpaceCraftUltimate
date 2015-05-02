package com.example.SpaceCraftUltimate;

import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GameView extends SurfaceView implements SurfaceHolder.Callback, SensorEventListener {

    private static GameActivity activity;
    private final static int fps = 30;
    private SurfaceHolder holder;
    public static boolean running;
    private GameThread thread;
    private Canvas canvas;
    private Game game;
    private SensorManager mSensorManager;


    public GameView(GameActivity activity) {
        super(activity);

        this.activity = activity;
        holder = this.getHolder();
        holder.addCallback(this);

        mSensorManager = (SensorManager) activity.getSystemService(activity.SENSOR_SERVICE);
        game = new Game(activity);
        this.setFocusable(true);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        //start the Game and GameThread
        Log.d("Surface", "Surface Created!");

        if (!mSensorManager.getSensorList(Sensor.TYPE_ORIENTATION).isEmpty())
            mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), mSensorManager.SENSOR_DELAY_FASTEST);

        else if (!mSensorManager.getSensorList(Sensor.TYPE_ROTATION_VECTOR).isEmpty()) {
            mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR), mSensorManager.SENSOR_DELAY_FASTEST);

        }

        game.startGame();

        thread = new GameThread();
        thread.start();

        running = true;
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

        Log.d("Surface", "Surface Changed!");
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("Surface", "Surface Destroyed!");

        mSensorManager.unregisterListener(this);
        running = false;
    }


    //Update Game logic
    synchronized void update() {
        game.updateGame();
    }


    //Render game display to screen
    public void Draw() {
        canvas = holder.lockCanvas(null);

        if (canvas != null) {
            game.drawGame(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == event.ACTION_DOWN)
            game.ship.Fire();

        return super.onTouchEvent(event);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            Log.d("Key", "KeyPressed!");

            switch (keyCode) {

                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    game.ship.MoveX(1);
                    break;

                case KeyEvent.KEYCODE_DPAD_LEFT:
                    game.ship.MoveX(-1);
                    break;

                case KeyEvent.KEYCODE_DPAD_UP:
                    game.ship.MoveY(-1);
                    break;

                case KeyEvent.KEYCODE_DPAD_DOWN:
                    game.ship.MoveY(1);
                    break;

                case KeyEvent.KEYCODE_DPAD_CENTER:
                    game.ship.Fire();
                    break;

                case KeyEvent.KEYCODE_ENTER:
                    if (game.state == GameState.INGAME) pause();
                    else if (game.state == GameState.PAUSED) resume();
                    break;

                case KeyEvent.KEYCODE_BACK: {

                    running = false;

                    activity.finish();
                }
            }
        }

        return super.onKeyDown(keyCode, event);
    }


    public static void pause() {

        if (Game.state == GameState.INGAME) {
            Game.state = GameState.PAUSED;
            SoundEffect.release();
        }
    }


    public static void resume() {

        if (Game.state == GameState.PAUSED) {
            Game.state = GameState.INGAME;
            SoundEffect.initSounds(activity);
        }
    }


    //The Game Thread
    class GameThread extends Thread {

        public void run() {

            while (running) {

                long sTime = System.nanoTime();

                GameView.this.update();
                GameView.this.Draw();

                long eTime = System.nanoTime();
                long timeDiff = (eTime - sTime) / 1000000;

                //Log.d("time", " "+timeDiff);
                try {

                    if ((1000 / fps - timeDiff) < 0)
                        Thread.sleep(5);
                    else
                        Thread.sleep(1000 / fps - timeDiff);

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // TODO Auto-generated method stub

        if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            float pitch = event.values[0];
            float roll = event.values[2];

            if (roll > 2) game.ship.MoveX(-2);
            else if (roll < -2) game.ship.MoveX(2);

            if (pitch > 2) game.ship.MoveY(-2);
            else if (pitch < -2) game.ship.MoveY(2);

        } else if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
            float pitch = event.values[1];
            float roll = event.values[2];

            if (roll > 2) game.ship.MoveX(-2);
            else if (roll < -2) game.ship.MoveX(2);

            if (pitch > 2) game.ship.MoveY(-2);
            else if (pitch < -2) game.ship.MoveY(2);
        }
    }

}

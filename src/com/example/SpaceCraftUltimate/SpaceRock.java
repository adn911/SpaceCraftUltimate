package com.example.SpaceCraftUltimate;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class SpaceRock extends GameObject {

    float scalingFactor;
    int movingSpeed;
    ArrayList<Bitmap> frames;
    boolean destroyed;

    SpaceRock(GameActivity activity, float x, float y, int speed, float scale) {
        this.x = x;
        this.y = y;
        this.movingSpeed = speed;
        this.scalingFactor = scale;

        setFrames();
        setImage(frames.get(0));

        destroyed = false;
        visible = true;
    }


    void setFrames() {
        frames = new ArrayList<Bitmap>();

        Bitmap bmp = BitmapFactory.decodeResource(activity.getResources(), R.drawable.rock);
        frames.add(Bitmap.createScaledBitmap(bmp, (int) (bmp.getWidth() * this.scalingFactor), (int) (bmp.getHeight() * this.scalingFactor), false));

        bmp = BitmapFactory.decodeResource(activity.getResources(), R.drawable.explossion);
        frames.add(Bitmap.createScaledBitmap(bmp, (int) (bmp.getWidth() * this.scalingFactor * 1.5), (int) (bmp.getHeight() * this.scalingFactor * 1.5), false));

    }


    void Move() {

        y += movingSpeed;

        if (y > GameActivity.HEIGHT) y = -100;

    }

    void destroy() {
        destroyed = true;

        setImage(frames.get(1));
    }

    boolean isDestroyed() {
        return destroyed;
    }


}

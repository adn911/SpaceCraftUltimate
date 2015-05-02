package com.example.SpaceCraftUltimate;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Enemy extends GameObject {

    float movingSpeed;
    ArrayList<Bitmap> frames;
    boolean destroyed;
    int type;

    Enemy(GameActivity activity, float x, float y, float speed, int type) {
        // TODO Auto-generated constructor stub

        this.x = x;
        this.y = y;
        this.type = type;


        this.setFrames();

        if (type == 1) this.setImage(frames.get(0));
        if (type == 2) this.setImage(frames.get(1));

        this.movingSpeed = speed;
        this.visible = true;
    }

    void setFrames() {
        frames = new ArrayList<Bitmap>();


        Bitmap bmp = BitmapFactory.decodeResource(activity.getResources(), R.drawable.enemy1);
        frames.add(bmp);

        bmp = BitmapFactory.decodeResource(activity.getResources(), R.drawable.enemy2);
        frames.add(bmp);

        bmp = BitmapFactory.decodeResource(activity.getResources(), R.drawable.explossion);
        frames.add(bmp);

    }


    public void Move() {
        y += this.movingSpeed;

        if (y > GameActivity.HEIGHT)
            y = -100;
    }

    int getType() {
        return type;
    }

    void destroy() {
        this.destroyed = true;

        setImage(frames.get(2));

    }

    boolean isDestroyed() {
        return destroyed;
    }

}

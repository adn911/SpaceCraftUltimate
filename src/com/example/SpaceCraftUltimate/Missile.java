package com.example.SpaceCraftUltimate;

import android.graphics.BitmapFactory;

public class Missile extends GameObject {

    int type;
    int power;
    final float speedy = 8;

    Missile(GameActivity activity, float x, float y, int type) {
        this.activity = activity;
        // TODO Auto-generated constructor stub
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = speedy;
        this.type = type;

        setFrames();

        if (type == 1) power = 10;
        if (type == 2) power = 15;

        visible = true;
    }


    public void setFrames() {
        if (type == 0)
            setImage(BitmapFactory.decodeResource(activity.getResources(), R.drawable.bullet));

        else if (type == 1) {
            setImage(BitmapFactory.decodeResource(activity.getResources(), R.drawable.missile));
        } else if (type == 2) {
            setImage(BitmapFactory.decodeResource(activity.getResources(), R.drawable.missile2));

        }
    }

    //@Override

    void Move() {
        if (y < 0 || y > GameActivity.HEIGHT)
            visible = false;
        else {
            if (type == 0)
                y -= dy;

            else y += dy;

        }
    }

    int getPower() {
        return power;
    }


}

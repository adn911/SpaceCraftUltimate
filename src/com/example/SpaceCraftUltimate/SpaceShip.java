package com.example.SpaceCraftUltimate;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class SpaceShip extends GameObject {

    ArrayList<Missile> missiles;
    ArrayList<Bitmap> frames;
    int life = 100;
    boolean destroyed;

    SpaceShip(GameActivity activity, float x, float y) {
        this.x = x;
        this.y = y;
        this.dx = 2;
        this.dy = 2;

        setFrames();
        setImage(frames.get(0));

        missiles = new ArrayList<Missile>();

        visible = true;
    }


    void setFrames() {

        frames = new ArrayList<Bitmap>();

        frames.add(BitmapFactory.decodeResource(activity.getResources(), R.drawable.ship2));
        frames.add(BitmapFactory.decodeResource(activity.getResources(), R.drawable.explossion));

    }

    void MoveX(int dir) {
        if (x + dx * dir >= 0 && x + dx * dir <= (GameActivity.WIDTH - this.width))
            x += dx * dir;

    }

    void MoveY(int dir) {
        if (y + dy * dir >= 0 && y + dy * dir <= (GameActivity.HEIGHT - this.height))
            y += dy * dir;
    }


    void Fire() {

        missiles.add(new Missile(activity, this.x + this.width / 3, this.y - this.height, 0));
        missiles.add(new Missile(activity, this.x - this.width / 3, this.y - this.height, 0));

        SoundEffect.fireSound();

    }

    ArrayList<Missile> getMissiles() {
        return missiles;
    }

    boolean isDestroyed() {
        return destroyed;
    }

    void setLife(int life) {
        this.life = life;
    }

    int getLife() {
        return life;
    }

    void destroy() {
        this.destroyed = true;
        this.setImage(frames.get(1));
    }

}

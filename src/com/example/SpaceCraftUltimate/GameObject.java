package com.example.SpaceCraftUltimate;

import android.graphics.Bitmap;
import android.graphics.RectF;

public abstract class GameObject {

    protected GameActivity activity;
    protected float x, y;
    protected float dx, dy;
    protected Bitmap img;
    protected float height, width;
    protected boolean visible;

    public GameObject() {
    }

    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    void setX(float x) {
        this.x = x;
    }

    float getX() {
        return x;
    }

    void setY(float y) {
        this.y = y;
    }

    float getY() {
        return y;
    }

    float getWidth() {
        return width;
    }

    float getHeight() {
        return height;
    }


    boolean isVisible() {
        return visible;
    }

    void setVisible(boolean vis) {
        this.visible = vis;
    }

    void setImage(Bitmap img) {
        this.img = img;

        this.height = img.getHeight();
        this.width = img.getWidth();
    }

    Bitmap getImage() {
        return img;
    }

    RectF getBounds() {
        return new RectF(x, y, x + width, y + height);
    }

}

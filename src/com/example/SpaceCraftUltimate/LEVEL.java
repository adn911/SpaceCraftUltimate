package com.example.SpaceCraftUltimate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class LEVEL {

    static Bitmap background;
    static float rockPos[][];
    static float enemyPos[][];

    public static void Level01(Context con) {
        float h = GameActivity.HEIGHT;
        float w = GameActivity.WIDTH;


        background = BitmapFactory.decodeResource(con.getResources(), R.drawable.space);
        background = Bitmap.createScaledBitmap(background, (int) w, (int) h * 2, false);


        float rock[][] = {{(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
        };


        float enemy[][] = {{(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 4), 1},
        };


        rockPos = rock;
        enemyPos = enemy;

    }

    public static void Level02(Context con) {
        float h = GameActivity.HEIGHT;
        float w = GameActivity.WIDTH;


        background = BitmapFactory.decodeResource(con.getResources(), R.drawable.space2);
        background = Bitmap.createScaledBitmap(background, (int) w, (int) h * 2, false);

        float rock[][] = {{(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}
        };


        float enemy[][] = {{(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 4), 2},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 2}
        };


        rockPos = rock;
        enemyPos = enemy;
    }

    public static void Level03(Context con) {
        float h = GameActivity.HEIGHT;
        float w = GameActivity.WIDTH;

        background = BitmapFactory.decodeResource(con.getResources(), R.drawable.space3);
        background = Bitmap.createScaledBitmap(background, (int) w, (int) h * 2, false);

        float rock[][] = {{(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
        };


        float enemy[][] = {{(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 4), 1},
        };

        rockPos = rock;
        enemyPos = enemy;
    }

    public static void Level04(Context con) {
        float h = GameActivity.HEIGHT;
        float w = GameActivity.WIDTH;

        background = BitmapFactory.decodeResource(con.getResources(), R.drawable.space5);
        background = Bitmap.createScaledBitmap(background, (int) w, (int) h * 2, false);

        float rock[][] = {{(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), 1},
        };


        float enemy[][] = {{(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1},
                {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 3), 1}, {(float) (w * Math.random() * 5 / 5), -(float) (Math.random() * h * 5), (float) (3 + Math.random() * 4), 1},
        };

        rockPos = rock;
        enemyPos = enemy;
    }

    public static float[][] getEnemyPos() {

        return enemyPos;
    }

    public static float[][] getRockPos() {

        return rockPos;
    }

    public static Bitmap getBackground() {
        return background;
    }
}

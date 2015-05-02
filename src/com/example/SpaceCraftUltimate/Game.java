package com.example.SpaceCraftUltimate;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Game {

    static GameState state;
    GameActivity activity;
    float HEIGHT = GameActivity.HEIGHT;
    float WIDTH = GameActivity.WIDTH;


    float backgroundx, backgroundy, points;

    SpaceShip ship;
    ArrayList<Missile> missiles;
    ArrayList<Missile> eMissiles;
    ArrayList<SpaceRock> rocks;
    ArrayList<Enemy> enemy;

    int level;

    Timer t1;
    Bitmap background;


    public Game(GameActivity activity) {

        this.activity = activity;


    }

    //start/restart the game
    void startGame() {

        ship = new SpaceShip(activity, WIDTH / 2 - 20, HEIGHT - 100);

        missiles = ship.getMissiles();
        eMissiles = new ArrayList<Missile>();
        enemy = new ArrayList<Enemy>();
        rocks = new ArrayList<SpaceRock>();

        level = 1;
        points = 0;

        initLevel();

        SoundEffect.initSounds(activity);
        SoundEffect.backgroundMusic();

        state = GameState.INGAME;

    }


    //initialize Level Informations
    void initLevel() {

        if (level == 1) LEVEL.Level01(activity);
        if (level == 2) LEVEL.Level02(activity);
        if (level == 3) LEVEL.Level03(activity);
        if (level == 4) LEVEL.Level04(activity);

        background = LEVEL.getBackground();

        float rockpos[][] = LEVEL.getRockPos();
        float enemypos[][] = LEVEL.getEnemyPos();


        Random rand = new Random();


        for (int i = 0; i < rockpos.length; i++) {
            rocks.add(new SpaceRock(activity, rockpos[i][0], rockpos[i][1], (int) (2 + rand.nextFloat() * 5), (float) (0.2 + rand.nextFloat() * 0.8)));
        }


        for (int i = 0; i < enemypos.length; i++) {
            enemy.add(new Enemy(activity, enemypos[i][0], enemypos[i][1], enemypos[i][2], (int) enemypos[i][3]));
        }


        t1 = new Timer();
        t1.schedule(new EnemyFire(), 3000, 500);


        backgroundx = 0;
        backgroundy = -background.getHeight() / 2;


    }


    //Check for any Collision events
    void checkCollision() {


        for (int i = 0; i < rocks.size(); i++) {
            SpaceRock rock = rocks.get(i);

            for (int j = 0; j < missiles.size(); j++) {
                Missile m = missiles.get(j);

                if (m.getBounds().intersect(rock.getBounds())) {
                    //Log.d("collisssion Test","Collission");


                    if (!rock.isDestroyed()) {
                        rock.destroy();
                        SoundEffect.CollissionSound();
                        points += 50;

                        //SoundEffect.CollissionSound(activity);
                    }

                    m.setVisible(false);
                }
            }


            if (ship.getBounds().intersect(rock.getBounds())) {
                rock.destroy();
                ship.destroy();
            }


        }


        for (int i = 0; i < enemy.size(); i++) {
            Enemy e = enemy.get(i);

            for (int j = 0; j < missiles.size(); j++) {
                Missile m = missiles.get(j);

                if (m.getBounds().intersect(e.getBounds())) {
                    //Log.d("collisssion Test","Collission");


                    if (!e.isDestroyed()) {
                        e.destroy();
                        points += 50;

                        SoundEffect.CollissionSound();
                    }

                    m.setVisible(false);
                }

            }


            if (e.getBounds().intersect(ship.getBounds())) {
                e.destroy();
                ship.destroy();
                SoundEffect.CollissionSound();
            }


        }


        for (int i = 0; i < eMissiles.size(); i++) {
            Missile em = eMissiles.get(i);

            if (em.getBounds().intersect(ship.getBounds())) {
                em.setVisible(false);
                ship.setLife(ship.getLife() - em.getPower());

                if (ship.getLife() <= 0) {
                    ship.destroy();
                    SoundEffect.playSound(activity, SoundEffect.S2);
                }

                eMissiles.remove(i);
            }

        }


    }


    public void updateGame() {


        if (!ship.isVisible()) {

            state = GameState.GAMEOVER;

            gameOver();
        }


        if (state == GameState.INGAME) {
            moveBackground();
            checkCollision();


            for (int i = 0; i < missiles.size(); i++) {
                Missile m = missiles.get(i);

                if (m.isVisible())
                    m.Move();

                else missiles.remove(i);
            }


            for (int i = 0; i < eMissiles.size(); i++) {
                Missile m = eMissiles.get(i);

                if (m.isVisible()) {
                    m.Move();
                    //Log.d("XY",rock.getX()+" "+rock.getY());
                } else eMissiles.remove(i);
            }

            for (int i = 0; i < enemy.size(); i++) {
                Enemy e = enemy.get(i);

                if (e.isVisible()) {
                    e.Move();

                } else enemy.remove(i);
            }


            for (int i = 0; i < rocks.size(); i++) {
                SpaceRock rock = rocks.get(i);

                if (rock.isVisible()) {
                    rock.Move();
                    //Log.d("XY",rock.getX()+" "+rock.getY());
                } else rocks.remove(i);
            }


            if (enemy.size() == 0) {
                level = level % 4 + 1;
                initLevel();
            }


        }


    }


    private void gameOver() {
        // TODO Auto-generated method stub

        t1.cancel();
        GameView.running = false;


        Intent i = new Intent(activity, GameOverActivity.class);
        i.putExtra("score", points);


        activity.finish();
        activity.startActivity(i);


    }

    public void drawGame(Canvas canvas) {

        if (state == GameState.INGAME) {

            canvas.drawColor(Color.BLACK);


            canvas.drawBitmap(background, backgroundx, backgroundy, null);

            if (ship.isVisible())
                canvas.drawBitmap(ship.getImage(), ship.getX() - ship.getWidth() / 2, ship.getY() - ship.getHeight() / 2, null);


            Paint paint = new Paint();
            paint.setColor(Color.RED);

            canvas.drawText("Enemy left: " + enemy.size(), GameActivity.WIDTH / 20, GameActivity.HEIGHT * 2 / 50, paint);
            canvas.drawText("Points: " + points, GameActivity.WIDTH / 20, GameActivity.HEIGHT * 3 / 50, paint);
            canvas.drawText("Life " + ship.getLife(), GameActivity.WIDTH / 20, GameActivity.HEIGHT * 47 / 50, paint);
            canvas.drawText("Level " + level, GameActivity.WIDTH / 20, GameActivity.HEIGHT * 46 / 50, paint);


            if (ship.isDestroyed()) ship.setVisible(false);


            ArrayList<Missile> missiles = ship.getMissiles();

            for (int i = 0; i < missiles.size(); i++) {
                Missile m = missiles.get(i);

                if (m.isVisible())
                    canvas.drawBitmap(m.getImage(), m.getX(), m.getY(), null);
            }


            for (int i = 0; i < enemy.size(); i++) {
                Enemy e = enemy.get(i);

                if (e.isVisible())
                    canvas.drawBitmap(e.getImage(), e.getX(), e.getY(), null);

                if (e.isDestroyed())
                    e.setVisible(false);
            }


            for (int i = 0; i < eMissiles.size(); i++) {
                Missile m = eMissiles.get(i);

                if (m.isVisible())
                    canvas.drawBitmap(m.getImage(), m.getX(), m.getY(), null);
            }


            for (int i = 0; i < rocks.size(); i++) {
                SpaceRock rock = rocks.get(i);

                if (rock.isVisible())
                    canvas.drawBitmap(rock.getImage(), rock.getX(), rock.getY(), null);

                if (rock.isDestroyed())
                    rock.setVisible(false);
            }


        }


    }


    void moveBackground() {
        backgroundy += 4;

        if ((backgroundy + background.getHeight() / 2) >= GameActivity.HEIGHT)
            backgroundy = -background.getHeight() / 2;
    }


    void enemyFire() {
        for (int i = 0; i < enemy.size(); i++) {

            Enemy e = enemy.get(i);

            if ((e.getX() >= ship.getX() && e.getX() <= ship.getX() + ship.getWidth()) ||
                    (ship.getX() >= e.getX() && ship.getX() <= e.getX() + e.getWidth()) && ship.getY() - e.getY() <= HEIGHT * 2 / 3) {
                if (e.isVisible()) {

                    Log.d("eFire", "eMissile");

                    Missile em = new Missile(activity, 0, 0, e.getType());
                    em.setX(e.getX() + (e.getWidth() - em.getWidth()) / 2);
                    em.setY(e.getY() + e.height);

                    eMissiles.add(em);
                }
            }


        }
    }


    class EnemyFire extends TimerTask {

        @Override
        public void run() {

            if (Game.state == GameState.INGAME)
                Game.this.enemyFire();

        }

    }

}

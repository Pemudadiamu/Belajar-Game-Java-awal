
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package belajargame;

import entity.player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import object.superObject;
import tile.tileManager;

/**
 *
 * @author ridho
 */
public class GamePanel extends JPanel implements Runnable {
    // Settingan layar

    final int originalTileSize = 16; // 16x16 pixels tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;// 48x48 tile
    public final int maxScreenCol = 16;// berapa kolom maks di layar horizontal
    public final int maxScreenRow = 12;// kolom mak vert
    public final int screenWidth = tileSize * maxScreenCol;// 768pix
    public final int screenHeight = tileSize * maxScreenRow;// 576 pix

    Thread gameThread;
    // komponen dan mekanik game
    keyHandler kh = new keyHandler();
    public player Player = new player(this, kh);
    public tileManager tm = new tileManager(this);
    public collisionChecker cc = new collisionChecker(this);
    public AssetManager am = new AssetManager(this);
    public superObject obj[] = new superObject[11];// 10 item di layar konkuren
    public sound sound = new sound();

    // world setting
    public final int maxWorldCol = 60;
    public final int maxWorldRow = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);// better rendering perf
        this.addKeyListener(kh);
        this.setFocusable(true);
    }

    public void setupObj() {
        am.setObject();
        playSound(0);
    }

    // fps
    int fps = 60;

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // @Override
    // public void run() {
    // double drawIntervals = 1000000000/fps; //0,1666666 hasilnya
    // double nextDrawTime = System.nanoTime() + drawIntervals;
    //
    //
    // while(gameThread != null){
    //
    // long currentTime = System.nanoTime();
    // System.out.println(currentTime);
    //
    // //update info
    // update();
    //
    // //draw paintComponent
    // repaint();//emang gitu cara manggil nya paintComponent
    //
    // try{
    // double remainingTime = currentTime - System.nanoTime();
    // remainingTime = remainingTime/1000000;
    //
    // if(remainingTime < 0){
    // remainingTime = 0;
    // }
    // Thread.sleep((long) remainingTime);
    // nextDrawTime += drawIntervals;
    // }
    //
    // catch(InterruptedException e){
    // e.printStackTrace();
    // }
    //
    // }
    // }
    // ini pake namanya algoritma sleep (thread sleep)
    @Override
    public void run() {

        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer == 1000000000) {
                System.out.println("FPS : " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }

    public void update() {
        Player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // tile
        tm.draw(g2);

        // objek
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }
        // player
        Player.draw(g2);
        g2.dispose();// baca penejelasan nya,simple nya ini buat nge hemt penggunaan memori
    }

    public void playSound(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopSound(int i) {
        sound.stop();
    }

    public void playSFX(int i) {
        sound.setFile(i);
        sound.play();
    }

}

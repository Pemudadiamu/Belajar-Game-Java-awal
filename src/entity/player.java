/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import belajargame.GamePanel;
import belajargame.keyHandler;
// import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ridho
 */
public class player extends entity {
    GamePanel gp;
    keyHandler kh;
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    public long startTime = System.currentTimeMillis();

    public player(GamePanel gp, keyHandler kh) {
        this.gp = gp;
        this.kh = kh;
        setDefaultValues();
        getPlayerImage();
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2) - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 14;
        worldY = gp.tileSize * 35;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/model_belakang1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/model_belakang2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/model_depan1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/model_depan2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/model_kiri1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/model_kiri2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/model_kanan1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/model_kanan2.png"));
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (kh.downPressed == true || kh.upPressed == true || kh.leftPressed == true || kh.rightPressed == true) {
            if (kh.upPressed == true) {
                direction = "up";

            } else if (kh.downPressed == true) {
                direction = "down";

            } else if (kh.leftPressed == true) {
                direction = "left";

            }
            if (kh.rightPressed == true) {
                direction = "right";

            }

            // cek collition nya
            collisionOn = false;
            gp.cc.checkTile(this);

            // cek collision objek
            int objIndex = gp.cc.checkObj(this, true);
            pickObj(objIndex);

            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;

            if (spriteCounter > 6) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickObj(int index) {
        if (index != 999) {
            String objName = gp.obj[index].name;

            switch (objName) {
                case "key":
                    gp.playSFX(1);
                    hasKey++;
                    gp.obj[index] = null;
                    System.out.println("Key : " + hasKey);
                    break;
                case "door":
                    if (hasKey > 0) {
                        gp.playSFX(3);
                        hasKey--;
                        gp.obj[index] = null;
                        System.out.println("Key : " + hasKey);
                    }

                    // if(hasKey == 0){
                    // System.out.println("You don't have a key to open the ");
                    // }
                    break;

                case "boots":
                    gp.playSFX(2);
                    speed += 1;
                    gp.obj[index] = null;
                    break;
                case "chest":
                    gp.playSFX(4);
                    // gp.obj[index] = null;
                    System.out.println("Game Selesai!");
                    long estimatedTime = System.currentTimeMillis() - startTime;
                    long sekon = estimatedTime / 1000;
                    System.out.println("Waktu Game Selesai : " + sekon + " Detik");
                    System.exit(0);
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package belajargame;

import object.chest;
import object.door;

/**
 *
 * @author ridho
 */
public class AssetManager {
  GamePanel gp;

  public AssetManager(GamePanel gp) {
    this.gp = gp;
  }

  public void setObject() {
    gp.obj[0] = new chest();
    gp.obj[0].worldX = 30 * gp.tileSize;
    gp.obj[0].worldY = 30 * gp.tileSize;

    gp.obj[1] = new door();
    gp.obj[1].worldX = 13 * gp.tileSize;
    gp.obj[1].worldY = 28 * gp.tileSize;

    gp.obj[2] = new door();
    gp.obj[2].worldX = 13 * gp.tileSize;
    gp.obj[2].worldY = 30 * gp.tileSize;

    gp.obj[3] = new door();
    gp.obj[3].worldX = 46 * gp.tileSize;
    gp.obj[3].worldY = 28 * gp.tileSize;

    gp.obj[4] = new door();
    gp.obj[4].worldX = 46 * gp.tileSize;
    gp.obj[4].worldY = 30 * gp.tileSize;

    /*
     * gp.obj[2] = new door();
     * gp.obj[2].worldX = 10 * gp.tileSize;
     * gp.obj[2].worldY = 26 * gp.tileSize;
     * 
     * gp.obj[3] = new door();
     * gp.obj[3].worldX = 26 * gp.tileSize;
     * gp.obj[3].worldY = 4 * gp.tileSize;
     * 
     * gp.obj[4] = new door();
     * gp.obj[4].worldX = 4 * gp.tileSize;
     * gp.obj[4].worldY = 2 * gp.tileSize;
     * 
     * gp.obj[5] = new key();
     * gp.obj[5].worldX = 37 * gp.tileSize;
     * gp.obj[5].worldY = 14 * gp.tileSize;
     * 
     * gp.obj[6] = new key();
     * gp.obj[6].worldX = 19 * gp.tileSize;
     * gp.obj[6].worldY = 9 * gp.tileSize;
     * 
     * gp.obj[7] = new key();
     * gp.obj[7].worldX = 21 * gp.tileSize;
     * gp.obj[7].worldY = 17 * gp.tileSize;
     * 
     * gp.obj[8] = new key();
     * gp.obj[8].worldX = 4 * gp.tileSize;
     * gp.obj[8].worldY = 22 * gp.tileSize;
     * 
     * gp.obj[9] = new boots();
     * gp.obj[9].worldX = 54 * gp.tileSize;
     * gp.obj[9].worldY = 42 * gp.tileSize;
     * 
     * gp.obj[10] = new duck();
     * gp.obj[10].worldX = 14 * gp.tileSize;
     * gp.obj[10].worldY = 26 * gp.tileSize;
     * }
     */
  }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import belajargame.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author ridho
 */
public class superObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX,worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48) ;
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    
    public void draw(Graphics2D g2,GamePanel gp){
           int screenX = worldX - gp.Player.worldX + gp.Player.screenX;
           int screenY = worldY - gp.Player.worldY + gp.Player.screenY;
           
//           if(worldX + gp.tileSize > gp.Player.worldX - gp.Player.screenX && worldX - gp.tileSize < gp.Player.worldX+gp.Player.screenX 
//               && worldY + gp.tileSize > gp.Player.worldY - gp.Player.screenY && worldY - gp.tileSize < gp.Player.worldY+gp.Player.screenY ){
//                 
//            }
            g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }
    
}

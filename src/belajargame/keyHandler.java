/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package belajargame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ridho
 */
public class keyHandler implements KeyListener {
    
    public boolean upPressed,downPressed,leftPressed,rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       int kode = e.getKeyCode();
       
       if(kode == KeyEvent.VK_W || kode == KeyEvent.VK_UP){
           upPressed = true;
       }
       
       if(kode == KeyEvent.VK_A || kode == KeyEvent.VK_LEFT){
           leftPressed = true;
       }
       
     if(kode == KeyEvent.VK_S || kode == KeyEvent.VK_DOWN){
           downPressed = true;
       }
       
       if(kode == KeyEvent.VK_D || kode == KeyEvent.VK_RIGHT){
           rightPressed = true;
       }
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int kode = e.getKeyCode();
       
       if(kode == KeyEvent.VK_W || kode == KeyEvent.VK_UP){
           upPressed = false;
       }
       
       if(kode == KeyEvent.VK_A || kode == KeyEvent.VK_LEFT){
           leftPressed = false;
       }
       
        if(kode == KeyEvent.VK_S || kode == KeyEvent.VK_DOWN){
           downPressed = false;
       }
       
       if(kode == KeyEvent.VK_D || kode == KeyEvent.VK_RIGHT){
           rightPressed = false;
       }
    }
    
}

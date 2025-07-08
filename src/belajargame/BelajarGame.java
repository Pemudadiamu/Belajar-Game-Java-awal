/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this licensed
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package belajargame;

import javax.swing.JFrame;

/**
 *
 * @author ridho
 */
public class BelajarGame {

    /**
     * s
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Petualangan Diki");

        GamePanel gp = new GamePanel();
        window.add(gp);

        window.pack();

        window.setLocationRelativeTo(null);// bakalan di tengah
        window.setVisible(true);

        gp.setupObj();
        gp.startGameThread();

    }

}

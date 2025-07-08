/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ridho
 */
public class key extends superObject{
    public key(){
        name = "key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

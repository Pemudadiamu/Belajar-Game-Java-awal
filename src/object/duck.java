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
public class duck extends superObject{
    public duck(){
        name = "duck";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/duck.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

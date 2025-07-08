/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import belajargame.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
// import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/**
 *
 * @author ridho
 */
public class tileManager {
    GamePanel gp;
    public tile[] tile;
    public int mapTileNum[][];

    public tileManager(GamePanel gp) {
        this.gp = gp;

        tile = new tile[100];
        getTileImage();
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        loadMap("/maps/worldMaze01.txt");
    }

    public void loadMap(String path) {

        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String lines = br.readLine();

                while (col < gp.maxWorldCol) {
                    String numbers[] = lines.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }

            }
            br.close();
        } catch (Exception e) {
        }

    }

    public void getTileImage() {
        try {
            /*
             * tile[0] = new tile();
             * tile[0].image =
             * ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
             */

            tile[12] = new tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));

            /*
             * tile[2] = new tile();
             * tile[2].image =
             * ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
             * 
             * tile[3] = new tile();
             * tile[3].image =
             * ImageIO.read(getClass().getResourceAsStream("/tiles/earth-1.png"));
             * 
             * tile[4] = new tile();
             * tile[4].image =
             * ImageIO.read(getClass().getResourceAsStream("/tiles/earth-3.png"));
             * 
             * tile[5] = new tile();
             * tile[5].image =
             * ImageIO.read(getClass().getResourceAsStream("/tiles/earth-2.png"));
             * 
             * tile[6] = new tile();
             * tile[6].image =
             * ImageIO.read(getClass().getResourceAsStream("/tiles/earth-4.png"));
             * 
             * tile[7] = new tile();
             * tile[7].image =
             * ImageIO.read(getClass().getResourceAsStream("/tiles/bridge.png"));
             * 
             * tile[8] = new tile();
             * tile[8].image =
             * ImageIO.read(getClass().getResourceAsStream("/tiles/bridge-2.png"));
             * 
             * tile[9] = new tile();
             * tile[9].image =
             * ImageIO.read(getClass().getResourceAsStream("/tiles/stone-wall.png"));
             */

            tile[11] = new tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

        }
        /*
         * public void getTileImage() {
         * try {
         * tile[0] = new tile();
         * tile[0].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand-3.png"));
         * 
         * tile[1] = new tile();
         * tile[1].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
         * 
         * tile[2] = new tile();
         * tile[2].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
         * tile[2].collition = false;
         * 
         * tile[3] = new tile();
         * tile[3].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/bridge.png"));
         * 
         * tile[4] = new tile();
         * tile[4].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
         * tile[4].collition = true;
         * 
         * tile[5] = new tile();
         * tile[5].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
         * 
         * tile[6] = new tile();
         * tile[6].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/stone.png"));
         * tile[6].collition = true;
         * 
         * tile[7] = new tile();
         * tile[7].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/stone-wall.png"));
         * tile[7].collition = false;
         * 
         * tile[8] = new tile();
         * tile[8].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/floor-1.png"));
         * 
         * tile[9] = new tile();
         * tile[9].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/floor-2.png"));
         * 
         * tile[11] = new tile();
         * tile[11].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/waLL.png"));
         * 
         * tile[12] = new tile();
         * tile[12].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand-2.png"));
         * tile[12].collition = true;
         * 
         * tile[13] = new tile();
         * tile[13].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand-4.png"));
         * tile[13].collition = true;
         * 
         * tile[14] = new tile();
         * tile[14].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand-5.png"));
         * 
         * tile[15] = new tile();
         * tile[15].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/grass-1.png"));
         * 
         * tile[16] = new tile();
         * tile[16].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
         * 
         * tile[17] = new tile();
         * tile[17].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand-1.png"));
         * 
         * tile[18] = new tile();
         * tile[18].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand-6.png"));
         * 
         * tile[19] = new tile();
         * tile[19].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand-7.png"));
         * 
         * tile[20] = new tile();
         * tile[20].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand-8.png"));
         * 
         * tile[21] = new tile();
         * tile[21].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand-9.png"));
         * 
         * tile[22] = new tile();
         * tile[22].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/sand-10.png"));
         * 
         * tile[23] = new tile();
         * tile[23].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/grass-2.png"));
         * 
         * tile[24] = new tile();
         * tile[24].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/grass-3.png"));
         * 
         * tile[25] = new tile();
         * tile[25].image =
         * ImageIO.read(getClass().getResourceAsStream("/tiles/grass-4.png"));
         * 
         * }
         */

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2) {
        int row = 0;// world col
        int col = 0;// world row

        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
            int tileNum = mapTileNum[col][row];

            int worldX = col * gp.tileSize;
            int worldY = row * gp.tileSize;
            int screenX = worldX - gp.Player.worldX + gp.Player.screenX;
            int screenY = worldY - gp.Player.worldY + gp.Player.screenY;

            // if(worldX + gp.tileSize > gp.Player.worldX - gp.Player.screenX && worldX -
            // gp.tileSize < gp.Player.worldX+gp.Player.screenX
            // && worldY + gp.tileSize > gp.Player.worldY - gp.Player.screenY && worldY -
            // gp.tileSize < gp.Player.worldY+gp.Player.screenY ){
            //
            // }
            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            col++;

            if (col == gp.maxWorldCol) {
                col = 0;
                row++;

            }
        }
    }
}

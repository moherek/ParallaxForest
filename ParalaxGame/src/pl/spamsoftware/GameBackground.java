package pl.spamsoftware;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBackground extends JComponent{

    private static int DEFAULT_WIDTH;
    private static int DEFAULT_HEIGHT;

    private String graphicsPathname;
    private int scrollingSpeed;

    private int xPos = 0;
    private int yPos = 0;

    private BufferedImage backgroundGraphics;

    GameBackground(int width, int height, String pathname){
        super();
        setSize(1600, 640);
        this.DEFAULT_WIDTH = width;
        this.DEFAULT_HEIGHT = height;
        this.graphicsPathname = pathname;
        try {
            backgroundGraphics = ImageIO.read(new File(graphicsPathname));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundGraphics, xPos, yPos, 800, 640,null);
        g2d.finalize();
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}

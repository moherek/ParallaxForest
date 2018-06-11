package pl.spamsoftware;


import pl.spamsoftware.util.KeyHandler;

import javax.swing.*;
import java.awt.event.KeyListener;


public class GamePanel extends JPanel implements Runnable{

    private static int WIDTH;
    private static int HEIGHT;

    private static final boolean SHOW_FPS = true;

    private static Thread thread;
    private boolean running = false;

    private JLayeredPane jLayeredPane;
    private static GameBackgroundManager gameBackgroundManager;

    private static KeyHandler key;

    GamePanel(int width, int height, JLayeredPane jLayeredPane) {
        this.jLayeredPane = jLayeredPane;
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if(thread == null){
        thread = new Thread(this,"Game");
        thread.start();
        }

    }

    private void init(){
        running = true;
        key = new KeyHandler(this);

        gameBackgroundManager = new GameBackgroundManager();
        gameBackgroundManager.renderGameBackground(jLayeredPane);
    }

    @Override
    public void run() {
        init();

        int frameCounter = 0;

        double now = System.nanoTime();

        double totalRenderTime;
        double lastRenderTime = now;
        double TTWTR = 0.0; // Total Time Waited To Render

        final double TARGET_FPS = 60.0;
        final double TTBR = 1e9 / TARGET_FPS; // Total Time Before Render


        while (running){


            // Wait before render
            if (TTWTR > TTBR) {
                render();


                TTWTR = 0.0;
                lastRenderTime = System.nanoTime();
                frameCounter++;
            }

            input(key);
            totalRenderTime = System.nanoTime() - now;

            // Calculate fps after one sec
            if (totalRenderTime > 1e9)
            {
                int FPS = (int) ((frameCounter) * 1e9 / (totalRenderTime));
                if (SHOW_FPS) System.out.println("Momentary FPS = " + FPS);
                now = System.nanoTime();
                frameCounter = 0;
            }

            TTWTR = System.nanoTime() - lastRenderTime;

        }
    }

    public void render(){
        jLayeredPane.repaint();
    }

    public void input(KeyHandler key){
    }
}

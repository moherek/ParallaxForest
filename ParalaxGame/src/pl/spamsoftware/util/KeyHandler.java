package pl.spamsoftware.util;


import pl.spamsoftware.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private static boolean move;

    public KeyHandler(GamePanel game){
        game.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            System.out.println("W is pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

package pl.spamsoftware;

import javax.swing.*;

public class Window extends JFrame{

    public static final int DEFAULT_WIDTH = 1600;
    public static final int DEFAULT_HEIGHT = 640;

    private JLayeredPane jLayeredPane = null;

    /**
     * Create and set window settings
     */
    Window(){
        setTitle("Parallax Game");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        jLayeredPane = getLayeredPane();
        setContentPane(new GamePanel(DEFAULT_WIDTH, DEFAULT_HEIGHT, jLayeredPane));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}

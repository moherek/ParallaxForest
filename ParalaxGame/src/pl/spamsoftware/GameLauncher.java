package pl.spamsoftware;

import java.awt.*;

public class GameLauncher {

    public GameLauncher(){
        new Window();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GameLauncher());
    }
}

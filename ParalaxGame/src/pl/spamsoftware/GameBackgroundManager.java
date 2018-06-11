package pl.spamsoftware;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameBackgroundManager {

    private static List<List<GameBackground>> gameBackgroundList = new ArrayList<>();


    GameBackgroundManager(){


        gameBackgroundList.add(0, new ArrayList<>());
        gameBackgroundList.add(1, new ArrayList<>());
        gameBackgroundList.add(2, new ArrayList<>());
        gameBackgroundList.add(3, new ArrayList<>());

        // Layer 1
        gameBackgroundList.get(0).add(0, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-back-trees.png"));
        gameBackgroundList.get(0).add(1, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-back-trees.png"));
        gameBackgroundList.get(0).add(2, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-back-trees.png"));
        // Layer 2
        gameBackgroundList.get(1).add(0, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-lights.png"));
        gameBackgroundList.get(1).add(1, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-lights.png"));
        gameBackgroundList.get(1).add(2, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-lights.png"));
        // Layer 3
        gameBackgroundList.get(2).add(0, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-middle-trees.png"));
        gameBackgroundList.get(2).add(1, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-middle-trees.png"));
        gameBackgroundList.get(2).add(2, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-middle-trees.png"));
        // Layer 4
         gameBackgroundList.get(3).add(0, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-front-trees.png"));
         gameBackgroundList.get(3).add(1, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-front-trees.png"));
         gameBackgroundList.get(3).add(2, new GameBackground(Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT,"parallax-forest-front-trees.png"));
    }

    public void renderGameBackground(JLayeredPane jLayeredPane) {

        for(int i = 0; i < gameBackgroundList.size(); i++){

            for(int j = 0; j < gameBackgroundList.get(i).size(); j++){
                gameBackgroundList.get(i).get(j).setxPos(800*j);
                jLayeredPane.add(gameBackgroundList.get(i).get(j),i);
            }
        }
    }

}

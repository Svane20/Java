package com.mycompany.foodwaste_project;

import com.mycompany.foodwaste_project.domain.Game;

public class Main {

    public static void main(String[] args) {
        Game g1 = Game.getInstance();
        
        App.load(args);
        g1.play();
    }
    
}

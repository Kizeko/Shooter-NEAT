package fr.kizeko.neat;

import fr.kizeko.neat.players.Soldier;
import fr.kizeko.neat.utils.World;
import processing.core.PApplet;

import java.io.File;
import java.io.IOException;

public class Main extends PApplet {

    private World world;
    private static Main instance;

    public static void main(String[] args) {
        PApplet.main("fr.kizeko.neat.Main", args);
    }

    public void settings() {
        instance = this;
        size(1280, 720);
    }

    public void setup(){
        this.world = new World();
        this.world.addPlayer(new Soldier("Hey", 100.0f, 100.0f, 0.0f, 0.0f));
    }

    public void draw(){
        background(0);
        this.world.update();
    }

    public static Main getInstance() {
        return instance;
    }

}

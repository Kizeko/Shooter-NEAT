package fr.kizeko.neat;

import fr.kizeko.neat.players.Soldier;
import fr.kizeko.neat.players.Zombie;
import fr.kizeko.neat.utils.World;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class Main extends PApplet {

    private World world;
    private static Main instance;
    float left = 0.0f;
    float right = 0.0f;
    float up = 0.0f;
    float down = 0.0f;

    public static void main(String[] args) {
        PApplet.main("fr.kizeko.neat.Main", args);
    }

    public void settings() {
        instance = this;
        size(1280, 720);
    }

    public void setup() {
        textSize(22);
        frameRate(60);
        this.world = new World();
        this.world.addPlayer(new Soldier("Hey", 600.0f, 100.0f, 2.0f, true));
        this.world.addPlayer(new Zombie("Boloss", 500.0f, 300.0f, 2.0f, true));
        this.world.addPlayer(new Zombie("Issou", 350.0f, 200.0f, 2.0f, true));
        this.world.addPlayer(new Zombie("Pog", 1000.0f, 650.0f, 2.0f, true));
    }


    public void draw() {
        this.background(255);
        this.move();
        this.world.update();
        System.out.println(World.getSoldier().getHealth());
    }

    public void move() {
        World.getSoldier().getPosition().x += (right - left) * World.getSoldier().getSpeed();
        World.getSoldier().getPosition().y += (down - up) * World.getSoldier().getSpeed();
    }

    @Override
    public void keyReleased(KeyEvent event) {
        movementCondition(event, 0);
        World.getSoldier().setMoving(false);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        movementCondition(event, 1);
        World.getSoldier().setMoving(true);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        if (event.getButton() == 37) {
            World.getSoldier().attack(new PVector(mouseX, mouseY));
        }
    }

    public void movementCondition(KeyEvent event, int number) {
        if (event.getKey() == 'q' || event.getKey() == 'Q') {
            left = number;
        }
        if (event.getKey() == 'd' || event.getKey() == 'D') {
            right = number;
        }
        if (event.getKey() == 'z' || event.getKey() == 'Z') {
            up = number;
        }
        if (event.getKey() == 's' || event.getKey() == 'S') {
            down = number;
        }
    }

    public static Main getInstance() {
        return instance;
    }

}

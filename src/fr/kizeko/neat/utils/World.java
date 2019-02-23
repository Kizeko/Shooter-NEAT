package fr.kizeko.neat.utils;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.players.Soldier;
import fr.kizeko.neat.players.Zombie;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class World {

    private PImage backgroundImage;
    private List<Player> players;

    public World(){
        this.backgroundImage = Main.getInstance().loadImage("C:/Users/Kizeko/gitrepos/Shooter-NEAT/src/fr/kizeko/neat/assets/backgrounds/background.jpg");
        this.players = new ArrayList<>();
    }

    public void update(){
        this.drawBackground();
        this.updatePlayers();
    }

    private void updatePlayers(){
        for(Player p : players){
            p.update();
        }
    }

    private void drawBackground(){
        Main.getInstance().image(backgroundImage, 0, 0, Main.getInstance().width, Main.getInstance().height);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }
}

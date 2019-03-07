package fr.kizeko.neat.utils;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.players.Soldier;
import fr.kizeko.neat.tasks.GameTask;
import fr.kizeko.neat.weapons.Bullet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class World {

    private PImage backgroundImage;
    private static List<Player> players;
    private static List<Bullet> bullets;
    private Timer timer;
    public static int time;

    public World() {
        this.backgroundImage = Main.getInstance().loadImage("C:/Users/Kizeko/gitrepos/Shooter-NEAT/src/fr/kizeko/neat/assets/backgrounds" +
                "/background.png");
        players = new ArrayList<>();
        bullets = new ArrayList<>();
        time = 0;
        this.timer = new Timer();
        this.timer.schedule(new GameTask(), 0, 1000);
    }

    public void update() {
        this.drawBackground();
        this.updatePlayers();
        this.updateBullets();
        this.drawTexts();
    }

    private void drawTexts() {
        Main.getInstance().text("Seconds : " + time, 5, 25);
        Main.getInstance().text("Kills : " + getSoldier().getKillCount(), 5, 50);
    }

    private void updatePlayers() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).update();
        }
    }

    private void updateBullets() {
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
        }
    }

    private void drawBackground() {
        //Main.getInstance().image(backgroundImage, 0, 0, Main.getInstance().width, Main.getInstance().height);
    }

    public static Soldier getSoldier() {
        return (Soldier) players.get(0);
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static List<Bullet> getBullets() {
        return bullets;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}

package fr.kizeko.neat.tasks;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.players.Zombie;
import fr.kizeko.neat.utils.World;

import java.util.TimerTask;

public class GameTask extends TimerTask {

    public static int waveCount = 0;
    public static int zombiesRemainingToSpawn = 0;
    public static boolean running = false;

    @Override
    public void run() {
        if (World.getPlayers().size() > 0) {
            if (zombiesRemainingToSpawn == 0 && running && World.getPlayers().size() == 1) {
                waveCount++;
                zombiesRemainingToSpawn = (int) (waveCount * 1.25);
                running = true;
                System.out.println("WAVE : " + waveCount + " || Zombies : " + zombiesRemainingToSpawn);
            } else if (zombiesRemainingToSpawn == 0 && !running && World.time % 3 == 0) {
                running = true;
            } else if (running && zombiesRemainingToSpawn != 0) {
                World.getPlayers().add(new Zombie(String.valueOf(Main.getInstance().random(0, 10000)), Main.getInstance().random(50, 1230),
                        Main.getInstance().random(50, 870), 2.0f, false));
                zombiesRemainingToSpawn--;
                if (zombiesRemainingToSpawn == 0) {
                    running = false;
                }
            }
        }
        World.time++;
    }

}

package fr.kizeko.neat.tasks;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.players.Zombie;
import fr.kizeko.neat.utils.World;

import java.util.TimerTask;

public class GameTask extends TimerTask {

    @Override
    public void run() {
        if (World.time % 3 == 0 && World.getPlayers().size() > 0) {
            World.getPlayers().add(new Zombie(String.valueOf(Main.getInstance().random(0, 10000)), Main.getInstance().random(50, 1230),
                    Main.getInstance().random(50, 870), 2.0f, true));
        }
        World.time++;
    }
}

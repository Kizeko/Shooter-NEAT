package fr.kizeko.neat.players.hitboxes;

import fr.kizeko.neat.players.Player;

public class ZombieHitbox extends Hitbox {

    public ZombieHitbox(float x, float y, boolean displaying) {
        super(x, y, 46.0f, 46.0f, 0.0f, 0.0f, displaying);
    }

    @Override
    public boolean hasCollided(Player player) {
        return this.stopMovementAfterCollidingWithPlayer(player);
    }

    @Override
    public boolean isOutOfGame(Player player) {
        return this.stopMovementAfterCollidingWithWalls(player);
    }
}

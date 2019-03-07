package fr.kizeko.neat.players.hitboxes;

import fr.kizeko.neat.players.Player;

public class SoldierHitbox extends Hitbox {

    public SoldierHitbox(float x, float y, boolean displaying) {
        super(x, y, 46.0f, 46.0f, -1.0f, -2.0f, displaying);
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

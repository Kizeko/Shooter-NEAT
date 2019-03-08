package fr.kizeko.neat.players.hitboxes;

import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.players.Soldier;
import fr.kizeko.neat.utils.Functions;
import fr.kizeko.neat.utils.World;

public class BulletHitbox extends Hitbox {

    public BulletHitbox(float x, float y, boolean displaying) {
        super(x, y, 3.0f, 6.0f, 0.0f, 0.0f, displaying);
    }

    @Override
    public boolean hasCollided(Player player) {
        Integer index = hasCollidedWith();
        if (index != null && !(World.getPlayers().get(index) instanceof Soldier)) {
            Functions.moveBackward(World.getPlayers().get(index).getPosition(), player.getPosition(), 10.0f);
            World.getPlayers().get(index).substractHealth(player.getWeapon().getDamage());
            return true;
        }
        return false;
    }

    @Override
    public boolean isOutOfGame(Player player) {
        Integer index = this.isOutOfScreen();
        if (index != 4) {
            return true;
        } else {
            return false;
        }
    }
}
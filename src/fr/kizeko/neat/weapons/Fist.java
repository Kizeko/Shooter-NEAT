package fr.kizeko.neat.weapons;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.FistAnimation;
import fr.kizeko.neat.animations.RifleAnimation;
import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.utils.World;
import processing.core.PVector;

public class Fist extends Weapon {

    public Fist() {
        super("Fist", 25, false, 1.5f, new FistAnimation());
    }

    @Override
    public void performAction(PVector zombiePosition, PVector soldierPosition) {
        if (Main.getInstance().millis() - (this.timeSaved + this.cooldown) >= 0) {
            World.getSoldier().substractHealth(this.damage);
            knockBackTarget(zombiePosition, soldierPosition);
            this.shooting = true;
            this.timeSaved = Main.getInstance().millis();
        }
    }

    private void knockBackTarget(PVector zombiePosition, PVector soldierPosition) {
        PVector direction = new PVector(soldierPosition.x - zombiePosition.x, soldierPosition.y - zombiePosition.y);
        direction.normalize();
        soldierPosition.add(direction.x * 5.0f, direction.y * 5.0f);
    }

    @Override
    public void draw(Player player) {
        //Main.getInstance().image(this.animation.getCurrentSprite(player), player.getPosition().x, player.getPosition().y, this.animation
        // .getSprite().getSpriteWidth(),
        //this.animation.getSprite().getSpriteHeight());
    }
}

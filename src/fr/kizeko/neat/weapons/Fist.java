package fr.kizeko.neat.weapons;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.FistAnimation;
import fr.kizeko.neat.animations.RifleAnimation;
import fr.kizeko.neat.players.Player;
import processing.core.PVector;

public class Fist extends Weapon {

    public Fist() {
        super("Fist", 25, false, 1.0f, new PVector(0.0f, 0.0f), new FistAnimation());
    }

    @Override
    public void draw(Player player) {
        Main.getInstance().image(this.animation.getCurrentSprite(player), this.position.x, this.position.y, this.animation.getSprite().getSpriteWidth(),
                this.animation.getSprite().getSpriteHeight());
    }
}

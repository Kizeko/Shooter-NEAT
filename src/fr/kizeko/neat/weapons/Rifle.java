package fr.kizeko.neat.weapons;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.RifleAnimation;
import fr.kizeko.neat.players.Player;
import processing.core.PVector;

public class Rifle extends Weapon {

    public Rifle() {
        super("Rifle", 40, true, 0.25f, new PVector(0.0f, 0.0f), new RifleAnimation());
    }

    @Override
    public void draw(Player player) {
        Main.getInstance().image(this.animation.getCurrentSprite(player), this.position.x + ((RifleAnimation) this.animation).getRecoilX(),
                this.position.y + ((RifleAnimation) this.animation).getRecoilY(), this.animation.getSprite().getSpriteWidth(), this.animation.getSprite().getSpriteHeight());
    }
}

package fr.kizeko.neat.players;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.ZombieAnimation;
import fr.kizeko.neat.weapons.Fist;

public class Zombie extends Player {
    public Zombie(String name) {
        super(name, new Fist(), new ZombieAnimation());
    }

    public Zombie(String name, float x, float y, float vx, float vy) {
        super(name, new Fist(), x, y, vx, vy, new ZombieAnimation());
    }

    public Zombie(String name, float x, float y, float vx, float vy, float angle) {
        super(name, new Fist(), x, y, vx, vy, angle, new ZombieAnimation());
    }

    @Override
    protected void draw() {
        Main.getInstance().image(this.animation.getCurrentSprite(this), this.position.x, this.position.y, this.animation.getSprite().getSpriteHeight(),
                this.animation.getSprite().getSpriteHeight());
    }
}

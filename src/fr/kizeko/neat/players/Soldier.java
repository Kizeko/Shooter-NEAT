package fr.kizeko.neat.players;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.SoldierAnimation;
import fr.kizeko.neat.sprites.SoldierSprite;
import fr.kizeko.neat.weapons.Rifle;

public class Soldier extends Player {

    //TODO CHANGE SPRITE NAMES

    public Soldier(String name) {
        super(name, new Rifle(), new SoldierAnimation());
    }

    public Soldier(String name, float x, float y, float vx, float vy) {
        super(name, new Rifle(), x, y, vx, vy, new SoldierAnimation());
    }

    public Soldier(String name, float x, float y, float vx, float vy, float angle) {
        super(name, new Rifle(), x, y, vx, vy, angle, new SoldierAnimation());
    }

    @Override
    protected void draw() {
        Main.getInstance().image(this.animation.getCurrentSprite(this), this.position.x, this.position.y, this.animation.getSprite().getSpriteHeight(),
                this.animation.getSprite().getSpriteHeight());
        Main.getInstance().image(((SoldierSprite) this.animation.getSprite()).getBodyImage(), this.position.x, this.position.y, this.animation.getSprite().getSpriteHeight(),
                this.animation.getSprite().getSpriteHeight());
    }
}

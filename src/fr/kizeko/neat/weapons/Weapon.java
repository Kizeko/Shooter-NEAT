package fr.kizeko.neat.weapons;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.Animation;
import fr.kizeko.neat.animations.RifleAnimation;
import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.utils.World;
import processing.core.PVector;

public abstract class Weapon {

    protected String id;
    protected int damage;
    protected boolean ranged;
    protected int cooldown;
    protected boolean shooting;
    protected Animation animation;
    protected int timeSaved;

    protected Weapon(String id, int damage, boolean ranged, float cooldown, Animation animation) {
        this.id = id;
        this.damage = damage;
        this.ranged = ranged;
        this.cooldown = (int) (cooldown * 1000);
        this.shooting = false;
        this.animation = animation;
        this.timeSaved = Main.getInstance().millis();
    }

    public abstract void performAction(PVector position, PVector destination);

    public abstract void draw(Player player);

    public String getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isRanged() {
        return ranged;
    }

    public void setRanged(boolean ranged) {
        this.ranged = ranged;
    }

    public float getCooldown() {
        return cooldown;
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    public Animation getAnimation() {
        return animation;
    }

    public int getTimeSaved() {
        return timeSaved;
    }
}

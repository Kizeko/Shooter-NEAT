package fr.kizeko.neat.weapons;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.Animation;
import fr.kizeko.neat.animations.RifleAnimation;
import fr.kizeko.neat.players.Player;
import processing.core.PVector;

public abstract class Weapon {

    protected String name;
    protected int damage;
    protected boolean ranged;
    protected float cooldown;
    protected boolean shooting;
    protected PVector position;
    protected Animation animation;
    protected long cooldownTimer;

    protected Weapon(String name, int damage, boolean ranged, float cooldown, PVector position, Animation animation) {
        this.name = name;
        this.damage = damage;
        this.ranged = ranged;
        this.cooldown = cooldown;
        this.shooting = false;
        this.position = position;
        this.animation = animation;
        this.cooldownTimer = System.currentTimeMillis();
    }

    public void shoot() {
        //TODO
    	if(System.currentTimeMillis() - (this.cooldownTimer + this.cooldown) >= 0) {
    		System.out.println("+++++++++++");
    		//TODO SHOOT
    		this.shooting = true;
    		this.cooldownTimer = System.currentTimeMillis();
    	}
    }

    public void updateSpecs(PVector position) {
        this.position.x = position.x + 5;
        this.position.y = position.y - 20;
    }

    public abstract void draw(Player player);

    public String getName() {
        return name;
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
}

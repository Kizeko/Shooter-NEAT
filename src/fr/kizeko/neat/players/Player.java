package fr.kizeko.neat.players;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.Animation;
import fr.kizeko.neat.weapons.Weapon;
import processing.core.PVector;

public abstract class Player {

    protected String name;
    protected int health;
    protected float angle;
    protected boolean dead;
    protected boolean moving;
    protected PVector position;
    protected PVector velocity;
    protected Weapon weapon;
    protected Animation animation;

    public Player(String name, Weapon weapon, Animation animation) {
        this.name = name;
        this.health = 100;
        this.angle = 0;
        this.dead = false;
        this.moving = false;
        this.position = new PVector(0.0f, 0.0f);
        this.velocity = new PVector(0.0f, 0.0f);
        this.weapon = weapon;
        this.animation = animation;
    }

    public Player(String name, Weapon weapon, float x, float y, float vx, float vy, Animation animation) {
        this.name = name;
        this.health = 100;
        this.angle = 0;
        this.dead = false;
        this.moving = false;
        this.position = new PVector(x, y);
        this.velocity = new PVector(vx, vy);
        this.weapon = weapon;
        this.animation = animation;
    }

    public Player(String name, Weapon weapon, float x, float y, float vx, float vy, float angle, Animation animation) {
        this(name, weapon, x, y, vx, vy, animation);
        this.angle = angle;
    }

    public void update() {
        this.updateSpecs();
        this.weapon.updateSpecs(this.position);
        this.draw();
        this.weapon.draw(this);
    }
    
    private void updateSpecs() {
        //TODO (velocity)
    	position.x += 1;
    	moving = true;
    }

    private void inputHandler() {
        //TODO (key listener, position)
    }

    protected abstract void draw();

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public PVector getPosition() {
        return position;
    }

    public PVector getVelocity() {
        return velocity;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Animation getAnimation() {
        return animation;
    }
}

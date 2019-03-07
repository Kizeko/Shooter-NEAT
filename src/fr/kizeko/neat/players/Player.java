package fr.kizeko.neat.players;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.Animation;
import fr.kizeko.neat.players.hitboxes.Hitbox;
import fr.kizeko.neat.utils.World;
import fr.kizeko.neat.weapons.Weapon;
import processing.core.PVector;

public abstract class Player {

    protected String id;
    protected int health;
    protected float angle;
    protected boolean dead;
    protected boolean moving;
    protected PVector position;
    protected float speed;
    protected Weapon weapon;
    protected Animation animation;
    protected Hitbox hitbox;

    public Player(String id, Weapon weapon, Animation animation, Hitbox hitbox) {
        this.id = id;
        this.health = 100;
        this.angle = 0.0f;
        this.dead = false;
        this.moving = false;
        this.position = new PVector(0.0f, 0.0f);
        this.speed = 1.0f;
        this.weapon = weapon;
        this.animation = animation;
        this.hitbox = hitbox;
    }

    public Player(String id, Weapon weapon, float x, float y, float speed, Animation animation, Hitbox hitbox) {
        this.id = id;
        this.health = 100;
        this.angle = 0;
        this.dead = false;
        this.moving = false;
        this.position = new PVector(x, y);
        this.speed = speed;
        this.weapon = weapon;
        this.animation = animation;
        this.hitbox = hitbox;
    }

    public Player(String id, Weapon weapon, float x, float y, float speed, float angle, Animation animation, Hitbox hitbox) {
        this(id, weapon, x, y, speed, animation, hitbox);
        this.angle = angle;
    }

    public void update() {
        this.updateSpecs();
        this.hitbox.showHitbox();
        this.draw();
        this.weapon.draw(this);
    }

    private void updateSpecs() {
        //TODO (velocity)
        for (int i = 0; i < 100; i++) {
            this.hitbox.hasCollided(this);
            this.hitbox.isOutOfGame(this);
            this.hitbox.updateSpecs(this.position);
        }
    }

    public void attack(PVector destination) {
        this.weapon.performAction(this.position, destination);
    }

    protected abstract void draw();

    public abstract void substractHealth(int health);

    public String getId() {
        return id;
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

    public float getSpeed() {
        return speed;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Animation getAnimation() {
        return animation;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }
}

package fr.kizeko.neat.weapons;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.RifleAnimation;
import fr.kizeko.neat.players.hitboxes.BulletHitbox;
import fr.kizeko.neat.utils.World;
import processing.core.PVector;

public class Bullet {

    private PVector position;
    private PVector destination;
    private PVector direction;
    private float bulletSpeed;
    private float angle;
    private RifleAnimation animation;
    private BulletHitbox hitbox;

    public Bullet(PVector position, PVector destination, float bulletSpeed, RifleAnimation animation) {
        this.position = new PVector(position.x, position.y);
        this.destination = destination;
        this.direction = new PVector(this.destination.x - this.position.x, this.destination.y - this.position.y);
        this.direction.normalize();
        this.bulletSpeed = bulletSpeed;
        this.angle = (float) Math.atan2(Main.getInstance().mouseY - this.position.y, Main.getInstance().mouseX - this.position.x) + Main.getInstance().PI / 2.20f;
        this.animation = animation;
        this.hitbox = new BulletHitbox(this.position.x, this.position.y, false);
    }

    public void update() {
        this.updateSpecs();
        this.draw();
        this.hitbox.showHitbox();
    }

    private void draw() {
        Main.getInstance().pushMatrix();
        Main.getInstance().translate(this.position.x, this.position.y);
        Main.getInstance().rotate(angle);
        Main.getInstance().image(this.animation.getBulletSprite().getSprite(), -this.animation.getBulletSprite().getSpriteWidth() / 2.0f,
                -this.animation.getBulletSprite().getSpriteHeight() / 2.0f, this.animation.getBulletSprite().getSpriteWidth(),
                this.animation.getBulletSprite().getSpriteHeight());
        Main.getInstance().popMatrix();
    }

    private void updateSpecs() {
        for (int i = 0; i < 100; i++) {
            if (this.hitbox.hasCollided(World.getSoldier()) || this.hitbox.isOutOfGame(World.getSoldier())) {
                World.getBullets().remove(this);
                return;
            }
            this.position.add(this.direction.x * bulletSpeed, this.direction.y * bulletSpeed);
            this.hitbox.updateSpecs(this.position);
        }
    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector position) {
        this.position = position;
    }

    public PVector getDestination() {
        return destination;
    }

    public void setDestination(PVector destination) {
        this.destination = destination;
    }

    public RifleAnimation getAnimation() {
        return animation;
    }

    public float getAngle() {
        return angle;
    }

    public float getBulletSpeed() {
        return bulletSpeed;
    }

    public PVector getDirection() {
        return direction;
    }
}

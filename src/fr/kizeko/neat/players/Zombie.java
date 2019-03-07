package fr.kizeko.neat.players;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.ZombieAnimation;
import fr.kizeko.neat.players.hitboxes.ZombieHitbox;
import fr.kizeko.neat.utils.World;
import fr.kizeko.neat.weapons.Fist;
import processing.core.PVector;

public class Zombie extends Player {

    //TODO method draw sert a update aussi, c'est chelou

    public Zombie(String name, boolean displaying) {
        super(name, new Fist(), new ZombieAnimation(), new ZombieHitbox(0.0f, 0.0f, displaying));
        this.moving = true;
    }

    public Zombie(String name, float x, float y, float speed, boolean displaying) {
        super(name, new Fist(), x, y, speed, new ZombieAnimation(), new ZombieHitbox(x, y, displaying));
        this.moving = true;
    }

    public Zombie(String name, float x, float y, float speed, float angle, boolean displaying) {
        super(name, new Fist(), x, y, speed, angle, new ZombieAnimation(), new ZombieHitbox(x, y, displaying));
        this.moving = true;
    }


    @Override
    protected void draw() {
        Main.getInstance().pushMatrix();
        Main.getInstance().translate(this.position.x, this.position.y);
        Main.getInstance().rotate((float) Math.atan2(World.getSoldier().position.y - this.position.y,
                World.getSoldier().position.x - this.position.x) - Main.getInstance().PI / 2.025f);
        Main.getInstance().image(this.animation.getCurrentSprite(this), -this.animation.getSprite().getSpriteHeight() / 2.0f,
                -this.animation.getSprite().getSpriteHeight() / 2.0f, this.animation.getSprite().getSpriteHeight(),
                this.animation.getSprite().getSpriteHeight());
        Main.getInstance().popMatrix();
        this.updateDirection();
    }

    @Override
    public void substractHealth(int health) {
        this.setHealth(this.health - health);
        if (this.health <= 0) {
            this.dead = true;
            World.getSoldier().setKillCount(World.getSoldier().getKillCount() + 1);
            World.getPlayers().remove(this);
        }
    }

    private void updateDirection() {
        PVector direction = new PVector(World.getSoldier().getPosition().x - this.position.x,
                World.getSoldier().getPosition().y - this.position.y);
        direction.normalize();
        this.position.add(direction.x * this.speed, direction.y * this.speed);
    }
}
package fr.kizeko.neat.players.hitboxes;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.players.Soldier;
import fr.kizeko.neat.utils.World;
import processing.core.PVector;

public abstract class Hitbox {

    protected PVector position;
    protected float width;
    protected float height;
    protected float marginLeft;
    protected float marginTop;
    protected boolean displaying;

    public Hitbox(float x, float y, float width, float height, float marginLeft, float marginTop, boolean displaying) {
        this.position = new PVector(x, y);
        this.width = width;
        this.height = height;
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.displaying = displaying;
    }

    public void updateSpecs(PVector playerPosition) {
        this.position.x = playerPosition.x + this.marginLeft;
        this.position.y = playerPosition.y + this.marginTop;
    }

    public void showHitbox() {
        if (this.displaying) {
            Main.getInstance().fill(0, 255, 0, 50);
            Main.getInstance().rect(this.position.x - this.width / 2.0f, this.position.y - this.height / 2.0f, this.width, this.height);
            Main.getInstance().fill(255);
        }
    }

    protected Integer isOutOfScreen() {
        if (this.position.x < this.width / 2.0f) {
            return 0;
        } else if (this.position.x > Main.getInstance().width - this.width / 2.0f) {
            return 1;
        } else if (this.position.y < this.height / 2.0f) {
            return 2;
        } else if (this.position.y > Main.getInstance().height - this.height / 2.0f) {
            return 3;
        } else {
            return 4;
        }
    }

    public abstract boolean hasCollided(Player player);

    public abstract boolean isOutOfGame(Player player);

    protected Integer hasCollidedWith() {
        for (Player player : World.getPlayers()) {
            if (this != player.getHitbox()) {
                if (this.position.x + this.width - this.width / 2.0f >= player.getHitbox().position.x - player.getHitbox().width / 2.0f && this.position.x - this.width / 2.0f <= player.getHitbox().position.x + player.getHitbox().width - player.getHitbox().width / 2.0f && this.position.y + this.height - this.height / 2.0f >= player.getHitbox().position.y - player.getHitbox().height / 2.0f && this.position.y - this.height / 2.0f <= player.getHitbox().position.y + player.getHitbox().height - player.getHitbox().height / 2.0f) {
                    return World.getPlayers().indexOf(player);
                }
            }
        }
        return null;
    }

    protected boolean stopMovementAfterCollidingWithPlayer(Player player) {
        Integer index = this.hasCollidedWith();
        if (index != null) {
            PVector direction = new PVector(player.getPosition().x - World.getPlayers().get(index).getPosition().x,
                    player.getPosition().y - World.getPlayers().get(index).getPosition().y);
            direction.normalize();
            player.getPosition().add(direction.x * World.getSoldier().getSpeed(), direction.y * World.getSoldier().getSpeed());
            if (World.getPlayers().get(index) instanceof Soldier) {
                player.attack(World.getSoldier().getPosition());
            }
            return true;
        }
        return false;
    }

    protected boolean stopMovementAfterCollidingWithWalls(Player player) {
        Integer index = this.isOutOfScreen();
        if (index != 4) {
            if (index == 0) {
                player.getPosition().x += player.getSpeed();
            } else if (index == 1) {
                player.getPosition().x -= player.getSpeed();
            } else if (index == 2) {
                player.getPosition().y += player.getSpeed();
            } else {
                player.getPosition().y -= player.getSpeed();
            }
            return true;
        } else {
            return false;
        }
    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector position) {
        this.position = position;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isDisplaying() {
        return displaying;
    }

    public void setDisplaying(boolean displaying) {
        this.displaying = displaying;
    }
}

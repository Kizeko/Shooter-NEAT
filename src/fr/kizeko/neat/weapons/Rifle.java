package fr.kizeko.neat.weapons;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.RifleAnimation;
import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.utils.World;
import processing.core.PVector;

public class Rifle extends Weapon {

    private float bulletSpeed;

    public Rifle() {
        super("Rifle", 40, true, 0.25f, new RifleAnimation());
        this.bulletSpeed = 1.0f;
    }

    @Override
    public void performAction(PVector position, PVector destination) {
        if (Main.getInstance().millis() - (this.timeSaved + this.cooldown) >= 0) {
            World.getBullets().add(new Bullet(position, destination, this.bulletSpeed, (RifleAnimation) this.animation));
            this.shooting = true;
            this.timeSaved = Main.getInstance().millis();
        }
    }

    @Override
    public void draw(Player player) {
        Main.getInstance().pushMatrix();
        Main.getInstance().translate(player.getPosition().x, player.getPosition().y);
        Main.getInstance().rotate((float) Math.atan2(Main.getInstance().mouseY - player.getPosition().y,
                Main.getInstance().mouseX - player.getPosition().x) + Main.getInstance().PI / 1.95f);
        Main.getInstance().image(this.animation.getCurrentSprite(player),
                ((RifleAnimation) this.animation).getRecoilX() - this.animation.getSprite().getSpriteWidth() / 2.0f + 3.0f,
                ((RifleAnimation) this.animation).getRecoilY() - this.animation.getSprite().getSpriteHeight() / 2.0f - 20.0f,
                this.animation.getSprite().getSpriteWidth(), this.animation.getSprite().getSpriteHeight());
        Main.getInstance().popMatrix();
    }

    public float getBulletSpeed() {
        return bulletSpeed;
    }
}

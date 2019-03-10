package fr.kizeko.neat.utils;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.players.Player;
import processing.core.PVector;

public class UI {

    private Player player;
    private float barWidth;
    private float barHeight;
    private PVector healthBarPosition;
    private PVector cooldownBarPosition;

    public UI(Player player) {
        this.player = player;
        this.barWidth = player.getAnimation().getSprite().getSpriteWidth() * 0.90f;
        this.barHeight = player.getAnimation().getSprite().getSpriteHeight() / 8.0f;
        this.healthBarPosition = new PVector(player.getPosition().x - barWidth / 2.0f, player.getPosition().y - 58.0f);
        this.cooldownBarPosition = new PVector(player.getPosition().x - barWidth / 2.0f, player.getPosition().y - 50.0f);
    }

    public void update() {
        this.updateSpecs();
        this.draw();
    }

    private void updateSpecs() {
        this.updateHealthBar();
        this.updateCooldownBar();
    }

    private void updateHealthBar() {
        this.healthBarPosition.x = player.getPosition().x - barWidth / 2.0f;
        this.healthBarPosition.y = player.getPosition().y - 58.0f;
    }

    private void updateCooldownBar() {
        this.cooldownBarPosition.x = player.getPosition().x - barWidth / 2.0f;
        this.cooldownBarPosition.y = player.getPosition().y - 50.0f;
    }

    private void draw() {
        this.drawHealthBar();
        this.drawCooldownBar();
    }

    private void drawHealthBar() {
        Main.getInstance().fill(204, 2, 9);
        Main.getInstance().stroke(0);
        Main.getInstance().rect(this.healthBarPosition.x, this.healthBarPosition.y, this.barWidth, this.barHeight);
        Main.getInstance().fill(234, 32, 39);
        Main.getInstance().noStroke();
        Main.getInstance().rect(this.healthBarPosition.x, this.healthBarPosition.y, this.barWidth * (this.player.getHealth() / 100.0f),
                this.barHeight);
    }

    private void drawCooldownBar() {
        Main.getInstance().fill(15, 22, 24);
        Main.getInstance().stroke(0);
        Main.getInstance().rect(this.cooldownBarPosition.x, this.cooldownBarPosition.y, this.barWidth, this.barHeight);
        Main.getInstance().fill(45, 52, 54);
        Main.getInstance().noStroke();
        if (this.player.getWeapon().isShooting()) {
            Main.getInstance().rect(this.cooldownBarPosition.x, this.cooldownBarPosition.y,
                    this.barWidth * (((Main.getInstance().millis() - this.player.getWeapon().getTimeSaved()) / (this.player.getWeapon().getCooldown() / 100.0f)) / 100.0f), this.barHeight);
        } else {
            Main.getInstance().rect(this.cooldownBarPosition.x, this.cooldownBarPosition.y, this.barWidth, this.barHeight);
        }
    }

    public Player getPlayer() {
        return player;
    }
}

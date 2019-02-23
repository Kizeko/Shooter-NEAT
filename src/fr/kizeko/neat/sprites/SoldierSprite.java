package fr.kizeko.neat.sprites;

import fr.kizeko.neat.Main;
import processing.core.PImage;

public class SoldierSprite extends Sprite {

    private PImage[] runningImages;
    private PImage bodyImage;
    private PImage standingImage;

    public SoldierSprite() {
        super(Main.getInstance().loadImage("C:/Users/Kizeko/gitrepos/Shooter-NEAT/src/fr/kizeko/neat/assets/sprites/soldierSprite.png"), 6, 1);
        this.runningImages = new PImage[nx * ny];
        for(int i = 0; i < nx * ny - 1; i++){
            this.runningImages[i] = this.sprite.get(this.spriteWidth * i, 0, this.spriteWidth, this.spriteHeight);
        }
        this.bodyImage = this.sprite.get(this.spriteWidth * 5, 0, this.spriteWidth, this.spriteHeight);
        this.standingImage = this.runningImages[4];
    }

    public PImage[] getRunningImages() {
        return runningImages;
    }

    public PImage getBodyImage() {
        return bodyImage;
    }

    public PImage getStandingImage() {
        return standingImage;
    }
}

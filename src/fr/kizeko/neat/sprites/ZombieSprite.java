package fr.kizeko.neat.sprites;

import fr.kizeko.neat.Main;
import processing.core.PImage;

public class ZombieSprite extends Sprite {

    private PImage[] runningImages;
    private PImage standingImage;

    public ZombieSprite() {
        super(Main.getInstance().loadImage("C:/Users/Kizeko/gitrepos/Shooter-NEAT/src/fr/kizeko/neat/assets/sprites/zombieSprite.png"), 4, 1);
        this.runningImages = new PImage[nx * ny];
        for(int i = 0; i < nx * ny; i++){
            this.runningImages[i] = this.sprite.get(this.spriteWidth * i, 0, this.spriteWidth, this.spriteHeight);
        }
        this.standingImage = this.sprite.get(this.spriteWidth * 3, 0, this.spriteWidth, this.spriteHeight);
    }

    public PImage[] getRunningImages() {
        return runningImages;
    }

    public PImage getStandingImage() {
        return standingImage;
    }
}

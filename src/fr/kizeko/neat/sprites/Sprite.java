package fr.kizeko.neat.sprites;

import processing.core.PImage;

public abstract class Sprite {

    protected PImage sprite;
    protected int nx;
    protected int ny;
    protected int spriteWidth;
    protected int spriteHeight;

    public Sprite(PImage sprite, int nx, int ny) {
        this.sprite = sprite;
        this.nx = nx;
        this.ny = ny;
        this.spriteWidth = this.sprite.width / this.nx;
        this.spriteHeight = this.sprite.height / this.ny;
    }

    public PImage getSprite() {
        return sprite;
    }

    public int getNx() {
        return nx;
    }

    public int getNy() {
        return ny;
    }

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public int getSpriteHeight() {
        return spriteHeight;
    }
}

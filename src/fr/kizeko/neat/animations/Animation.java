package fr.kizeko.neat.animations;

import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.sprites.Sprite;
import processing.core.PImage;

public abstract class Animation {

    protected Sprite sprite;
    protected PImage currentSprite;
    protected float timeChange;
    protected int index;

    public Animation(Sprite sprite, float timeChange){
        this.sprite = sprite;
        this.currentSprite = this.sprite.getSprite().get(0, 0, this.sprite.getSpriteWidth(), this.sprite.getSpriteHeight());
        this.timeChange = timeChange;
        this.index = 0;
    }

    protected abstract void setCurrentSprite(Player player);

    public PImage getCurrentSprite(Player player) {
        this.setCurrentSprite(player);
        return currentSprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public float getTimeChange() {
        return timeChange;
    }
}

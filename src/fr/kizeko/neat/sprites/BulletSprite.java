package fr.kizeko.neat.sprites;

import fr.kizeko.neat.Main;

public class BulletSprite extends Sprite {

    public BulletSprite() {
        super(Main.getInstance().loadImage("C:/Users/Kizeko/gitrepos/Shooter-NEAT/src/fr/kizeko/neat/assets/sprites/bulletSprite.png"), 1, 1);
        this.spriteWidth = 4;
        this.spriteHeight = 8;
    }
}

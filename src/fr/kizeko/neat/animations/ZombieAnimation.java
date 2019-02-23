package fr.kizeko.neat.animations;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.sprites.SoldierSprite;
import fr.kizeko.neat.sprites.ZombieSprite;

public class ZombieAnimation extends Animation {

    public ZombieAnimation() {
        super(new ZombieSprite(), 0.20f);
    }

    @Override
    protected void setCurrentSprite(Player player) {
        if (Main.getInstance().frameCount % (timeChange * 60.0f) == 0) {
            if (player.isMoving()) {
                this.currentSprite = ((ZombieSprite) this.sprite).getRunningImages()[this.index];
                if (this.index <= 2) {
                    this.index++;
                } else {
                    this.index = 0;
                }
            } else {
                this.currentSprite = ((ZombieSprite) this.sprite).getStandingImage();
            }
        }
    }
}

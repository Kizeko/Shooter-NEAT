package fr.kizeko.neat.animations;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.sprites.SoldierSprite;

public class SoldierAnimation extends Animation {

    public SoldierAnimation() {
        super(new SoldierSprite(), 0.20f);
    }

    @Override
    protected void setCurrentSprite(Player player) {
        if (Main.getInstance().frameCount % (timeChange * 60.0f) == 0) {
            if (player.isMoving()) {
                this.currentSprite = ((SoldierSprite) this.sprite).getRunningImages()[this.index];
                if (this.index <= 2) {
                    this.index++;
                } else {
                    this.index = 0;
                }
            } else {
                this.currentSprite = ((SoldierSprite) this.sprite).getStandingImage();
            }
        }
    }
}

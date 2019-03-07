package fr.kizeko.neat.animations;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.players.Player;
import fr.kizeko.neat.sprites.BulletSprite;
import fr.kizeko.neat.sprites.RifleSprite;

public class RifleAnimation extends Animation {

    private BulletSprite bulletSprite;
    private float recoilX;
    private float recoilY;
    private int index;

    public RifleAnimation() {
        super(new RifleSprite(), 0.05f);
        this.bulletSprite = new BulletSprite();
        this.recoilX = 0.0f;
        this.recoilY = 0.0f;
    }

    @Override
    protected void setCurrentSprite(Player player) {
        if (player.getWeapon().isShooting()) {
            if (Main.getInstance().frameCount % (timeChange * 60.0f) == 0) {
                //this.recoilX += 0.0f;
                //this.recoilY += 1.0f;
                this.index++;
                if (this.index == 5) {
                    this.index = 0;
                    //this.recoilX = 0.0f;
                    //this.recoilY = 0.0f;
                    player.getWeapon().setShooting(false);
                }
            }
        }
    }

    public float getRecoilX() {
        return recoilX;
    }

    public void setRecoilX(float recoilX) {
        this.recoilX = recoilX;
    }

    public float getRecoilY() {
        return recoilY;
    }

    public void setRecoilY(float recoilY) {
        this.recoilY = recoilY;
    }

    public BulletSprite getBulletSprite() {
        return bulletSprite;
    }
}

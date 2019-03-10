package fr.kizeko.neat.players;

import fr.kizeko.neat.Main;
import fr.kizeko.neat.animations.SoldierAnimation;
import fr.kizeko.neat.players.hitboxes.SoldierHitbox;
import fr.kizeko.neat.sprites.SoldierSprite;
import fr.kizeko.neat.utils.UI;
import fr.kizeko.neat.weapons.Rifle;

public class Soldier extends Player {

    private UI ui;

    private int killCount;

    public Soldier(String name, boolean displaying) {
        super(name, new Rifle(), new SoldierAnimation(), new SoldierHitbox(0.0f, 0.0f, displaying));
        this.ui = new UI(this);
        this.killCount = 0;
    }

    public Soldier(String name, float x, float y, float speed, boolean displaying) {
        super(name, new Rifle(), x, y, speed, new SoldierAnimation(), new SoldierHitbox(x, y, displaying));
        this.ui = new UI(this);
        this.killCount = 0;
    }

    public Soldier(String name, float x, float y, float speed, float angle, boolean displaying) {
        super(name, new Rifle(), x, y, speed, angle, new SoldierAnimation(), new SoldierHitbox(x, y, displaying));
        this.ui = new UI(this);
        this.killCount = 0;
    }

    @Override
    protected void draw() {
        Main.getInstance().pushMatrix();
        Main.getInstance().translate(this.position.x, this.position.y);
        Main.getInstance().rotate((float) Math.atan2(Main.getInstance().mouseY - this.position.y, Main.getInstance().mouseX - this.position.x) + Main.getInstance().PI / 2.20f);
        Main.getInstance().image(this.animation.getCurrentSprite(this), -this.animation.getSprite().getSpriteWidth() / 2.0f,
                -this.animation.getSprite().getSpriteHeight() / 2.0f, this.animation.getSprite().getSpriteWidth(),
                this.animation.getSprite().getSpriteHeight());
        Main.getInstance().image(((SoldierSprite) this.animation.getSprite()).getBodyImage(),
                -this.animation.getSprite().getSpriteWidth() / 2.0f, -this.animation.getSprite().getSpriteHeight() / 2.0f,
                this.animation.getSprite().getSpriteWidth(), this.animation.getSprite().getSpriteHeight());
        Main.getInstance().popMatrix();
        this.ui.update();
    }

    @Override
    public void substractHealth(int health) {
        this.setHealth(this.health - health);
        if (this.health <= 0) {
            this.dead = true;
            Main.getInstance().stop();
            //TODO RETOUR MENU PRINCIPAL / FIN DE PARTIE
        }
    }

    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }
}

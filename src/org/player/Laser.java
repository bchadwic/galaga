package org.player;

import org.engine.GameLoop;
import org.graphics.Graphics;
import org.resource.ImageResource;
import org.target.Enemy;
import org.world.GameObject;
import org.world.Space;

public class Laser extends GameObject {

    private final int SPEED = 10;
    ImageResource laser = new ImageResource("/res/laser.png");

    public Laser(float x){
        this.x = x;
        y = -3.4f;
        Space.addPlayerObject(this);
    }

    public void update(){
        for(Enemy enemy : Space.getEnemies()) {
            if (((this.x > enemy.x-.5f)&&(this.x < enemy.x+.5f)) && ((this.y > enemy.y-.2f) && (this.y < enemy.y+.2f))){
                enemy.shot();
                this.y = 7;
            }
        }
        y += SPEED * GameLoop.updateDelta();
    }

    public void render(){
        Graphics.drawImage(laser,x,y,.15f,.4f);
    }


}

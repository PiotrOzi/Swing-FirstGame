package game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        x = Game.clamp((int)x, 0, Game.WIDTH - 39);
        y = Game.clamp((int)y, 0, Game.HEIGHT - 68);

        collision();

    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {

            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId()==ID.BasicEnemy || tempObject.getId()==ID.FastEnemy || tempObject.getId()==ID.SmartEnemy ){
                if (this.getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int)x, (int)y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }


}

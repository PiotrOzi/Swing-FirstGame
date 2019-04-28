package game;

import java.awt.*;

public class BasicEnemy extends GameObject {

    private Handler handler;

    public BasicEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        speedX = 5;
        speedY = 5;
    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        if (x <= 0 || x >= Game.WIDTH - 20) speedX *= -1;
        if (y <= 0 || y >= Game.HEIGHT - 50) speedY *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16, 16, 0.02f, handler ));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 16, 16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}

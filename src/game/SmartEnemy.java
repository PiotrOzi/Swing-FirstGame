package game;

import java.awt.*;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;

    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        for (int i = 0; i < handler.objects.size(); i++){
            if (handler.objects.get(i).getId() == ID.Player) this.player = handler.objects.get(i);
        }


    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        float diffX = this.x - player.getX() - 8;
        float diffY = this.y - player.getY() - 8;
        float distance = (float) Math.sqrt((x - player.getX())*(x - player.getX()) + (y - player.getY())*(y - player.getY()));

        speedX = (float) ((-1.0/distance)*diffX);
        speedY = (float) ((-1.0/distance)*diffY);

        if (x <= 0 || x >= Game.WIDTH - 20) speedX *= -1;
        if (y <= 0 || y >= Game.HEIGHT - 50) speedY *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.GREEN, 16, 16, 0.02f, handler ));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)x, (int)y, 16, 16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}

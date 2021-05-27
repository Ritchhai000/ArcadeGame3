import java.awt.*;

public class Enemy {

    private int x, y;
    private final int WIDTH = 25, HEIGHT = 25;
    Game game;
    Board board;

    boolean remove = false;

    public Enemy(Game game, Board board){

        this.game = game;
        this.board = board;
    }

    public void setPosition(int inputX, int inputY){

        x = inputX - WIDTH/2;
        y = inputY - HEIGHT/2;
    }

    public void paint(Graphics g){

        g.setColor(Color.RED);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public boolean collidesWith(Ball ball) {

        return this.getBounds().intersects(ball.getBounds());
    }

    private Rectangle getBounds() {

        return new Rectangle((int)(x), (int)(y), WIDTH, HEIGHT);
    }

    public void setRemove(boolean input){

        remove = input;
    }

    public boolean isRemove(){

        return remove;
    }
}

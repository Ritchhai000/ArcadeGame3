import java.awt.*;

public class Ball {

    private int x, y, dx = 2, dy = 2;
    private final int diameter = 15;
    Board board;

    public Ball(Board board){

        this.board = board;
    }

    public void setPosition(int inputX, int inputY){

        x = inputX - diameter/2;
        y = inputY - diameter/2;
    }

    public void move(){

        if(x + diameter > board.getWidth() || x< 0){

            dx *= -1;
        }

        if(y + diameter > board.getHeight() || y < 0){

            dy *= -1;
        }

        x += dx;
        y += dy;
    }

    public void paint(Graphics g){

        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }

    public Rectangle getBounds() {

        return new Rectangle((int)(x + dx), (int)(y+ dy), diameter, diameter);
    }
}

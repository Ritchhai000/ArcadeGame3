import java.awt.*;

public class Player {

    private int x, y;
    private final int WIDTH = 100, HEIGHT = 20;
    Game game;
    Board board;

    public Player(Game game, Board board){

        this.game = game;
        this.board = board;
    }

    public void setPosition(int inputX, int inputY){

        x = inputX - WIDTH/2;
        y = inputY - HEIGHT/2;
    }

    public void move(){

        if(game.isUpPressed()){

            if(y > 0){

                x -= 5;
            }
        }

        if(game.isDownPressed()){

            if(y + HEIGHT < board.getHeight()) {

                x += 5;
            }
        }
    }

    public void paint(Graphics g){

        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

}

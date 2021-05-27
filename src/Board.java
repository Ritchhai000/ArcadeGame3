import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {

    Ball ball = new Ball(this);
    Player paddle;
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Enemy> enemies2 = new ArrayList<>();

    Timer timer;
    final int NUMENEMIES = 12;

    public Board(Game game){

        setPreferredSize(new Dimension(600,650));
        setBackground(Color.BLACK);
        ball = new Ball(this);
        paddle = new Player(game, this);

        for(int i = 0; i < NUMENEMIES; i++){

            enemies.add(new Enemy(game, this));
        }

    }

    public void GameStart(){

        int x = 50;
        ball.setPosition(getWidth()/2,getHeight()/2);
        paddle.setPosition(200, 630);

        for(int i = 1; i < enemies.size(); i++){

            enemies.get(i).setPosition(x, 50);
            x = x + 50;
        }

        timer = new Timer(1000/60,this);
        timer.start();
    }

    public void checkCollisions(){

        for(int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).collidesWith(ball)){

                enemies.get(i).setRemove(true);
            }
        }
    }

    public void actionPerformed(ActionEvent e){

        checkCollisions();
        ball.move();
        paddle.move();
        repaint();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        for(Enemy enemy : enemies){

            enemy.paint(g);
        }

        ball.paint(g);
        paddle.paint(g);
    }


}

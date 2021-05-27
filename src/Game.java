import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener  {

    Board board;
    private boolean  leftPressed, rightPressed;

    public Game(){

        setResizable(false);
        setVisible(true);
        setFocusable(true);
        setTitle("PONG");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        board = new Board(this);
        add(board);
        addKeyListener(this);

        pack();

        setLocationRelativeTo(null);
        board.GameStart();
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT){

            leftPressed = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){

            rightPressed = true;
        }
    }



    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT){

            leftPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){

            rightPressed = false;
        }

    }

    public boolean isUpPressed() {
        return leftPressed;
    }

    public boolean isDownPressed() {
        return rightPressed;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.board.GameStart();
    }
}

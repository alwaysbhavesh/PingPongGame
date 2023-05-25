package Project;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends Rectangle {
    int id;
    int yVelocity;
    int speed = 10;

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

//    public void keyPressed(KeyEvent e) {
//        switch (id) {
//            case 1:
//                //moving in the upward direction when W is pressed
//                if (e.getKeyCode() == KeyEvent.VK_W) {
//                    setYDirection(-speed);
//                }
//
//                //moving in the downward direction when S is pressed
//                if (e.getKeyCode() == KeyEvent.VK_S) {
//                    setYDirection(speed);
//                }
//                break;
//            case 2:
//                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    setYDirection(-speed);
//                }
//                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//                    setYDirection(speed);
//                }
//                break;
//        }
//    }
//
//
//
//
//
//    public void keyReleased(KeyEvent e) {
//        switch (id) {
//            case 1:
//                if (e.getKeyCode() == KeyEvent.VK_W) {
//                    setYDirection(0);
//                }
//                if (e.getKeyCode() == KeyEvent.VK_S) {
//                    setYDirection(0);
//                }
//                break;
//            case 2:
//                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    setYDirection(0);
//                }
//                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//                    setYDirection(0);
//                }
//                break;
//        }
//    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
//        move();
    }

    public void move() {
        y = y + yVelocity;
    }

    public void draw(Graphics g) {
        if (id == 1)
            g.setColor(Color.BLUE);
        else
            g.setColor(Color.RED);

        g.fillRect(x, y, width, height);
    }

}

//    int Id;
//    int yVelocity = 10;
//    Paddle(int x, int y, int paddleWidth, int paddleHeight, int id){
//        super(x,y,paddleWidth,paddleHeight);
//        this.Id = id;
//    }
//
//    public void draw(Graphics g){
//        if(Id == 1)
//            g.setColor(Color.red);
//        else
//            g.setColor(Color.BLUE);
//        g.fillRect(x,y,width,height);
//    }
//
//    public void move(int yVelocity){
//        y = y +  yVelocity;
//    }
//

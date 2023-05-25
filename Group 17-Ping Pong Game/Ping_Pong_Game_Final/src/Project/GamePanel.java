package Project;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;


public class GamePanel extends JPanel implements Runnable{
    public static final int frame_Width = 1014;
    public static final int frame_Height = 615;
    public static final int Paddle_width = 30;
    public static final int Paddle_height = 100;

    static int x = 0;
    static int y = 0;
    static int xVelocity = 0;
    static int yVelocity = 0;
    String player1;
    String player2;

    public boolean isRunning = true;
    Graphics graphics;
    Image image;
    Paddle Left_Paddle;
    Paddle Right_Paddle;
    Thread gameThread;
    Ball ball;
    Score score;
    WinnerDialog winnerDialog;
    static final Dimension SCREEN_SIZE = new Dimension(frame_Width, frame_Height);
    int speed = 15;
    int ScoreToWin;

    InputMap im = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
    ActionMap am = this.getActionMap();

    AudioInputStream audioInputStream;
    Clip clip;
  
    

    GamePanel(String p1, String p2, int scoreToWin) {
    	
        player1 = p1;
        player2 = p2;
        ScoreToWin = scoreToWin;
        Make_Paddle();
        Make_Ball();
        score = new Score(frame_Width,frame_Height,p1,p2);
        this.setFocusable(true);
//        this.addKeyListener(new AL());
        key_Orders();
//        this.setFocusTraversalKeysEnabled(false);
        this.setBounds(0, 0, frame_Width, frame_Height);
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void key_Orders(){

//        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0,false),"up");
//        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0,false),"down");
//        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0,false),"w");
//        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0,false),"s");

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0,false), "w_Pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0,false), "s_Pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0,false), "UpArrow_Pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0,false), "DownArrow_Pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0,false), "space");

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0,true), "w_Released");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0,true), "s_Released");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0,true), "UpArrow_Released");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0,true), "DownArrow_Released");

        am.put("space", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseResumeGame();
            }
        });

        am.put("w_Pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("w");
                Left_Paddle.setYDirection(-speed);
            }
        });
        am.put("s_Pressed", new AbstractAction("LeftArrow") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("left");
                Left_Paddle.setYDirection(speed);
            }
        });
        am.put("UpArrow_Pressed", new AbstractAction("UpArrow") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Up");
                Right_Paddle.setYDirection(-speed);
            }
        });
        am.put("DownArrow_Pressed", new AbstractAction("DownArrow") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Down");
                Right_Paddle.setYDirection(speed);

            }
        });

        am.put("w_Released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("w");
                Left_Paddle.setYDirection(0);
            }
        });
        am.put("s_Released", new AbstractAction("LeftArrow") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("left");
                Left_Paddle.setYDirection(0);
            }
        });
        am.put("UpArrow_Released", new AbstractAction("UpArrow") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Up");
                Right_Paddle.setYDirection(0);
            }
        });
        am.put("DownArrow_Released", new AbstractAction("DownArrow") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Down");
                Right_Paddle.setYDirection(0);

            }
        });
    }


    public void Make_Paddle() {
        Left_Paddle = new Paddle(x, frame_Height / 2 - Paddle_height / 2, Paddle_width, Paddle_height, 1);
        Right_Paddle = new Paddle(974, frame_Height / 2 - Paddle_height / 2, Paddle_width, Paddle_height, 2);
    }

    public void Make_Ball() {
        ball = new Ball(500, 250, 20, 20);
    }

    public void draw(Graphics g) {
        Left_Paddle.draw(g);
        Right_Paddle.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync(); // I forgot to add this line of code in the video, it helps with the animation
    }

    public void paint(Graphics g) {
        //Creating image
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void move() {
        Left_Paddle.move();
        Right_Paddle.move();
        ball.move();
//        playGameSound();
    }


    public void run() {
        playGameSound();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (isRunning) {
                if (delta >= 1) {
                    move();
                    try {
                        checkCollision();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    repaint();
                    delta--;
                }
            }
        }
    }

    public void checkCollision() throws IOException {
//        playGameSound();

        if(score.player1_score == ScoreToWin){
            clip.close();
            winnerDialog = new WinnerDialog(player1,player1,player2,ScoreToWin);
            System.out.println(player1 + " is winner");
            isRunning = false;
        }
        if(score.player2_score == ScoreToWin){
            clip.close();
            winnerDialog = new WinnerDialog(player2,player1,player2,ScoreToWin);

            System.out.println(player2 + " is winner");
            isRunning = false;
        }

        if(ball.y <= 0){
            ball.setYDirection(-ball.yVelocity);
        }

        if (ball.y >= frame_Height-50){
            ball.setYDirection(-ball.yVelocity);
        }


        if (Left_Paddle.y <= 0){
            Left_Paddle.y = 0;
        }

        if(Left_Paddle.y >= frame_Height - Paddle_height){
            Left_Paddle.y = frame_Height - Paddle_height;
        }

        if (Right_Paddle.y <= 0){
            Right_Paddle.y = 0;
        }

        if(Right_Paddle.y >= frame_Height - Paddle_height){
            Right_Paddle.y = frame_Height - Paddle_height;
        }

        if(Left_Paddle.intersects(ball)){

            playMoveSound();
//            clip.close();
            ball.xVelocity = Math.abs(ball.xVelocity);
//            ball.yVelocity = Math.abs(ball.yVelocity);
            ball.xVelocity++; //optional for more difficulty
//            ball.yVelocity++; //optional for more difficulty
            if (ball.yVelocity > 0)
                ball.yVelocity++; //optional for more difficulty
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if(Right_Paddle.intersects(ball)){
            playMoveSound();
//            clip.close();
            ball.xVelocity = Math.abs(ball.xVelocity);
//            ball.yVelocity = Math.abs(ball.yVelocity);
            ball.xVelocity++;
//            ball.yVelocity++;
            if (ball.yVelocity > 0)
                ball.yVelocity++; //optional for more difficulty
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if (ball.x <= 0){
            score.player2_score++;
            playCrashSound();
//            Make_Paddle();
//            Make_Ball();
            System.out.println("ball x velocity - " + ball.xVelocity);
            ball.setXDirection(7);
            if(ball.yVelocity < 0)
                ball.setYDirection(-7);
            else
                ball.setYDirection(7);

        }
        if (ball.x >= frame_Width-30){
           score.player1_score++;
           playCrashSound();
//            Make_Paddle();
            ball.setXDirection(-7);
            if(ball.yVelocity < 0)
                ball.setYDirection(-7);
            else
                ball.setYDirection(7);
        }

    }


    public void pauseResumeGame(){
        int x,y;
        x = ball.xVelocity;
        y = ball.yVelocity;

        if(isRunning){

            isRunning = false;
            clip.close();
        }
        else {
            new Ball(x,y,20,20,x,y);
            isRunning = true;
            Make_Ball();
            playGameSound();
        }
    }
    public void playGameSound(){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("sounds\\music.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public static void playMoveSound() {
        //paddle collision
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds\\move.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

   public void playCrashSound(){
        try{
            AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File("sounds\\gameover.wav").getAbsoluteFile());
            Clip clip1 = AudioSystem.getClip();
            clip1.open(audioInputStream1);
            clip1.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //    public void keyPressed(KeyEvent e) {
//        System.out.println("pressed");
//        Left_Paddle.keyPressed(e);
//        Right_Paddle.keyPressed(e);
//    }
//
//    public void keyReleased(KeyEvent e){
//        System.out.println("Released");
//        Left_Paddle.keyReleased(e);
//        Right_Paddle.keyReleased(e);
//    }



//    public class AL extends KeyAdapter {
//        @Override
//        public void keyPressed(KeyEvent e) {
//            System.out.println("pressed");
//            Left_Paddle.keyPressed(e);
//            Right_Paddle.keyPressed(e);
//        }
//
//        public void keyReleased(KeyEvent e) {
//            System.out.println("Released");
//            Left_Paddle.keyReleased(e);
//            Right_Paddle.keyReleased(e);
//        }
//    }

}
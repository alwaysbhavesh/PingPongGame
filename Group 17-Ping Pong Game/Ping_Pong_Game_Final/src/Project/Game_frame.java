package Project;
import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game_frame extends JFrame {

    public GamePanel gamePanel;

    Game_frame(String p1, String p2, int scoreToWin) {
        gamePanel = new GamePanel(p1,p2,scoreToWin);
        this.setVisible(true);
        this.setSize(1014,620);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game Frame");
        this.setLocationRelativeTo(null);
        this.setBackground(Color.DARK_GRAY);
//        this.setResizable(false);
        this.add(gamePanel);
    }

}
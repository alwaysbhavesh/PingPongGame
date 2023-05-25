package Project;
import javax.swing.*;
import java.awt.*;

public class Score extends Rectangle {
     String player1_name;
    String player2_name;

    public int player1_score = 0;
    public int player2_score = 0;
    static int GAME_WIDTH,GAME_HEIGHT;


        Score(int GAME_WIDTH, int GAME_HEIGHT,String p1,String p2){
            Score.GAME_WIDTH = GAME_WIDTH;
            Score.GAME_HEIGHT = GAME_HEIGHT;
            this.player1_name = p1;
            this.player2_name = p2;

        }

        public void draw(Graphics g){
                for(int i = 0; i < 615; i+=20){
                    g.drawLine(507,i,507,i+10);
                }
            g.setColor(Color.white);
            g.setFont(new Font("Consolas", Font.BOLD, 30));
            g.drawString(this.player1_name, (GAME_WIDTH / 2) - 460, 90);
            g.drawString(this.player2_name, (GAME_WIDTH / 2) + 340, 90);
            g.setFont(new Font("Consolas", Font.PLAIN, 40));

            //g.drawLine(GAME_WIDTH / 2, 1, GAME_WIDTH / 2, GAME_HEIGHT);

            g.drawString(String.valueOf(player1_score / 10) + String.valueOf(player1_score % 10), (GAME_WIDTH / 2) - 420, 50);
            g.drawString(String.valueOf(player2_score / 10) + String.valueOf(player2_score % 10), (GAME_WIDTH / 2) + 400, 50);

    }
}

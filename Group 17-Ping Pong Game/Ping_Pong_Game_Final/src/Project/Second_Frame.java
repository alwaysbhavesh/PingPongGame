package Project;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Second_Frame extends JFrame{
    public static final int frame_Width = 1014;
    public static final int frame_Height = 615;
    JProgressBar bar;
    JLabel player1_Label, player2_Label;
    Second_Frame(String s1, String s2, int scoreToWin) throws IOException {
//        JProgressBar bar;
        bar = new JProgressBar();
        player1_Label = new JLabel(s1);
        player2_Label = new JLabel(s2);
        this.setContentPane(new JLabel(getImage()));



//        bar.setValue(0);
        bar.setBounds(200, 530, 604, 30);
        bar.setBackground(Color.BLACK);
        bar.setStringPainted(true);
        this.add(bar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1014, 615);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
//            this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setTitle("PongGame");
        this.setLocationRelativeTo(null);
        int counter = 10;

        player1_Label.setBounds(80,300,300,50);
        player2_Label.setBounds(620,300,300,50);

//        player1_Label.setBackground(Color.blue);
//        player2_Label.setBackground(Color.blue);

        player1_Label.setForeground(Color.WHITE);
        player2_Label.setForeground(Color.WHITE);

//        player1_Label.setOpaque(true);
//        player2_Label.setOpaque(true);

        player1_Label.setHorizontalAlignment(JLabel.CENTER);
        player2_Label.setHorizontalAlignment(JLabel.CENTER);

        player1_Label.setVerticalAlignment(JLabel.CENTER);
        player2_Label.setVerticalAlignment(JLabel.CENTER);

        player1_Label.setFont(new Font("MV Boli",Font.BOLD,50));
        player2_Label.setFont(new Font("MV Boli",Font.BOLD,50));

        this.add(player1_Label);
        this.add(player2_Label);

        while (counter <= 100) {
            bar.setValue(counter);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            counter += 10;
        }

        bar.setString("Lets play...");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
//            Game_frame gameFrame = new Game_frame();

        this.setVisible(false);
        this.dispose();
        Game_frame FR = new Game_frame(s1,s2,scoreToWin);


    }

    static ImageIcon getImage() throws IOException {
            BufferedImage img = ImageIO.read(new File("images/Versus.jpg"));
            Image scaled = img.getScaledInstance(frame_Width, frame_Height, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaled);
            return icon;

        }
//
//    public static void main(String[] args) throws IOException {
//        Second_Frame second_frame = new Second_Frame("nikhil","ksakak",4);
//
//    }


}
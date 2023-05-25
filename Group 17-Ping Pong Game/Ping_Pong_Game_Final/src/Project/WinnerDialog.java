package Project;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WinnerDialog extends JFrame {
    JLabel winnerLabel;
    static int winnerDialogWidth = 400;
    static int winnerDialogHeight = 400;
    Connection con=null;
	Statement stmt;

    WinnerDialog(String winner, String player1_name, String player2_name, int scoreToWin) throws IOException {
        this.setSize(winnerDialogWidth,winnerDialogHeight);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JLabel(getImage()));
   

        winnerLabel = new JLabel("winner is " + winner);
        winnerLabel.setBounds(0,20,400,50);
        winnerLabel.setForeground(Color.WHITE);
        winnerLabel.setFont(new Font("MV Boli", Font.BOLD, 40));
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);
        winnerLabel.setVerticalAlignment(JLabel.CENTER);
        winnerLabel.setHorizontalTextPosition(JLabel.CENTER);
        winnerLabel.setVerticalTextPosition(JLabel.CENTER);

        this.add(winnerLabel);
        this.setVisible(true);
        
        try {
      		 Class.forName("com.mysql.jdbc.Driver");
      		 con=DriverManager.getConnection("jdbc:mysql://localhost:3307/register","root","");
      		 stmt=con.createStatement();
      		 
      		
      			stmt.execute("insert into userhistory values ('"+ player1_name +"','"+ player2_name +"','"+ scoreToWin +"','"+ winner +"')");
         		   		 
             }catch(ClassNotFoundException e1)
             {
          	   e1.printStackTrace();
             }
             catch(SQLException e1)
             {
          	   e1.printStackTrace();
             }finally
             {  
          	   try {
   				con.close();
   				new Login_page1();
   			} catch (SQLException e1) {
   				
   				e1.printStackTrace();
   			}
             }
   			
    }

    static ImageIcon getImage() throws IOException {
        BufferedImage img = ImageIO.read(new File("images/GameOver.jpg"));
        Image scaled = img.getScaledInstance(winnerDialogWidth,winnerDialogHeight, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaled);
        return icon;

    }

  
}
package Project;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

class Login_page2a extends JFrame
{
    JTextField user1,user2,score;
    JTextField password1,password2;

        Connection con = null;
        public int flag=0,flag1=0;
        public Login_page2a() throws IOException {
            con = (Connection) e1.dbconnect();
      
            setLocation(380,120);
            setLayout(null);
            setResizable(false);
            getContentPane().setBackground(new Color(255, 204, 102));
       

            Font fo = new Font("Times New Roman",Font.BOLD,30);
            Font fo1 = new Font("Times New Roman",Font.PLAIN,18);



            JLabel stu1 = new JLabel("Player 1");
            stu1.setBounds(200, 50, 200, 100);
            stu1.setFont(fo);
            add(stu1);


            JLabel j1 = new JLabel("Username :");
            j1.setBounds(120, 200, 100, 40);
            j1.setFont(fo1);
            add(j1);

            JLabel j2 = new JLabel("Password :");
            j2.setBounds(120, 300, 100, 40);
            j2.setFont(fo1);
            add(j2);

            user1 = new JTextField();
            user1.setBounds(220,200,120,40);
            add(user1);

            password1 = new JPasswordField();
            password1.setBounds(220,300,120,40);
            add(password1);


            JButton b1 = new JButton("Submit");
            b1.setFont(fo1);
            b1.setBounds(360,500,120,40);
            add(b1);
            
            
            
            JLabel stu2 = new JLabel("Player 2");
            stu2.setBounds(550, 50, 200, 100);
            stu2.setFont(fo);
            add(stu2);


            JLabel j3 = new JLabel("Username :");
            j3.setBounds(470, 200, 100, 40);
            j3.setFont(fo1);
            add(j3);

            JLabel j4 = new JLabel("Password :");
            j4.setBounds(470, 300, 100, 40);
            j4.setFont(fo1);
            add(j4);

            user2 = new JTextField();
            user2.setBounds(570,200,120,40);
            add(user2);

            password2 = new JPasswordField();
            password2.setBounds(570,300,120,40);
            add(password2);
            
            JLabel j5 = new JLabel("Score to Win :");
            j5.setBounds(360, 380, 140, 40);
            j5.setFont(fo1);
            add(j5);
            
            score = new JTextField();
            score.setBounds(360,420,120,40);
            add(score);


            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   try {
                       String usr1= user1.getText();
                       String pwd1=String.valueOf(password1.getText());
                       PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from reg where username =? and password=?");
                       pst.setString(1,usr1);
                       pst.setString(2,pwd1);
                       ResultSet r = pst.executeQuery();
                       if(r.next())
                       {
     
                           flag=1;

                       }
                   }catch (Exception e1)
                   {
                       e1.printStackTrace();
                   }
                        
                   try {
                       String usr2= user2.getText();
                       String pwd2=String.valueOf(password2.getText());
                       PreparedStatement pst1= (PreparedStatement)con.prepareStatement("select * from reg where username =? and password=?");
                       pst1.setString(1,usr2);
                       pst1.setString(2,pwd2);
                       ResultSet r2 = pst1.executeQuery();
                       if(r2.next())
                       {
     
                           flag1=1;

                       }
                   }catch (Exception e1)
                   {
                       e1.printStackTrace();
                   }
                   
                   if(flag==1&&flag1==1) {
                	   JOptionPane.showMessageDialog(null,"Login Successfull ");
                	   dispose();
                	   try {
                		   NewThread nt = new NewThread();
                		   nt.start();
					} catch (NumberFormatException e1) 
                	   {
						e1.printStackTrace();
					}
                	  
                	   

                   }
                   else
                   {
                	   if(flag==0)
                		   JOptionPane.showMessageDialog(null,"Invalid Username or Password of User 1");
                	   if(flag1==0)
                		   JOptionPane.showMessageDialog(null,"Invalid Username or Password of User 2"); 
                   }
                }
                
            });
            
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

class NewThread extends Thread {
	public void run(){
		try {
			Second_Frame sf = new Second_Frame(user1.getText(),user2.getText(),Integer.parseInt(score.getText()));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
    }



public class Login_page2
{
    public static void main(String args[]) throws IOException {

    	Login_page2a s = new Login_page2a();
    	s.getContentPane().setBackground(new Color(255, 204, 102));
    	s.getContentPane().setLayout(null);
        s.setSize(800,600);
    }
}
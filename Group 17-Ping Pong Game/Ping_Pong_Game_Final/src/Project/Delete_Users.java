package Project;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Delete_Users extends JFrame  {

	JPanel contentPane;
	JTextField U_textField;
	JPasswordField passwordField;
	Connection con=null;
	Statement stmt;
	ResultSet rs;
	TextField textField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Users frame = new Delete_Users();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Delete_Users() {

		JFrame f = new JFrame();
		f.getContentPane().setBackground(new Color(240, 255, 255));
		f.setSize(700,700);
		f.getContentPane().setLayout(null);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014,615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Player");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(282, 49, 211, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("Username :\r\n");
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel1.setBounds(145, 195, 146, 40);
		contentPane.add(lblNewLabel1);
		
		U_textField = new JTextField();
		U_textField.setBounds(383, 196, 270, 39);
		contentPane.add(U_textField);
		U_textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(145, 297, 146, 33);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(383,300 , 270, 40);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Submit");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(295, 411, 180, 47);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String username = U_textField.getText();
				 String password = passwordField.getText();

	                if(username.equals("Kunal") && password.equals("Kunal@123"))
	                {
	                try {
						new Admin();
						dispose();
					       }
					catch(StackOverflowError e1)
					         {
						       e1.printStackTrace();
					         } 
	                }      
	                else
	                {
	                	
	                }
			}
			
		});
	}
	
}

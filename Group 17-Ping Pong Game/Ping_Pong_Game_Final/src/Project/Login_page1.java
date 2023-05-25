package Project;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login_page1 extends JFrame
{
	 JPanel contentPane;
     JTextField textField;
	 JTextField textField_1;
	 JTextField textField_2;
	 JTextField textField_3;
	 JTextField textField_4;

		Connection con = null;
		public Login_page1() {
	
		con = (Connection) e1.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To \r\nPong Game");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 40));
		lblNewLabel.setBounds(284, 90, 544, 100);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(408, 213, 164, 47);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Login_page2a a1 = new Login_page2a();
					a1.setVisible(true);
					a1.setSize(800,600);
					dispose();
					
				       }
				catch(StackOverflowError e1)
				         {
					       e1.printStackTrace();
				         } 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
			
			}
		});
	
		
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(51, 204, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(408, 298, 164, 47);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				try {
				new Register ();
			       } catch(StackOverflowError e1)
			         {
				       e1.printStackTrace();
			         }
			}
		});
	
		
		JButton btnNewButton_3 = new JButton("History");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBackground(new Color(51, 204, 255));
		btnNewButton_3.setBounds(408, 376, 164, 47);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					History h1 = new History();
					h1.setVisible(true);
					h1.setSize(800,600);

				       }
				catch(StackOverflowError e1)
				         {
					       e1.printStackTrace();
				         } 
	            }
	        });

				

		JButton btnNewButton_1_1 = new JButton("Delete Player");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBackground(new Color(51, 204, 255));
		btnNewButton_1_1.setBounds(408, 460, 164, 47);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Delete_Users d1 = new Delete_Users();
					d1.setVisible(true);
					d1.setSize(800,600);
					dispose();
				       }
				catch(StackOverflowError e1)
				         {
					       e1.printStackTrace();
				         } 
				
			}
		});

		
		
	}
	public static void main(String[] args) {
		
		Login_page1 frame = new Login_page1();
					frame.setVisible(true);
		
	}	
}
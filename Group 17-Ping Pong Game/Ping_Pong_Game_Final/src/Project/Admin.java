package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Admin extends JFrame {

	JPanel contentPane;
	JTextField textField;
	Connection con=null;
	Statement stmt;
	ResultSet rs;
	JLabel lblNewLabel_1;
	public Admin() {
		 con = (Connection) e1.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 615);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Enter USER ID To Delete The Player");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(272, 30, 453, 95);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("UserID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(233, 182, 124, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(462, 182, 227, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(344, 332, 227, 47);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     try {
			    	 String userID = textField.getText();
	                	Class.forName("com.mysql.jdbc.Driver");
	                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/register","root", "");
	                    String sql="delete from reg where userID=?";
	                    PreparedStatement pstmt=con.prepareStatement(sql); 
	                    pstmt.setInt(1, Integer.parseInt(userID));
	         
	                    pstmt.executeUpdate();
			   			JOptionPane.showMessageDialog(null, "Record deleted successfully");     //null=Parent Component
			   			dispose();
	                    con.close();
	              
	                }
	                catch(Exception ef)
	                {
	                	JOptionPane.showMessageDialog(null,ef);
	                }
			}
		});
	
		
	
	}
}

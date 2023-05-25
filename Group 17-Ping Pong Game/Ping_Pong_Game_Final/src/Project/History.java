package Project;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class History extends JFrame {

	JPanel contentPane;
	Connection con =null;
	JTable table_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public History() {
		con = (Connection) e1.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show History");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(280, 10, 226, 55);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    String[][] rowData={{"Player 1","Player 2","Score To Win","Winner"}};
                    String[] ColName={"Player 1","Player 2","Score To Win","Winner"};
                    final DefaultTableModel model=new DefaultTableModel(rowData,ColName);
                    final JTable table=new JTable(model);
                    table.setBounds(180,100,430,400);
                    table.setBorder((BorderFactory.createLineBorder(Color.BLACK,1)));
                    getContentPane().add(table);

                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from userhistory");
                    ResultSet r = pst.executeQuery();

                    while (r.next())
                    {
                        String Player_1_name=r.getString("Player 1");
                        String Player_2_name=r.getString("Player 2");
                        String Win=String.valueOf(r.getInt("Score to Win"));
                        String Winner_name=r.getString("Winner");

                        String tbData[]={Player_1_name,Player_2_name,Win,Winner_name};
                        model.addRow(tbData);

                    }

                }catch (Exception d)
                {
                    System.out.println(d);
                }
            }
        });
		
	}
}

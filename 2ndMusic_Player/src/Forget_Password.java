import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

public class Forget_Password {

	 JFrame frame;
	 JTextField txtemail;
	JTextField txtpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forget_Password window = new Forget_Password();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Forget_Password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setBounds(100, 100, 668, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblemail = new JLabel("Enter Email Id :");
		lblemail.setForeground(Color.BLACK);
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblemail.setBounds(108, 112, 177, 27);
		frame.getContentPane().add(lblemail);
		
		JLabel lblpwd = new JLabel("Enter New Password :");
		lblpwd.setForeground(new Color(0, 0, 0));
		lblpwd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpwd.setBounds(108, 176, 177, 27);
		frame.getContentPane().add(lblpwd);
		
		txtemail = new JTextField();
		txtemail.setBounds(316, 116, 200, 23);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtpwd = new JTextField();
		txtpwd.setColumns(10);
		txtpwd.setBounds(316, 180, 200, 23);
		frame.getContentPane().add(txtpwd);
		
		JButton btnsave = new JButton("Save");
		btnsave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsave.setForeground(Color.WHITE);
		btnsave.setBackground(SystemColor.desktop);
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=txtemail.getText();
				String password=txtpwd.getText();
				try
				{
					
				    String url="jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
				    Class.forName("com.mysql.jdbc.Driver");
				    Connection con = DriverManager.getConnection(url, "root", "rutu2012089");
				    
		            Statement st =con.createStatement();
		            String sql= "select * from reg_table where email='"+ email +"'";
		            String sql1= "update reg_table set con_pswd='"+password+"' where email='"+ email +"'";
					
					ResultSet rs=st.executeQuery(sql);			
					if(rs.next())
					{
						st.executeUpdate(sql1);
						JOptionPane.showMessageDialog(null, " Password Change Successfully");
						// Home h=new Home();
						// h.setVisible(true);  
						  
					}
					else
					{
					
						JOptionPane.showMessageDialog(null, " Inorrect username and password...");
						
					}
					con.close();
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
				
			
			}
		});
		btnsave.setBounds(321, 245, 97, 34);
		frame.getContentPane().add(btnsave);
	}
}

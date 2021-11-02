

import java.awt.Color;




import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame
{
	JFrame frmlogin;
	JPanel pnlHeader, pnlHeaderTrack, pnlBody;

	int width = 600, height = 410;
	private JMenuItem mnLogin;
	 JTextField txtemail;
	 JTextField txtpwd1;
	private JLabel lblPwd,lblMusic;
	private JPasswordField txtpwd;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmlogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginPage()
	{
				
		
		funBaajaDecoration();
			
		
	}
	
	
	public void init()
	{
		frmlogin.setVisible(true);
	}
	
	

	public void funBaajaDecoration()
	{
		frmlogin = new JFrame();
		frmlogin.setSize(833, 515);
		//frmBaaja.setBounds(100, 100, 1001, 629);
		frmlogin.setLocationRelativeTo(null);
		frmlogin.setUndecorated(true);
		frmlogin.getContentPane().setLayout(null);
	
		
		pnlHeader=new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(0, 0, 833,50);
		pnlHeader.setLayout(null);
		frmlogin.getContentPane().add(pnlHeader);
		
	
	    
		
		lblMusic=new JLabel("Music Player");
		lblMusic.setBounds(50,5,664,40);
		lblMusic.setHorizontalAlignment(SwingConstants.LEFT);
		lblMusic.setForeground(new Color(255, 102, 0));
		lblMusic.setFont(new Font("Times New Roman",Font.BOLD,28));
		pnlHeader.add(lblMusic);
		
		
		JButton btnClose = new JButton();
		btnClose.setText("X");
		btnClose.setForeground(Color.WHITE);
		btnClose.setBounds(751, 5, 72, 40);
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 27));
		btnClose.setToolTipText("Close");
		btnClose.setBackground(Color.RED);
		btnClose.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
		    {
				
					ExitFrame exitFrameObj = new ExitFrame();
					exitFrameObj.exitframe();
		    }          
		});
	
		
		
		pnlHeader.add(btnClose);
		
		JButton btnMin = new JButton();
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmlogin.setState(ICONIFIED);
				
			}
		});
		btnMin.setToolTipText("Close");
		btnMin.setText("-");
		btnMin.setForeground(Color.WHITE);
		btnMin.setFont(new Font("Times New Roman", Font.BOLD, 29));
		btnMin.setBackground(Color.RED);
		btnMin.setBounds(685, 5, 52, 40);
		pnlHeader.add(btnMin);
		
		/*
		
		btnClose.setIcon(iconClose);
		pnlHeader.add(btnClose);
		*/
		pnlHeaderTrack = new JPanel();
		pnlHeaderTrack.setBackground(Color.LIGHT_GRAY);
		pnlHeaderTrack.setBounds(0, 52, 833,32);
		pnlHeaderTrack.setLayout(null);
		frmlogin.getContentPane().add(pnlHeaderTrack);
		
		mnLogin = new JMenuItem("Login");
		mnLogin.setBackground(Color.LIGHT_GRAY);
		mnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnLogin.setBounds(700, -2, 133, 34);
		pnlHeaderTrack.add(mnLogin);
	
		frmlogin.setFocusable(false);
		

		
		pnlBody = new JPanel();
		pnlBody.setForeground(Color.MAGENTA);
		pnlBody.setBackground(Color.WHITE);
		pnlBody.setBounds(0, 84, 833,428);
		pnlBody.setLayout(null);
		frmlogin.getContentPane().add(pnlBody);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtemail.setToolTipText("Enter Email");
		txtemail.setBounds(373, 127, 256, 28);
		pnlBody.add(txtemail);
		txtemail.setColumns(10);
		/*
		
		txtpwd1 = new JTextField();
		txtpwd1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpwd1.setToolTipText("Enter Password");
		txtpwd1.setBounds(373, 195, 256, 28);
		pnlBody.add(txtpwd1);
		txtpwd1.setColumns(10);
		*/
		txtpwd = new JPasswordField();
		txtpwd.setBounds(373, 196, 256, 26);
		pnlBody.add(txtpwd);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
				    String url="jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
				    Class.forName("com.mysql.jdbc.Driver");
				    Connection con = DriverManager.getConnection(url, "root", "rutu2012089");
				    
		            Statement st =con.createStatement();
		            String sql = "Select email, con_pswd from reg_table where email='"+txtemail.getText()+"' and con_pswd= '"+ txtpwd.getText().toString()+"'";
					
					ResultSet rs = st.executeQuery(sql);
					
					 //String query = "Select uname from registration";
					String email=txtemail.getText();
					 AccessEmail.setEmail(email);
					 //System.out.println(AccessEmail.getEmailId());
					if(rs.next())
					{
						//JOptionPane.showMessageDialog(null, " Login Succesfully Created");
						 Home h=new Home();
						 h.frmHome.setVisible(true);
						
						
						  
						  
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
			
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnlogin.setForeground(Color.WHITE);
		btnlogin.setBackground(new Color(255, 140, 0));
		btnlogin.setBounds(226, 270, 137, 38);
		pnlBody.add(btnlogin);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(226, 128, 137, 27);
		pnlBody.add(lblEmail);
		
		lblPwd = new JLabel("Password  :");
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPwd.setBounds(226, 196, 137, 27);
		pnlBody.add(lblPwd);
		
		JButton btnNewUser = new JButton("New User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration r=new Registration();
				r.frmreg.setVisible(true);			}
		});
		btnNewUser.setForeground(Color.WHITE);
		btnNewUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewUser.setBackground(SystemColor.desktop);
		btnNewUser.setBounds(433, 270, 137, 38);
		pnlBody.add(btnNewUser);
		
		JLabel lblForget = new JLabel("Forget Password ?");
		lblForget.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Forget_Password fpObj=new Forget_Password();
				fpObj.frame.setVisible(true);
				
				
			}
		});
		lblForget.setForeground(Color.BLUE);
		lblForget.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblForget.setBounds(326, 340, 233, 20);
		pnlBody.add(lblForget);
		
		
		
		
	
		
		
		TitledBorder bdrNetwork = new TitledBorder("Tracks");
		bdrNetwork.setTitleColor(new Color(0,255,255));
	    bdrNetwork.setTitleJustification(TitledBorder.CENTER);
	    bdrNetwork.setTitlePosition(TitledBorder.TOP);
		
	   
		
		
		
		
		
		
	}//decoration()_method closed here
}

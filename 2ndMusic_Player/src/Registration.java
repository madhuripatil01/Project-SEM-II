import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class Registration extends JFrame
{

	JFrame frmreg;
	JPanel pnlHeader, pnlHeaderTrack, pnlBody;

	int width = 600, height = 410;
	private JTextField txtUname;
	private JTextField txtContact;
	private JLabel lblPwd,lblMusic;
	private JLabel lblContactNo;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JTextField txtemail;
	private JTextField txtpwd1;
	
	private JTextField txtconpwd1;
	private JLabel numlbl;
	private JLabel conpwd_lbl;
	private JLabel pwd_lbl;
	private JPasswordField txtpwd;
	private JPasswordField txtconpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frmreg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmreg = new JFrame();
		frmreg.setSize(833, 515);
		frmreg.setLocationRelativeTo(null);
		frmreg.setUndecorated(true);
		frmreg.getContentPane().setLayout(null);
	
		
		pnlHeader=new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(0, 0, 833,50);
		pnlHeader.setLayout(null);
		frmreg.getContentPane().add(pnlHeader);
	
	    
		
		lblMusic=new JLabel("Music Player");
		lblMusic.setBounds(44,5,639,40);
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
		
		JButton btnMin = new JButton();
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmreg.setState(ICONIFIED);
				
			}
		});
		btnMin.setToolTipText("Close");
		btnMin.setText("-");
		btnMin.setForeground(Color.WHITE);
		btnMin.setFont(new Font("Times New Roman", Font.BOLD, 29));
		btnMin.setBackground(Color.RED);
		btnMin.setBounds(689, 5, 52, 40);
		pnlHeader.add(btnMin);
	
		ImageIcon iconClose = new ImageIcon("src/assets/PNGClose.png");
		Image imageClose = iconClose.getImage();
		imageClose = imageClose.getScaledInstance(39,39, Image.SCALE_SMOOTH);
		iconClose.setImage(imageClose);

		
		btnClose.setIcon(iconClose);
		pnlHeader.add(btnClose);
		
		/*
		
		btnClose.setIcon(iconClose);
		pnlHeader.add(btnClose);
		*/
		pnlHeaderTrack = new JPanel();
		pnlHeaderTrack.setBackground(Color.LIGHT_GRAY);
		pnlHeaderTrack.setBounds(0, 52, 833,32);
		pnlHeaderTrack.setLayout(null);
		frmreg.getContentPane().add(pnlHeaderTrack);
	
		
		
		frmreg.setFocusable(false);
		
		
		funBaajaDecoration();
		
		
	}
	public void init()
	{
		frmreg.setVisible(true);
	}
	
	public void funBaajaDecoration()
	{
		pnlBody = new JPanel();
		pnlBody.setForeground(Color.MAGENTA);
		pnlBody.setBackground(Color.WHITE);
		pnlBody.setBounds(0, 84, 833,428);
		pnlBody.setLayout(null);
		frmreg.getContentPane().add(pnlBody);
		
		JLabel nlbl = new JLabel("");
		nlbl.setForeground(Color.RED);
		nlbl.setHorizontalAlignment(SwingConstants.TRAILING);
		nlbl.setBounds(618, 49, 176, 20);
		pnlBody.add(nlbl);
		
		
		txtUname = new JTextField();
		txtUname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERNS="^[a-zA-Z]{0,30}$";
				Pattern patt=Pattern.compile(PATTERNS);
				Matcher match=patt.matcher(txtUname.getText());
				if(!match.matches())
				{
					nlbl.setText("Naming is incorrect");
					
				}
				else
				{
					nlbl.setText(null);
					
				}
			}
		});
		txtUname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUname.setToolTipText("Enter Username");
		txtUname.setBounds(393, 41, 256, 28);
		pnlBody.add(txtUname);
		txtUname.setColumns(10);
		
		JLabel email_lbl = new JLabel("");
		email_lbl.setHorizontalAlignment(SwingConstants.TRAILING);
		email_lbl.setForeground(Color.RED);
		email_lbl.setBounds(618, 154, 176, 20);
		pnlBody.add(email_lbl);
		
		txtContact = new JTextField();
		txtContact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String PATTERNS="^[789][0-9]{9}$";
				Pattern patt=Pattern.compile(PATTERNS);
				Matcher match=patt.matcher(txtContact.getText());
				if(!match.matches())
				{
					numlbl.setText("Invalid Number");
					
				}
				else
				{
					numlbl.setText(null);
					
				}
			}
		});
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContact.setBounds(393, 94, 256, 28);
		pnlBody.add(txtContact);
		txtContact.setColumns(10);
		
		
		JLabel lblUname = new JLabel("Username  :");
		lblUname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUname.setBounds(226, 38, 137, 27);
		pnlBody.add(lblUname);
		
		lblPwd = new JLabel("Email :");
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPwd.setBounds(226, 139, 137, 27);
		pnlBody.add(lblPwd);
		
		lblContactNo = new JLabel("Contact No:");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNo.setBounds(226, 92, 137, 27);
		pnlBody.add(lblContactNo);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(226, 198, 137, 27);
		pnlBody.add(lblPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfirmPassword.setBounds(226, 255, 166, 28);
		pnlBody.add(lblConfirmPassword);
		
		numlbl = new JLabel("");
		numlbl.setHorizontalAlignment(SwingConstants.TRAILING);
		numlbl.setForeground(Color.RED);
		numlbl.setBounds(618, 94, 176, 20);
		pnlBody.add(numlbl);
		
		
		txtemail = new JTextField();
		txtemail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERNS="^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z0-9]{0,5}$";
				Pattern patt=Pattern.compile(PATTERNS);
				Matcher match=patt.matcher(txtemail.getText());
				if(!match.matches())
				{
					email_lbl.setText("Invalid Email ID");
					
				}
				else
				{
					email_lbl.setText(null);
					
				}
				
				
			}
		});
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtemail.setColumns(10);
		txtemail.setBounds(393, 146, 256, 28);
		pnlBody.add(txtemail);
		
		conpwd_lbl = new JLabel("");
		conpwd_lbl.setHorizontalAlignment(SwingConstants.TRAILING);
		conpwd_lbl.setForeground(Color.RED);
		conpwd_lbl.setBounds(618, 263, 176, 20);
		pnlBody.add(conpwd_lbl);
		
		pwd_lbl = new JLabel("");
		pwd_lbl.setHorizontalAlignment(SwingConstants.TRAILING);
		pwd_lbl.setForeground(Color.RED);
		pwd_lbl.setBounds(618, 208, 176, 20);
		pnlBody.add(pwd_lbl);
		
		txtpwd = new JPasswordField();
		txtpwd.setBounds(393, 205, 256, 28);
		pnlBody.add(txtpwd);
		
		txtconpwd = new JPasswordField();
		txtconpwd.setBounds(393, 251, 256, 28);
		
	
		
		
		
		txtconpwd.addKeyListener(new KeyAdapter() {
			
			
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(txtpwd.getText().equals(txtconpwd.getText())  )
				{
					conpwd_lbl.setText(null);
				
				}
				else
				{
					//conpwd_lbl.setText(null);
					conpwd_lbl.setText("Invalid Password");
				}
			}
		});
		pnlBody.add(txtconpwd);
	
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = txtUname.getText();
				String email = txtContact.getText();
				String contact_no = txtemail.getText();
				String pswd = txtpwd.getText();
				String con_pswd = txtconpwd.getText();
				
				try
				{
					
				    String url="jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
				    Class.forName("com.mysql.jdbc.Driver");
				    Connection con = DriverManager.getConnection(url, "root", "rutu2012089");
				    
		
					
					String query = "INSERT INTO reg_table values('" + uname + "', '" + email +"' , "
							                                          + "'"+ contact_no +"', '" + pswd + "' , '" + con_pswd +"')";
					
					Statement st = con.createStatement();
					int x = st.executeUpdate(query);
					if(x == 0)
					{
						  JOptionPane.showMessageDialog(btnregister, "Alreadt Exist");
						  
					}
					else
					{
						LoginPage lobj=new LoginPage();
						lobj.frmlogin.setVisible(true);
						
						
					}
					con.close();
					
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
				
			}
		});
		
		btnregister.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnregister.setForeground(Color.WHITE);
		btnregister.setBackground(new Color(255, 140, 0));
		btnregister.setBounds(257, 316, 137, 38);
		pnlBody.add(btnregister);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage l=new LoginPage();
				l.frmlogin.setVisible(true);
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBackground(SystemColor.desktop);
		btnLogin.setBounds(433, 316, 137, 38);
		pnlBody.add(btnLogin);
		
		
		
	
		TitledBorder bdrNetwork = new TitledBorder("Tracks");
		bdrNetwork.setTitleColor(new Color(0,255,255));
	    bdrNetwork.setTitleJustification(TitledBorder.CENTER);
	    bdrNetwork.setTitlePosition(TitledBorder.TOP);
	
		
	}
}

	


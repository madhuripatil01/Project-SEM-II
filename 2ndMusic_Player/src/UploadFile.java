import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UploadFile extends JFrame{

	
	
	JPanel pnlHeader, pnlHeaderTrack, pnlBody;
	JFrame frame;
	private JTextField txtSong;
	private JTextField textSName;
	private JTextField txtArtist;
	private JComboBox comboBox;
	private JLabel lblcategory;
	private JButton btnSave;

	int width = 600, height = 410;
	private JTextField txtUname;
	private JTextField txtemail;
	private JLabel lblPwd,lblBaaja;
	private JLabel lblContactNo;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JTextField txtContact;
	private JTextField txtpwd;
	private JTextField txtconpwd;
	//FileNameExtensionFilter filter ;
	String filename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadFile window = new UploadFile();
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
	public UploadFile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(833, 515);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
	
		
		pnlHeader=new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(0, 0, 833,50);
		pnlHeader.setLayout(null);
		frame.getContentPane().add(pnlHeader);
		
	
	
	    
		
		lblBaaja=new JLabel("Music Player");
		lblBaaja.setBounds(50,5,664,40);
		lblBaaja.setHorizontalAlignment(SwingConstants.LEFT);
		lblBaaja.setForeground(new Color(255, 102, 0));
		lblBaaja.setFont(new Font("Times New Roman",Font.BOLD,28));
		pnlHeader.add(lblBaaja);
		
		
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
		frame.getContentPane().add(pnlHeaderTrack);
		
		JMenuItem mnprev= new JMenuItem("<<");
		mnprev.setBackground(Color.LIGHT_GRAY);
		mnprev.setFont(new Font("Segoe UI Semilight", Font.BOLD, 21));
		mnprev.setBounds(10, 0, 78, 34);
		mnprev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home h=new Home();
				h.frmHome.setVisible(true);
				
			
			}
		});
		pnlHeaderTrack.add(mnprev);
		
	
	
		frame.setFocusable(false);
		pnlBody = new JPanel();
		pnlBody.setForeground(Color.MAGENTA);
		pnlBody.setBackground(Color.WHITE);
		pnlBody.setBounds(0, 84, 833,428);
		pnlBody.setLayout(null);
		frame.getContentPane().add(pnlBody);
		
		//////////////////////////////////////  keyListener ends here  ////////////////////////////
		funBaajaDecoration();
		
		
	}
	public void init()
	{
		frame.setVisible(true);
	}//init()_method closed here
	
	public void funBaajaDecoration()
	{
		
		JButton btnSong = new JButton("Select Song");
		btnSong.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSong.setBounds(137, 65, 140, 25);
		pnlBody.add(btnSong);
		btnSong.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				JFileChooser ch = new JFileChooser();
				ch.showOpenDialog(null);
				//ch.setFileFilter(filter);
				File f = ch.getSelectedFile();
				
				filename = f.getAbsolutePath();
				//f.getAbsoluteFile();
				filename=filename.replace("\\", "\\\\");
				txtSong.setText(filename);
				
			
			}
		});
		
		
		txtSong = new JTextField();
		txtSong.setBounds(341, 59, 252, 19);
		pnlBody.add(txtSong);
		txtSong.setColumns(10);
		
		
		JLabel lblSongName = new JLabel("Song Name");
		lblSongName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSongName.setBounds(137, 119, 140, 21);
		pnlBody.add(lblSongName);
		
		textSName = new JTextField();
		textSName.setBounds(341, 120, 252, 19);
		pnlBody.add(textSName);
		textSName.setColumns(10);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArtist.setBounds(137, 191, 45, 16);
		pnlBody.add(lblArtist);
		
		txtArtist = new JTextField();
		txtArtist.setBounds(341, 192, 252, 19);
		pnlBody.add(txtArtist);
		txtArtist.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bollywood", "Hollywood", "Tollywood", "Other"}));
		comboBox.setBounds(341, 253, 252, 21);
		pnlBody.add(comboBox);
		
		lblcategory = new JLabel("Catogary");
		lblcategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcategory.setBounds(137, 255, 97, 17);
		pnlBody.add(lblcategory);
		
		btnSave = new JButton("Save");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(SystemColor.desktop);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(300, 324, 97, 25);
		pnlBody.add(btnSave);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String song = txtSong.getText();
				String sname =textSName.getText();	
				String artist = txtArtist.getText();
				String category = comboBox.getSelectedItem().toString();
			
				
				
				if(song.equals(null) && sname.equals(null) && artist.equals(null))
				{
					JOptionPane.showMessageDialog(null, "All Feilds is Mandatory");
				}
			
				else
				{
				
				try
				{
					
				    String url="jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
				    Class.forName("com.mysql.jdbc.Driver");
				    Connection con = DriverManager.getConnection(url, "root", "rutu2012089");
				    
		
					String email=AccessEmail.getEmailId();
					
					String query = "INSERT INTO songs_list values('" + song + "', '" + sname +"' , "
							                                          + "'"+ artist +"', '" + category + "','"+email+"' )";
					
					Statement st = con.createStatement();
					int x = st.executeUpdate(query);
					if(x == 0)
					{
						

						  JOptionPane.showMessageDialog(btnSave, "Alreadt Exist");
						  
					}
					else
					{
						JOptionPane.showMessageDialog(btnSave,"Succesfully Added");
								
						
						
					}
					con.close();
					
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
				
			
			  }
			}
		});
		
	
		
		TitledBorder bdrNetwork = new TitledBorder("Tracks");
		bdrNetwork.setTitleColor(new Color(0,255,255));
	    bdrNetwork.setTitleJustification(TitledBorder.CENTER);
	    bdrNetwork.setTitlePosition(TitledBorder.TOP);
	
		
	
		
		
		
	}
	
}

	


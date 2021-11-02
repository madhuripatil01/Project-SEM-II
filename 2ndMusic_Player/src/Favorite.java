import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.AbstractListModel;
import javax.swing.event.MenuKeyListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Favorite extends JFrame{

	JFrame frmFav;
	JPanel pnlHeader, pnlHeaderTrack, pnlBody, pnlBodyList;
	JLabel lblMusic, lblLogo, lblAni;
	JButton btnClose;
	JTable table;
	DefaultTableModel model=new DefaultTableModel();
	
	
	int width = 600, height = 410;
	 JMenuItem mnAlbum;
	 JMenuItem mnFavorite;
	 JButton btnUpload;
	 JButton btnUpload_1;
	 JMenuItem mnLogin;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Favorite window = new Favorite();
					window.frmFav.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Favorite() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFav = new JFrame();
		frmFav.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frmFav.setSize(833, 515);
		frmFav.setLocationRelativeTo(null);
		frmFav.setUndecorated(true);
		frmFav.getContentPane().setLayout(null);
	
		
		pnlHeader=new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(0, 0, 833,50);
		pnlHeader.setLayout(null);
		frmFav.getContentPane().add(pnlHeader);
		
	
	
		
		
		btnClose = new JButton();
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
				frmFav.setState(ICONIFIED);
				
			}
		});
		btnMin.setToolTipText("Close");
		btnMin.setText("-");
		btnMin.setForeground(Color.WHITE);
		btnMin.setFont(new Font("Times New Roman", Font.BOLD, 29));
		btnMin.setBackground(Color.RED);
		btnMin.setBounds(682, 5, 52, 40);
		pnlHeader.add(btnMin);
		
		lblMusic=new JLabel("Music Player");
		lblMusic.setBounds(50,5,664,40);
		lblMusic.setHorizontalAlignment(SwingConstants.LEFT);
		lblMusic.setForeground(new Color(255, 102, 0));
		lblMusic.setFont(new Font("Times New Roman",Font.BOLD,28));
		pnlHeader.add(lblMusic);
		
		//mml1 = new MoveMouseListener(pnlHeader);
		//pnlHeader.addMouseListener(mml1);
		//pnlHeader.addMouseMotionListener(mml1);
		
		btnClose = new JButton();
		btnClose.setBounds(width-45, 5, 40, 40);
		btnClose.setFont(new Font("Times New Roman",Font.BOLD,9));
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setToolTipText("Close");
		btnClose.setBackground(Color.black);
		
	
		
		pnlHeader.add(btnClose);
		
		pnlHeaderTrack = new JPanel();
		pnlHeaderTrack.setBackground(Color.LIGHT_GRAY);
		pnlHeaderTrack.setBounds(0, 52, 833,32);
		pnlHeaderTrack.setLayout(null);
		frmFav.getContentPane().add(pnlHeaderTrack);
		
		//mml4 = new MoveMouseListener(pnlHeaderTrack);
		
		JMenuItem mnHome = new JMenuItem("Home");
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			Home hobj=new Home();
			hobj.frmHome.setVisible(true);
			}
		});
		
		mnHome.setBackground(Color.LIGHT_GRAY);
		mnHome.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnHome.setBounds(0, -2, 133, 34);
		pnlHeaderTrack.add(mnHome);
		
		mnAlbum = new JMenuItem("Album");
		
		mnAlbum.setBackground(Color.LIGHT_GRAY);
		mnAlbum.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnAlbum.setBounds(126, -2, 133, 34);
		mnAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Album ab=new Album();
				ab.Alframe.setVisible(true);
			
			}
		});
		
	
		pnlHeaderTrack.add(mnAlbum);
		
		
		
		mnFavorite = new JMenuItem("Favorite");
		mnFavorite.setBackground(Color.LIGHT_GRAY);
		mnFavorite.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnFavorite.setBounds(259, -2, 133, 34);
		
		pnlHeaderTrack.add(mnFavorite);
		
		mnLogin = new JMenuItem("Login");
		mnLogin.setBackground(Color.LIGHT_GRAY);
		mnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnLogin.setBounds(700, -2, 133, 34);
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage lobj=new LoginPage();
				lobj.frmlogin.setVisible(true);
			
			}
		});
		pnlHeaderTrack.add(mnLogin);
		
		table=new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Object[] column= {"Favorite List"};
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setBackground(SystemColor.text);
		table.setForeground(Color.BLACK);
		
		JScrollPane pane=new JScrollPane(table);
		pane.setForeground(Color.RED);
		pane.setBounds(102, 100, 511, 242);
		frmFav.getContentPane().add(pane);
		
		funList();
		/*
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Naina", "Ganesh Aarti"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textInactiveText));
		list.setBounds(170, 133, 465, 312);
		frmFav.getContentPane().add(list);
		//pnlHeaderTrack.addMouseListener(mml4);
		//pnlHeaderTrack.addMouseMotionListener(mml4);
		 * */
		
	}
	void funList()
	{
		
		try
		{
			
		    String url="jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection(url, "root", "rutu2012089");
		    
              Statement  st=con.createStatement();
              
              String email=AccessEmail.getEmailId();
			String query = "select * from favoritelist where email='"+email+"' ";
			//PreparedStatement pat=(PreparedStatement) con.prepareStatement(query);
			ResultSet rs=st.executeQuery(query);
			
			//ResultSetMetaData stData=rs.getMetaData();
			//int c=stData.getColumnCount();
			
		
			while(rs.next())
			{
			
			 String song=rs.getString("song");
			 
				String tbModel[]= {song};
				model.addRow(tbModel);
			}
			
	      
			
			
			
			//st.close();
			//rs.close();
			con.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
   }
}

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Other_List extends JFrame{

	JFrame Oframe;

	
	JPanel pnlHeader, pnlHeaderTrack, pnlBody, pnlBodyList;
	JLabel lblBaaja, lblLogo, lblAni;
	JButton btnClose, btnLogo, btnStop, btnMPrev, btnMPP, btnMNext;

	Image imageAni0, imageAni1, imageAni2, imageAni3, imageAni4, imageAni5, imageAni6;
	int width = 600, height = 410;
	private JMenuItem mnAlbum;
	private JMenuItem mnFavorite;
	private JButton btnUpload;
	private JButton btnUpload_1;
	private JMenuItem mnLogin;
	protected Object frame;
	JTable table;
	DefaultTableModel model=new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Other_List window = new Other_List();
					window.Oframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Other_List() {
		Oframe= new JFrame();
		Oframe.setBounds(500, 300, 861, 532);
		Oframe.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		//frmlist.setSize(833, 515);
		Oframe.setLocationRelativeTo(null);
		Oframe.setUndecorated(true);
		Oframe.getContentPane().setLayout(null);
		
		
		pnlHeader=new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(0, 0, 861,50);
		pnlHeader.setLayout(null);
		Oframe.getContentPane().add(pnlHeader);
	
		
	
		
		
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
				Oframe.setState(ICONIFIED);
				
			}
		});
		btnMin.setToolTipText("Close");
		btnMin.setText("-");
		btnMin.setForeground(Color.WHITE);
		btnMin.setFont(new Font("Times New Roman", Font.BOLD, 29));
		btnMin.setBackground(Color.RED);
		btnMin.setBounds(701, 5, 52, 40);
		pnlHeader.add(btnMin);
		
		lblBaaja=new JLabel("Music Player");
		lblBaaja.setBounds(50,5,664,40);
		lblBaaja.setHorizontalAlignment(SwingConstants.LEFT);
		lblBaaja.setForeground(new Color(255, 102, 0));
		lblBaaja.setFont(new Font("Times New Roman",Font.BOLD,28));
		pnlHeader.add(lblBaaja);
		
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
		pnlHeaderTrack.setBounds(0, 52, 861,32);
		pnlHeaderTrack.setLayout(null);
		Oframe.getContentPane().add(pnlHeaderTrack);
		
		//mml4 = new MoveMouseListener(pnlHeaderTrack);
		
		JMenuItem mnHome = new JMenuItem("Home");
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Favorite fv=new Favorite();
				fv.frmFav.setVisible(true);
			
			}
		});
		mnHome.setBackground(Color.LIGHT_GRAY);
		mnHome.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnHome.setBounds(0, -2, 133, 34);
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home h=new Home();
				h.frmHome.setVisible(true);
			
			}
		});
		pnlHeaderTrack.add(mnHome);
		
		mnAlbum = new JMenuItem("Album");
		mnAlbum.setBackground(Color.LIGHT_GRAY);
		mnAlbum.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnAlbum.setBounds(126, -2, 133, 34);
		pnlHeaderTrack.add(mnAlbum);
		
		mnFavorite = new JMenuItem("Favorite");
		mnFavorite.setBackground(Color.LIGHT_GRAY);
		mnFavorite.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnFavorite.setBounds(259, -2, 133, 34);
		mnFavorite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Favorite fv=new Favorite();
				fv.frmFav.setVisible(true);
			
			}
		});
		pnlHeaderTrack.add(mnFavorite);
		
		mnLogin = new JMenuItem("Login");
		mnLogin.setBackground(Color.LIGHT_GRAY);
		mnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnLogin.setBounds(700, -2, 148, 34);
		mnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage lobj=new LoginPage();
				lobj.frmlogin.setVisible(true);
			
			}
		});
		pnlHeaderTrack.add(mnLogin);
		
		table=new JTable();
		Object[] column= {"name","artist","song"};
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		
		JScrollPane pane=new JScrollPane(table);
		pane.setForeground(Color.RED);
		pane.setBounds(102, 100, 511, 242);
		Oframe.getContentPane().add(pane);
		
		//Object[] row= new Object[4];
		
		
		
		// list = new JList();
		//list.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, SystemColor.desktop, null, null));
		//list.setBounds(73, 135, 680, 312);
		//frmlist.getContentPane().add(list);
		
		funList();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	void funList()
	{
		
		try
		{
			
		    String url="jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection(url, "root", "rutu2012089");
		    
              Statement  st=con.createStatement();
              String email=AccessEmail.getEmailId();
  			String query = "select song,song_name,artist from songs_list where caterory = 'Other' and email='"+email+"' ";
			//String query = "select song,song_name,artist from songs_list where caterory = 'Other'";
			//PreparedStatement pat=(PreparedStatement) con.prepareStatement(query);
			ResultSet rs=st.executeQuery(query);
			
			//ResultSetMetaData stData=rs.getMetaData();
			//int c=stData.getColumnCount();
			
		
			while(rs.next())
			{
			 String song_name=rs.getString("song_name");
			 String artist=rs.getString("artist");
			 String song=rs.getString("song");
			 
				String tbModel[]= {song_name,artist,song};
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

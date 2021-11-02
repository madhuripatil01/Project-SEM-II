import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Album extends JFrame
{

	//JFrame frmAlbum;
	JFrame Alframe;
	JPanel pnlHeader, pnlHeaderTrack, pnlBody, pnlBodyList;
	JButton btnClose;
	int width = 600, height = 410;
	 JMenuItem mnAlbum;
	 JMenuItem mnFavorite;
	 JButton btnUpload;
	JButton btnUpload_1;
	 JMenuItem mnLogin;
	
	//protected Object frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Album window= new Album();
					window.Alframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Album() {
		Alframe = new JFrame();
		Alframe.setBounds(500, 300, 861, 532);
		Alframe.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		//frmlist.setSize(833, 515);
		Alframe.setLocationRelativeTo(null);
		Alframe.setUndecorated(true);
		Alframe.getContentPane().setLayout(null);
		
		
		pnlHeader=new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(0, 0, 833,50);
		pnlHeader.setLayout(null);
		Alframe.getContentPane().add(pnlHeader);
	
		
	
		
		
		btnClose = new JButton();
		btnClose.setText("X");
		btnClose.setForeground(Color.WHITE);
		btnClose.setBounds(761, 5, 72, 40);
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
				Alframe.setState(ICONIFIED);
				
			}
		});
		btnMin.setToolTipText("Close");
		btnMin.setText("-");
		btnMin.setForeground(Color.WHITE);
		btnMin.setFont(new Font("Times New Roman", Font.BOLD, 29));
		btnMin.setBackground(Color.RED);
		btnMin.setBounds(701, 5, 52, 40);
		pnlHeader.add(btnMin);
		
	    JLabel lblBaaja = new JLabel("Music Player");
		lblBaaja.setBounds(50,5,609,40);
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
		
		
		pnlHeader=new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(0, 0, 851,50);
		pnlHeader.setLayout(null);
		Alframe.getContentPane().add(pnlHeader);
		
	
		
		JLabel lblmusic = new JLabel("Music Player");
		lblmusic.setBounds(50,5,664,40);
		lblmusic.setHorizontalAlignment(SwingConstants.LEFT);
		lblmusic.setForeground(new Color(255, 102, 0));
		lblmusic.setFont(new Font("Times New Roman",Font.BOLD,28));
		pnlHeader.add(lblmusic);
		
		
		
		pnlHeaderTrack = new JPanel();
		pnlHeaderTrack.setBackground(Color.LIGHT_GRAY);
		pnlHeaderTrack.setBounds(0, 52, 847,32);
		pnlHeaderTrack.setLayout(null);
		Alframe.getContentPane().add(pnlHeaderTrack);
		
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
		
		JButton btnBolly = new JButton("Bollywood");
		btnBolly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Bollywood_List1 al=new Bollywood_List1();
				al.Bframe.setVisible(true);
			}
		});
		btnBolly.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBolly.setBackground(Color.WHITE);
		btnBolly.setForeground(SystemColor.desktop);
		btnBolly.setBounds(100, 120, 283, 157);
		Alframe.getContentPane().add(btnBolly);
		
		JButton btnHolly = new JButton("Hollywood");
		btnHolly.setForeground(SystemColor.desktop);
		btnHolly.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHolly.setBackground(Color.WHITE);
		btnHolly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hollywood_List h=new Hollywood_List();
				h.Hframe.setVisible(true);
			}
		});
		btnHolly.setBounds(443, 119, 293, 157);
		Alframe.getContentPane().add(btnHolly);
		
		JButton btnTolly = new JButton("Tollywood");
		btnTolly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tollywood_List t=new Tollywood_List();
				t.Tframe.setVisible(true);
			}
		});
		btnTolly.setForeground(SystemColor.desktop);
		btnTolly.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTolly.setBackground(Color.WHITE);
		btnTolly.setBounds(100, 306, 283, 157);
		Alframe.getContentPane().add(btnTolly);
		
		JButton btnOther = new JButton("Other");
		btnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Other_List obj=new Other_List();
				obj.Oframe.setVisible(true);
			}
		});
		btnOther.setForeground(SystemColor.desktop);
		btnOther.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnOther.setBackground(Color.WHITE);
		btnOther.setBounds(443, 306, 293, 157);
		Alframe.getContentPane().add(btnOther);
		//fun_Album();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame = new JFrame();
	//	frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
 

	
}

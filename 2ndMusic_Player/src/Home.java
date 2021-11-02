

/*import java.awt.Color;





import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.*;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;

public class Home extends JFrame
{
	JFrame frmHome;
	JPanel pnlHeader, pnlHeaderTrack, pnlBody;
	JLabel lblBaaja, lblLogo, lblAni;
	JButton btnClose, btnPrev, btnPlay, btnPause, btnNext;
	ImageIcon iconBaaja, iconClose, iconLogo, iconStop, iconPrev, iconPlay, iconPause, iconStatic, iconNext;
	Image imageClose, imageBaaja, imageLogo, imageStop, imagePrev, imagePlay, imagePause, imageStatic, imageNext;
	ImageIcon iconAni0, iconAni1, iconAni2, iconAni3, iconAni4, iconAni5, iconAni6;
	Image imageAni0, imageAni1, imageAni2, imageAni3, imageAni4, imageAni5, imageAni6;
	JLabel songNameLabel=new JLabel();
	 JFileChooser fileChooser;
	    FileInputStream fileInput;
	    BufferedInputStream bufferedInputStream;
	    File myFile=null;
	    String filename;
	    String filePath;
	    long totalLength;
	    long pause;
//	    Player player;
	    Thread playThread;
	    Thread resumeThread;
	
	DefaultListModel<String> listModel;
	JList<String> list;
	 JScrollPane scrollPane;
	 Thread t=new Thread();
	
	long pauseLoc, songLength;
	int playstatus=0,filepathresponse,trackNo=0;
	//play status 0 for stop , 1 for playing, 2 for paused
	public Player player;
	
	ExitFrame exitFrameObj;
	

	
	int width = 600, height = 410;
	private JButton btnUpload;
	private JButton btnFav;
	 JList listview;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Home()
	{
				
		frmHome = new JFrame();
		
		frmHome.getContentPane().setForeground(Color.RED);
		frmHome.setSize(833, 515);
		frmHome.setLocationRelativeTo(null);
		frmHome.setUndecorated(true);
		frmHome.getContentPane().setLayout(null);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//////////////////////////////////////keyListener ends here  ////////////////////////////

		
		iconBaaja  = new ImageIcon("src/assets/PNGBaaja.png");
		imageBaaja = iconBaaja.getImage();
		iconBaaja.setImage(imageBaaja);
		frmHome.setIconImage(imageBaaja);
		
		pnlHeader=new JPanel();
		pnlHeader.setForeground(Color.WHITE);
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(0, 0, 833,50);
		pnlHeader.setLayout(null);
		frmHome.getContentPane().add(pnlHeader);
		
		////////////////////////////icon_Logo starts here ////////////////////////////////////
		iconLogo = new ImageIcon("src/assets/PNGBaaja.png");
		imageLogo = iconLogo .getImage();
		imageLogo  = imageLogo .getScaledInstance(39,39, Image.SCALE_SMOOTH);
		iconLogo .setImage(imageLogo );
	    
		
		lblBaaja=new JLabel("Music Player");
		lblBaaja.setBackground(Color.BLACK);
		lblBaaja.setBounds(50,5,691,40);
		lblBaaja.setHorizontalAlignment(SwingConstants.LEFT);
		lblBaaja.setForeground(new Color(255, 102, 0));
		lblBaaja.setFont(new Font("Times New Roman",Font.BOLD,28));
		pnlHeader.add(lblBaaja);
	
		
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
					exitFrameObj = new ExitFrame();
					exitFrameObj.exitframe();
		    }          
		});
		
		
		iconClose  = new ImageIcon("img\\PNGClose.png");
		
	
		pnlHeader.add(btnClose);
		
		pnlHeaderTrack = new JPanel();
		pnlHeaderTrack.setBackground(Color.LIGHT_GRAY);
		pnlHeaderTrack.setBounds(0, 52, 833,32);
		pnlHeaderTrack.setLayout(null);
		frmHome.getContentPane().add(pnlHeaderTrack);
		
		
		JMenuItem mnAlbum = new JMenuItem("Album");
		mnAlbum.setBackground(Color.LIGHT_GRAY);
		mnAlbum.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnAlbum.setBounds(141, 0, 133, 34);
		mnAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Album a=new Album();
				a.Alframe.setVisible(true);
			
			}
		});
		pnlHeaderTrack.add(mnAlbum);
		
		JMenuItem mnFavorite = new JMenuItem("Favorite");
		mnFavorite.setBackground(Color.LIGHT_GRAY);
		mnFavorite.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnFavorite.setBounds(268, 0, 133, 34);
		mnFavorite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Favorite fv=new Favorite();
				fv.frmFav.setVisible(true);
			
			}
		});
		pnlHeaderTrack.add(mnFavorite);
		
		
		JMenuItem mnLogin = new JMenuItem("Login");
		mnLogin.setBackground(Color.LIGHT_GRAY);
		mnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnLogin.setBounds(690, 0, 133, 34);
		mnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage lobj=new LoginPage();
				lobj.frmlogin.setVisible(true);
				
			
			}
		});
		pnlHeaderTrack.add(mnLogin);
		
		
		JMenuItem mnHome= new JMenuItem("Home");
		mnHome.setBackground(Color.LIGHT_GRAY);
		mnHome.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnHome.setBounds(0, 0, 133, 34);
		
		pnlHeaderTrack.add(mnHome);
		
	
		frmHome.setFocusable(false);

		pnlBody = new JPanel();
		pnlBody.setForeground(Color.MAGENTA);
		pnlBody.setBackground(Color.WHITE);
		pnlBody.setBounds(0, 84, 534,428);
		pnlBody.setLayout(null);
		frmHome.getContentPane().add(pnlBody);
		
		
		
	    
	    iconStop  = new ImageIcon("img/PNGStop.png");
	    imageStop = iconStop.getImage();
	    imageStop = imageStop.getScaledInstance(39,39, Image.SCALE_SMOOTH);
	    iconStop.setImage(imageStop);
	    
	
	    btnPrev = new JButton(new ImageIcon("D:\\Java Practicals assignment\\Music_Player\\img\\previous Icon.png"));
	    btnPrev.setForeground(Color.YELLOW);
		btnPrev.setBounds(21, 349, 42, 42);
		btnPrev.setFont(new Font("Times New Roman",Font.BOLD,9));
		btnPrev.setBackground(Color.GREEN);
		btnPrev.setFocusPainted(false);
		btnPrev.setBorderPainted(false);
		btnPrev.setContentAreaFilled(false);
		btnPrev.setToolTipText("Previous");
		btnPrev.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
		    {
				//stopPlayer();
				System.out.println("inside next button");
			    playThread=new Thread(runnablePlay);
		        resumeThread=new Thread(runnableResume);
		        
				try {
				 player.close();
				}catch (Exception exe) {
				System.out.println("player stoped");
				}
				listview.setSelectedIndex(listview.getSelectedIndex()-1);
				
				   playThread.start();
			     songNameLabel.setText("now playing : "+filename);
		    }          

		});
		pnlBody.add(btnPrev);
		
		iconPrev  = new ImageIcon("src/assets/PNGPrevious.png");
	    imagePrev = iconPrev.getImage();
	    imagePrev = imagePrev.getScaledInstance(39,39, Image.SCALE_SMOOTH);
	    iconPrev.setImage(imagePrev);
	    
		btnPlay = new JButton(new ImageIcon("D:\\MCA\\Music_Player\\img\\playIcon.jpg"));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    playThread=new Thread(runnablePlay);
				   playThread.start();
			     songNameLabel.setText("now playing : "+filename);
				play();
				
//				try {
//					 
//					FileInputStream fileInput=new FileInputStream(path);
//					//Player player= new Player(fileInput);
//					//player.play();
//					
//				}
//				catch(FileNotFoundException e1)
//				{
//					e1.printStackTrace();
//				} 
//				if(btnPause.isEnabled()==true)
//				{
//					pause();
//				}
//				
			}
				
		});
		btnPlay.setBounds(70, 343, 95, 55);
		btnPlay.setFont(new Font("Times New Roman",Font.BOLD,9));
		btnPlay.setBackground(Color.RED);
		btnPlay.setFocusPainted(false);
		btnPlay.setBorderPainted(false);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setToolTipText("Play");
	
		
		pnlBody.add(btnPlay);
		
		
		
		iconPlay  = new ImageIcon("src/assets/PNGPlay.png");
	    imagePlay = iconPlay.getImage();
	    imagePlay = imagePlay.getScaledInstance(59,59, Image.SCALE_SMOOTH);
	    iconPlay.setImage(imagePlay);
	    
	    
	    iconPause  = new ImageIcon("src/assets/PNGPause.png");
	    imagePause = iconPause.getImage();
	    imagePause = imagePause.getScaledInstance(59,59, Image.SCALE_SMOOTH);
	    iconPause.setImage(imagePause);
		
		btnPause = new JButton(new ImageIcon("D:\\Java Practicals assignment\\Music_Player\\img\\PauseIcon.png"));
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
      		//pause();
				System.out.println("inside stop  method");
				
				 if(player!=null){
	                try {
	                    pause=fileInput.available();
	                    player.close();
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }
				 }
				
			}
		});
		btnPause.setBounds(139, 338, 63, 63);
		btnPause.setFont(new Font("Times New Roman",Font.BOLD,9));
		btnPause.setBackground(Color.WHITE);
		btnPause.setFocusPainted(false);
		btnPause.setBorderPainted(false);
		btnPause.setContentAreaFilled(false);
		
		btnPause.setToolTipText("Select MP3 files");
	
		
		pnlBody.add(btnPause);
		

		iconNext  = new ImageIcon("src/assets/PNGNext.png");
	    imageNext = iconNext.getImage();
	    imageNext = imageNext.getScaledInstance(39,39, Image.SCALE_SMOOTH);
	    iconNext.setImage(imageNext);
		
		btnNext = new JButton(new ImageIcon("D:\\Java Practicals assignment\\Music_Player\\img\\NextIcon1.png"));
		btnNext.setBounds(212, 349, 42, 42);
		btnNext.setFont(new Font("Times New Roman",Font.BOLD,9));
		btnNext.setBackground(Color.BLACK);
		btnNext.setFocusPainted(false);
		btnNext.setBorderPainted(false);
		btnNext.setContentAreaFilled(false);
		btnNext.setToolTipText("Next");
		btnNext.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
		    {	
				System.out.println("inside next button");
			    playThread=new Thread(runnablePlay);
		        resumeThread=new Thread(runnableResume);
		        
				try {
				 player.close();
				}catch (Exception exe) {
				System.out.println("player stoped");
				}
				listview.setSelectedIndex(listview.getSelectedIndex()+1);
				
				
				   playThread.start();
			     songNameLabel.setText("now playing : "+filename);
		    }          
		});
		pnlBody.add(btnNext);
		

		
		iconAni0  = new ImageIcon("src/assets/animated0.gif");
	    imageAni0 = iconAni0.getImage();
	    imageAni0 = imageAni0.getScaledInstance(350,260, Image.SCALE_DEFAULT);
	    iconAni0.setImage(imageAni0);
	    
	    iconAni1  = new ImageIcon("src/assets/animated1.gif");
	    imageAni1 = iconAni1.getImage();
	    imageAni1 = imageAni1.getScaledInstance(350,260, Image.SCALE_DEFAULT);
	    iconAni1.setImage(imageAni1);
	    
	    iconAni2  = new ImageIcon("assets/animated2.gif");
	    imageAni2 = iconAni2.getImage();
	    imageAni2 = imageAni2.getScaledInstance(260,260, Image.SCALE_DEFAULT);
	    iconAni2.setImage(imageAni2);
	    
	    iconAni3  = new ImageIcon("src/assets/animated3.gif");
	    imageAni3 = iconAni3.getImage();
	    imageAni3 = imageAni3.getScaledInstance(260,260, Image.SCALE_DEFAULT);
	    iconAni3.setImage(imageAni3);
	    
	    iconAni4  = new ImageIcon("src/assets/animated4.gif");
	    imageAni4 = iconAni4.getImage();
	    imageAni4 = imageAni4.getScaledInstance(260,260, Image.SCALE_DEFAULT);
	    iconAni4.setImage(imageAni4);
		
		iconAni5  = new ImageIcon("src/assets/animated5.gif");
	    imageAni5 = iconAni5.getImage();
	    imageAni5 = imageAni5.getScaledInstance(260,260, Image.SCALE_DEFAULT);
	    iconAni5.setImage(imageAni5);
	    
	    iconAni6  = new ImageIcon("src/assets/animated6.gif");
	    imageAni6 = iconAni6.getImage();
	    imageAni6 = imageAni6.getScaledInstance(260,260, Image.SCALE_DEFAULT);
	    iconAni6.setImage(imageAni6);
	    
	    
	    iconStatic  = new ImageIcon("src/assets/LogoBaajaPNG.png");
	    imageStatic = iconStatic.getImage();
	    imageStatic = imageStatic.getScaledInstance(330,200, Image.SCALE_DEFAULT);
	    iconStatic.setImage(imageStatic);
		
		lblAni=new JLabel(new ImageIcon("D:\\Java Practicals assignment\\Music_Player\\img\\ani1.jpg"));
		lblAni.setBackground(Color.LIGHT_GRAY);
		lblAni.setBounds(32,10,492,246);
		pnlBody.add(lblAni);
		
		JButton btnVolumn = new JButton(new ImageIcon("D:\\Java Practicals assignment\\Music_Player\\img\\VolumeIcon.png"));
		btnVolumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volumnDownControl(12);
			}
		});
		btnVolumn.setToolTipText("Volume");
		btnVolumn.setForeground(Color.YELLOW);
		btnVolumn.setFont(new Font("Times New Roman", Font.BOLD, 9));
		btnVolumn.setFocusPainted(false);
		btnVolumn.setContentAreaFilled(false);
		btnVolumn.setBorderPainted(false);
		btnVolumn.setBackground(Color.GREEN);
		btnVolumn.setBounds(264, 334, 95, 70);
		pnlBody.add(btnVolumn);
		
		btnUpload = new JButton(new ImageIcon("D:\\Java Practicals assignment\\Music_Player\\img\\DownloadIcon.png"));
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadFile u=new UploadFile();
				u.frame.setVisible(true);
				
			}
		});
		btnUpload.setToolTipText("Stop");
		btnUpload.setForeground(Color.YELLOW);
		btnUpload.setFont(new Font("Times New Roman", Font.BOLD, 9));
		btnUpload.setFocusPainted(false);
		btnUpload.setContentAreaFilled(false);
		btnUpload.setBorderPainted(false);
		btnUpload.setBackground(Color.GREEN);
		btnUpload.setBounds(330, 334, 110, 67);
		pnlBody.add(btnUpload);
		
		btnFav = new JButton(new ImageIcon("D:\\Java Practicals assignment\\Music_Player\\img\\FavoriteIcon.png"));
		btnFav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fun_fav();
			}
		});
		btnFav.setToolTipText("Stop");
		btnFav.setForeground(Color.YELLOW);
		btnFav.setFont(new Font("Times New Roman", Font.BOLD, 9));
		btnFav.setFocusPainted(false);
		btnFav.setContentAreaFilled(false);
		btnFav.setBorderPainted(false);
		btnFav.setBackground(Color.GREEN);
		btnFav.setBounds(395, 334, 101, 70);
		pnlBody.add(btnFav);
		
		JSlider slider = new JSlider();
		slider.setBounds(90, 281, 374, 30);
		pnlBody.add(slider);
		
		TitledBorder bdrNetwork = new TitledBorder("Tracks");
		bdrNetwork.setTitleColor(new Color(0,255,255));
	    bdrNetwork.setTitleJustification(TitledBorder.CENTER);
	    bdrNetwork.setTitlePosition(TitledBorder.TOP);
	    
	   
		
		listview = new JList();
		listview.setBounds(533, 83, 300, 429);
		frmHome.getContentPane().add(listview);
		
		
		funList();
			
		
	}//constructor closed here
	
	
	public void init()
	{
		frmHome.setVisible(true);
	}//init()_method closed here
	
	
	void funList()
	{
		
		try
		{
			
			 String url="jdbc:mysql://localhost:3306/users1";
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con = DriverManager.getConnection(url, "root", "madhu20");
		    
            String email=AccessEmail.getEmailId();
			
			String query = "select * from songs_list where email='"+email+"'";
			PreparedStatement pat=(PreparedStatement) con.prepareStatement(query);
			ResultSet rs=pat.executeQuery();
			
			DefaultListModel DML = new DefaultListModel();
			
			while(rs.next())
			{
				DML.addElement(rs.getString("song"));
				
			}
			listview.setModel(DML);
			
			
			
	      
		
			pat.close();
			rs.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}

        
	}
	public void fun_fav()
	{
		try
		{
			
			String url="jdbc:mysql://localhost:3306/users1";
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection(url, "root", "madhu20");
		    
		    
		    String s=(String) listview.getSelectedValue();
            
		    String email=AccessEmail.getEmailId();
		    
		    String query = "INSERT INTO favoritelist values('" + s + "','"+email+"')";

             Statement st = con.createStatement();
             int x = st.executeUpdate(query);
            if(x == 0)
            {


                    JOptionPane.showMessageDialog(btnFav, "Alreadt Exist");

            }
            else
            {
                     JOptionPane.showMessageDialog(btnFav,"Succesfully Added");



             }
              con.close();

         }
      catch(Exception exception)
       {
            exception.printStackTrace();
       }


    }
	
		public void play()
		{
			try {
			  String str=(String) listview.getSelectedValue();
			  System.out.println(str);
			  FileInputStream fileInput=new FileInputStream(str);
				Player player= new Player(fileInput);
				player.play();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		public void pause()
		{
			try {
				String str=(String) listview.getSelectedValue();
				FileInputStream fileInput=new FileInputStream(str);
				Player player= new Player(fileInput);
				player.close();
			}
			catch(FileNotFoundException e1)
 			{
				e1.printStackTrace();
			} 
			catch (JavaLayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
			
    
		
	
	private void volumnDownControl(double value)
	{
		// TODO Auto-generated method stub
		Mixer.Info[] mixers = AudioSystem.getMixerInfo();
		for(Mixer.Info mixerInfo :mixers) {
			Mixer mixer = AudioSystem.getMixer(mixerInfo);
			Line.Info[] lineInfos =mixer.getTargetLineInfo();
			for(Line.Info lineInfo : lineInfos)
			{
				Line line = null;
				boolean opened =true;
				
				try
				{
					line = mixer.getLine(lineInfo);
					opened=line.isOpen()|| line instanceof Clip;
					if(!opened)
					{
						line.open();
					}
					FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
							
					float currentVolumn = volControl.getValue();
				
					
					Double volumnToCut = value;
					float Changedval = (float) ((float)currentVolumn - (double)volumnToCut);
					volControl.setValue(Changedval);
					
				}
				catch(LineUnavailableException e)
				{
					
				}
				catch(IllegalArgumentException e1)
				{
					
				}
				finally
				{
					if(line != null && !opened)
					{
						line.close();
					}
				}
			}
		}
	}



//public void actionPerformed(ActionEvent e) {
//	
//	
//	// TODO Auto-generated method stub
//	if(e.getSource()==btnPlay)
//     {
//       //  t.start();
//		try {
//			 
//			 String str=(String) listview.getSelectedValue();
//		  System.out.println(str);
//			  FileInputStream fileInput=new FileInputStream(str);
//				Player player= new Player(fileInput);
//				player.play();
//			
//		}
//		catch(FileNotFoundException e1)
//		{
//			e1.printStackTrace();
//		} 
//		catch (JavaLayerException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//	
//	
//     }
//	else if(e.getSource()==btnPause)
//	{
//		//t.stop();
//		player.close();
//	
//	}
//
//}
	 Runnable runnablePlay=new Runnable() {
	      @Override
	      public void run() {
	          try {
	              //code for play button
	        	
				  String str=(String) listview.getSelectedValue();
				  System.out.println("songs==="+str);
				  System.out.println(str);
				   fileInput=new FileInputStream(str);
	              bufferedInputStream=new BufferedInputStream(fileInput);
	              player=new Player(bufferedInputStream);
	              totalLength=fileInput.available();
	              player.play();//starting music
	          } catch (FileNotFoundException e) {
	              e.printStackTrace();
	          } catch (JavaLayerException e) {
	              e.printStackTrace();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	  };

	    Runnable runnableResume=new Runnable() {
	        @Override
	        public void run() {
	            try {
	  			  String str=(String) listview.getSelectedValue();
	  			  System.out.println(str);
	  			   fileInput=new FileInputStream(str);
	                bufferedInputStream=new BufferedInputStream(fileInput);
	                player=new Player(bufferedInputStream);
	                fileInput.skip(totalLength-pause);
	                player.play();
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	            } catch (JavaLayerException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    };
	    
}
*/

import java.awt.Color;






import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

//import com.sun.org.apache.xerces.internal.util.URI;

//import com.mysql.jdbc.PreparedStatement;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class Home extends JFrame 
{
	JFrame frmHome;
	JPanel pnlHeader, pnlHeaderTrack, pnlBody;
	JLabel lblBaaja, lblLogo, lblAni;
//	JButton btnClose, btnPrev, btnPlay1, btnPause1, btnNext;
	ImageIcon iconBaaja, iconClose, iconLogo, iconStop, iconPrev, iconPlay, iconPause, iconStatic, iconNext;
	Image imageClose, imageBaaja, imageLogo, imageStop, imagePrev, imagePlay, imagePause, imageStatic, imageNext;
	ImageIcon iconAni0, iconAni1, iconAni2, iconAni3, iconAni4, iconAni5, iconAni6;
	Image imageAni0, imageAni1, imageAni2, imageAni3, imageAni4, imageAni5, imageAni6;
	
	JLabel songNameLabel=new JLabel();
    JButton selectButton=new JButton("Select Mp3");
    JButton btnPrev =new JButton(new ImageIcon("C:\\Users\\user\\Downloads\\Music_PlayerV2\\Music_PlayerV2\\img\\previous Icon.png"));
    JButton playButton=new JButton(new ImageIcon("C:\\Users\\user\\Downloads\\Music_PlayerV2\\Music_PlayerV2\\img\\playIcon.jpg"));
    JButton pauseButton=new JButton(new ImageIcon("C:\\Users\\user\\Downloads\\Music_PlayerV2\\Music_PlayerV2\\img\\PauseIcon.png"));
    JButton resumeButton=new JButton(new ImageIcon("C:\\Users\\user\\Downloads\\Music_PlayerV2\\Music_PlayerV2\\img\\resume.png"));
    JButton stopButton=new JButton(new ImageIcon("C:\\Users\\user\\Downloads\\Music_PlayerV2\\Music_PlayerV2\\img\\stop.png"));
    JButton btnNext =new JButton(new ImageIcon("C:\\Users\\user\\Downloads\\Music_PlayerV2\\Music_PlayerV2\\img\\NextIcon1.png"));
    JButton btnFav =new JButton(new ImageIcon("C:\\Users\\user\\Downloads\\Music_PlayerV2\\Music_PlayerV2\\img\\FavoriteIcon.png"));
    JButton btnUpload =new JButton(new ImageIcon("D:\\MCA\\Music_Player\\img\\DownloadIcon.png"));
    JButton btnClose =new JButton(new ImageIcon("E:\\MCA Practicals\\JAVA\\Music_PlayerV2\\img\\PNGClose.png"));//E:\MCA Practicals\JAVA\Music_PlayerV2\img
    JButton btnVolumn = new JButton(new ImageIcon("C:\\Users\\user\\Downloads\\Music_PlayerV2\\Music_PlayerV2\\img\\VolumeIcon.png"));
    
    
   // soundVolume sound=new soundVolume();
    JFileChooser fileChooser;
    FileInputStream fileInput;
    BufferedInputStream bufferedInputStream;
    File myFile=null;
    String filename;
    String filePath;
    long totalLength;
    long pause;
//    Player player;
    Thread playThread;
    Thread resumeThread;
	
	
	
	DefaultListModel<String> listModel;
	JList<String> list;
	 JScrollPane scrollPane;
	 Thread t=new Thread();
	
	long pauseLoc, songLength;
	int playstatus=0,filepathresponse,trackNo=0;
	//play status 0 for stop , 1 for playing, 2 for paused
	public Player player;
	
	ExitFrame exitFrameObj;
	

	
	int width = 600, height = 410;
	
	
	 JList listview;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Home()
	{
				
		frmHome = new JFrame();
		
		frmHome.getContentPane().setForeground(Color.RED);
		frmHome.setSize(833, 515);
		frmHome.setLocationRelativeTo(null);
		frmHome.setUndecorated(true);
		frmHome.getContentPane().setLayout(null);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//////////////////////////////////////keyListener ends here  ////////////////////////////

		
		iconBaaja  = new ImageIcon("src/assets/PNGBaaja.png");
		imageBaaja = iconBaaja.getImage();
		iconBaaja.setImage(imageBaaja);
		frmHome.setIconImage(imageBaaja);
		
		pnlHeader=new JPanel();
		pnlHeader.setForeground(Color.WHITE);
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(0, 0, 833,50);
		pnlHeader.setLayout(null);
		frmHome.getContentPane().add(pnlHeader);
		
		////////////////////////////icon_Logo starts here ////////////////////////////////////
		iconLogo = new ImageIcon("src/assets/PNGBaaja.png");
		imageLogo = iconLogo .getImage();
		imageLogo  = imageLogo .getScaledInstance(39,39, Image.SCALE_SMOOTH);
		iconLogo .setImage(imageLogo );
	    
		
		lblBaaja=new JLabel("Music Player");
		lblBaaja.setBackground(Color.BLACK);
		lblBaaja.setBounds(50,5,585,40);
		lblBaaja.setHorizontalAlignment(SwingConstants.LEFT);
		lblBaaja.setForeground(new Color(255, 102, 0));
		lblBaaja.setFont(new Font("Times New Roman",Font.BOLD,28));
		pnlHeader.add(lblBaaja);
	
		
		btnClose = new JButton();
		btnClose.setText("X");
		btnClose.setForeground(Color.WHITE);
		btnClose.setBounds(763, 5, 60, 40);
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 27));
		btnClose.setToolTipText("Close");
		btnClose.setBackground(Color.RED);
		
		btnClose.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
		    {
					exitFrameObj = new ExitFrame();
					exitFrameObj.exitframe();
		    }          
		});
		
		
		iconClose  = new ImageIcon("img\\PNGClose.png");
		
	
		pnlHeader.add(btnClose);
		
		JButton btnMin = new JButton();
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHome.setState(ICONIFIED);
				
			}
		});
		btnMin.setToolTipText("Close");
		btnMin.setText("-");
		btnMin.setForeground(Color.WHITE);
		btnMin.setFont(new Font("Times New Roman", Font.BOLD, 29));
		btnMin.setBackground(Color.RED);
		btnMin.setBounds(701, 5, 52, 40);
		pnlHeader.add(btnMin);
		
		pnlHeaderTrack = new JPanel();
		pnlHeaderTrack.setBackground(Color.LIGHT_GRAY);
		pnlHeaderTrack.setBounds(0, 52, 833,32);
		pnlHeaderTrack.setLayout(null);
		frmHome.getContentPane().add(pnlHeaderTrack);
		
		
		JMenuItem mnAlbum = new JMenuItem("Album");
		mnAlbum.setBackground(Color.LIGHT_GRAY);
		mnAlbum.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnAlbum.setBounds(141, 0, 133, 34);
		mnAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Album a=new Album();
				a.Alframe.setVisible(true);
			
			}
		});
		pnlHeaderTrack.add(mnAlbum);
		
		JMenuItem mnFavorite = new JMenuItem("Favorite");
		mnFavorite.setBackground(Color.LIGHT_GRAY);
		mnFavorite.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnFavorite.setBounds(268, 0, 133, 34);
		mnFavorite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Favorite fv=new Favorite();
				fv.frmFav.setVisible(true);
			
			}
		});
		pnlHeaderTrack.add(mnFavorite);
		
		
		JMenuItem mnLogin = new JMenuItem("Login");
		mnLogin.setBackground(Color.LIGHT_GRAY);
		mnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnLogin.setBounds(690, 0, 133, 34);
		mnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage lobj=new LoginPage();
				lobj.frmlogin.setVisible(true);
				
			
			}
		});
		pnlHeaderTrack.add(mnLogin);
		
		
		JMenuItem mnHome= new JMenuItem("Home");
		mnHome.setBackground(Color.LIGHT_GRAY);
		mnHome.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnHome.setBounds(0, 0, 133, 34);
		
		pnlHeaderTrack.add(mnHome);
		
	
		frmHome.setFocusable(false);

		pnlBody = new JPanel();
		pnlBody.setForeground(Color.MAGENTA);
		pnlBody.setBackground(Color.WHITE);
		pnlBody.setBounds(0, 84, 534,428);
		pnlBody.setLayout(null);
		frmHome.getContentPane().add(pnlBody);
		
		
		
	    
//	    iconStop  = new ImageIcon("img/PNGStop.png");
//	    imageStop = iconStop.getImage();
//	    imageStop = imageStop.getScaledInstance(39,39, Image.SCALE_SMOOTH);
//	    iconStop.setImage(imageStop);
//	 
//		iconPrev  = new ImageIcon("E:\\musicPlayer\\Music_Player\\img\\previous Icon.png");
//	    imagePrev = iconPrev.getImage();
//	    imagePrev = imagePrev.getScaledInstance(39,39, Image.SCALE_SMOOTH);
//	    iconPrev.setImage(imagePrev);
	
		iconPlay  = new ImageIcon("src/assets/PNGPlay.png");
	    imagePlay = iconPlay.getImage();
	    imagePlay = imagePlay.getScaledInstance(59,59, Image.SCALE_SMOOTH);
	    iconPlay.setImage(imagePlay);
	    
	    
	    iconPause  = new ImageIcon("src/assets/PNGPause.png");
	    imagePause = iconPause.getImage();
	    imagePause = imagePause.getScaledInstance(59,59, Image.SCALE_SMOOTH);
	    iconPause.setImage(imagePause);
		


		iconNext  = new ImageIcon("src/assets/PNGNext.png");
	    imageNext = iconNext.getImage();
	    imageNext = imageNext.getScaledInstance(39,39, Image.SCALE_SMOOTH);
	    iconNext.setImage(imageNext);
	 
		iconAni0  = new ImageIcon("src/assets/animated0.gif");
	    imageAni0 = iconAni0.getImage();
	    imageAni0 = imageAni0.getScaledInstance(350,260, Image.SCALE_DEFAULT);
	    iconAni0.setImage(imageAni0);
	    
	    iconAni1  = new ImageIcon("src/assets/animated1.gif");
	    imageAni1 = iconAni1.getImage();
	    imageAni1 = imageAni1.getScaledInstance(350,260, Image.SCALE_DEFAULT);
	    iconAni1.setImage(imageAni1);
	    
	    iconAni2  = new ImageIcon("assets/animated2.gif");
	    imageAni2 = iconAni2.getImage();
	    imageAni2 = imageAni2.getScaledInstance(260,260, Image.SCALE_DEFAULT);
	    iconAni2.setImage(imageAni2);
	    
	    iconAni3  = new ImageIcon("src/assets/animated3.gif");
	    imageAni3 = iconAni3.getImage();
	    imageAni3 = imageAni3.getScaledInstance(260,260, Image.SCALE_DEFAULT);
	    iconAni3.setImage(imageAni3);
	    
	    iconAni4  = new ImageIcon("src/assets/animated4.gif");
	    imageAni4 = iconAni4.getImage();
	    imageAni4 = imageAni4.getScaledInstance(260,260, Image.SCALE_DEFAULT);
	    iconAni4.setImage(imageAni4);
		
		iconAni5  = new ImageIcon("src/assets/animated5.gif");
	    imageAni5 = iconAni5.getImage();
	    imageAni5 = imageAni5.getScaledInstance(260,260, Image.SCALE_DEFAULT);
	    iconAni5.setImage(imageAni5);
	    
	    iconAni6  = new ImageIcon("src/assets/animated6.gif");
	    imageAni6 = iconAni6.getImage();
	    imageAni6 = imageAni6.getScaledInstance(260,260, Image.SCALE_DEFAULT);
	    iconAni6.setImage(imageAni6);
	    
	    
	    iconStatic  = new ImageIcon("src/assets/LogoBaajaPNG.png");
	    imageStatic = iconStatic.getImage();
	    imageStatic = imageStatic.getScaledInstance(330,200, Image.SCALE_DEFAULT);
	    iconStatic.setImage(imageStatic);
		
		lblAni=new JLabel(new ImageIcon("C:\\Users\\user\\Videos\\turntable.gif"));
		lblAni.setBackground(Color.LIGHT_GRAY);
		lblAni.setBounds(10,10,514,313);
		pnlBody.add(lblAni);
		
		
		btnVolumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volumnDownControl(0.0);
				//vol();
			
				
				
			}
		});
		
		btnVolumn.setToolTipText("Volume");
		btnVolumn.setForeground(Color.YELLOW);
		btnVolumn.setFont(new Font("Times New Roman", Font.BOLD, 9));
		btnVolumn.setFocusPainted(false);
		btnVolumn.setContentAreaFilled(false);
		btnVolumn.setBorderPainted(false);
		btnVolumn.setBackground(Color.GREEN);
		btnVolumn.setBounds(334, 349, 50, 42);
		pnlBody.add(btnVolumn);
		
		TitledBorder bdrNetwork = new TitledBorder("Tracks");
		bdrNetwork.setTitleColor(new Color(0,255,255));
	    bdrNetwork.setTitleJustification(TitledBorder.CENTER);
	    bdrNetwork.setTitlePosition(TitledBorder.TOP);
	    
	   
		
		listview = new JList();
		listview.setBorder(new TitledBorder(new LineBorder(null), "Songs", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		funList();
		listview.setBounds(533, 83, 300, 429);
		frmHome.getContentPane().add(listview);
		
		
		
		 prepareGUI();
		    playThread=new Thread(runnablePlay);
	        resumeThread=new Thread(runnableResume);
//	        
		
	}//constructor closed here
	
	
	public void init()
	{
		frmHome.setVisible(true);
	}//init()_method closed here
	
	
	void funList()
	{
		
		try
		{
			
//		    String url="jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
//		    Class.forName("com.mysql.jdbc.Driver");
//		    Connection con = DriverManager.getConnection(url, "root", "root");
		    
//            String email=AccessEmail.getEmailId();
//			
//			String query = "select * from songs_list where email='"+email+"'";
//			PreparedStatement pat=(PreparedStatement) DataBaseConnection.getConnection().prepareStatement(query);
//			ResultSet rs=pat.executeQuery();
//			
//			DefaultListModel DML = new DefaultListModel();
//			
//			while(rs.next())
//			{
//				DML.addElement(rs.getString("song"));
//				
//			}
//			listview.setModel(DML);
//			
//			
//			
//	      
//		
//			pat.close();
//			rs.close();
			 String url="jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
			    Class.forName("com.mysql.jdbc.Driver");
			    Connection con = DriverManager.getConnection(url, "root", "rutu2012089");
			    
			
			//String url="jdbc:mysql://localhost:3306/users1";
		    //Class.forName("com.mysql.cj.jdbc.Driver");
		   // Connection con = DriverManager.getConnection(url, "root", "rutu2012");
	    
        String email=AccessEmail.getEmailId();
		
		String query = "select * from songs_list where email='"+email+"'";
		PreparedStatement pat=(PreparedStatement) con.prepareStatement(query);
		ResultSet rs=pat.executeQuery();
		
		DefaultListModel DML = new DefaultListModel();
		
		while(rs.next())
		{
			DML.addElement(rs.getString("song"));
			
		}
		listview.setModel(DML);
		
		
		
      
	
		pat.close();
		rs.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}

        
	}
	public void fun_fav()
	{
		try
		{
			
//		    String url="jdbc:mysql://localhost:3306/users";
//		    Class.forName("com.mysql.jdbc.Driver");
////		    Class.forName("com.mysql.cj.jdbc.Driver");
//		    Connection con = DriverManager.getConnection(url, "root", "root");
		    
		 /*   String s=(String) listview.getSelectedValue();
            
		    String email=AccessEmail.getEmailId();
		    
		    String query = "INSERT INTO favoritelist values('" + s + "','"+email+"')";

             Statement st = DataBaseConnection.getConnection().createStatement();
             int x = st.executeUpdate(query);
            if(x == 0)
            {


                    JOptionPane.showMessageDialog(btnFav, "Alreadt Exist");

            }
            else
            {
                     JOptionPane.showMessageDialog(btnFav,"Succesfully Added");



             }
            DataBaseConnection.getConnection().close();*/
			//String url="jdbc:mysql://localhost:3306/users1";
		   // Class.forName("com.mysql.cj.jdbc.Driver");
		    //Connection con = DriverManager.getConnection(url, "root", "madhu20");
			
			 String url="jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
			    Class.forName("com.mysql.jdbc.Driver");
			    Connection con = DriverManager.getConnection(url, "root", "rutu2012089");
		    
		    
		    String s=(String) listview.getSelectedValue();
            
		    String email=AccessEmail.getEmailId();
		    
		    String query = "INSERT INTO favoritelist values('" + s + "','"+email+"')";

             Statement st = con.createStatement();
             int x = st.executeUpdate(query);
            if(x == 0)
            {


                    JOptionPane.showMessageDialog(btnFav, "Alreadt Exist");

            }
            else
            {
                     JOptionPane.showMessageDialog(btnFav,"Succesfully Added");



             }
              con.close();

         }
      catch(Exception exception)
       {
            exception.printStackTrace();
       }


    }
	
		public void play()
		{
			try {
			  //String str=(String) listview.getSelectedValue();
		  String str="E:\\MCA Practicals\\JAVA\\Music_PlayerV2\\song23.mp3";
			  System.out.println(str);
			   fileInput=new FileInputStream(str);
				Player player= new Player(fileInput);
				player.play();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
			
			
    
		
	
	

    public void prepareGUI(){
    	btnPrev.setForeground(Color.YELLOW);
   		btnPrev.setBounds(21, 349, 42, 42);
   		btnPrev.setFont(new Font("Times New Roman",Font.BOLD,9));
   		btnPrev.setBackground(Color.GREEN);
   		btnPrev.setFocusPainted(false);
   		btnPrev.setBorderPainted(false);
   		btnPrev.setContentAreaFilled(false);
   		btnPrev.setToolTipText("Previous");
   		pnlBody.add(btnPrev);
   		
        playButton.setBounds(78, 349, 42, 42);
        playButton.setFont(new Font("Times New Roman",Font.BOLD,9));
        playButton.setBackground(Color.RED);
        playButton.setFocusPainted(false);
        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.setToolTipText("Play");
		pnlBody.add(playButton);
     
        pauseButton.setBounds(118, 349, 50, 50);
		pauseButton.setFont(new Font("Times New Roman",Font.BOLD,9));
		pauseButton.setBackground(Color.WHITE);
		pauseButton.setFocusPainted(false);
		pauseButton.setBorderPainted(false);
		pauseButton.setContentAreaFilled(false);
		pauseButton.setToolTipText("Pause");
		pnlBody.add(pauseButton);

		resumeButton.setBounds(178, 349, 42, 42);
		resumeButton.setFont(new Font("Times New Roman",Font.BOLD,9));
		resumeButton.setBackground(Color.WHITE);
		resumeButton.setFocusPainted(false);
		resumeButton.setBorderPainted(false);
		resumeButton.setContentAreaFilled(false);
		resumeButton.setToolTipText("resume");
		pnlBody.add(resumeButton);

		
		stopButton.setBounds(230, 349, 42, 42);
		stopButton.setFont(new Font("Times New Roman",Font.BOLD,9));
		stopButton.setBackground(Color.WHITE);
		stopButton.setFocusPainted(false);
		stopButton.setBorderPainted(false);
		stopButton.setContentAreaFilled(false);
		stopButton.setToolTipText("Stop");
		pnlBody.add(stopButton);

		
	
		btnNext.setBounds(282, 349, 42, 42);
		btnNext.setFont(new Font("Times New Roman",Font.BOLD,9));
		btnNext.setBackground(Color.RED);
		btnNext.setFocusPainted(false);
		btnNext.setBorderPainted(false);
		btnNext.setContentAreaFilled(false);
		btnNext.setToolTipText("Next");
		pnlBody.add(btnNext);
	
		btnUpload.setToolTipText("Upload");
		btnUpload.setForeground(Color.YELLOW);
		btnUpload.setFont(new Font("Times New Roman", Font.BOLD, 9));
		btnUpload.setFocusPainted(false);
		btnUpload.setContentAreaFilled(false);
		btnUpload.setBorderPainted(false);
		btnUpload.setBackground(Color.GREEN);
		btnUpload.setBounds(394, 349, 42, 42);
		pnlBody.add(btnUpload);
		
		btnFav.setToolTipText("Add to Favorite");
		btnFav.setForeground(Color.YELLOW);
		btnFav.setFont(new Font("Times New Roman", Font.BOLD, 9));
		btnFav.setFocusPainted(false);
		btnFav.setContentAreaFilled(false);
		btnFav.setBorderPainted(false);
		btnFav.setBackground(Color.GREEN);
		btnFav.setBounds(446, 349, 42, 42);
		pnlBody.add(btnFav);
		
		
		btnUpload.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UploadFile u=new UploadFile();
			u.frame.setVisible(true);
			
		}
	});

	btnFav.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			fun_fav();
		}
	});
	playButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//		    playThread=new Thread(runnablePlay);
			   playThread.start();
		     songNameLabel.setText("now playing : "+filename);
//			play();
		     
			
			  
		}
	});
	pauseButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("inside stop  method");
			
			 if(player!=null){
                try {
                    pause=fileInput.available();
                    player.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
			 }
		}
	});
	
	resumeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			resumeThread.start();
		}
	});
	stopButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			  playThread=new Thread(runnablePlay);
		      resumeThread=new Thread(runnableResume);
		    if(player!=null){
              player.close();
          }
		}
	});
	btnNext.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("inside next button");
		    playThread=new Thread(runnablePlay);
	        resumeThread=new Thread(runnableResume);
	        
			try {
			 player.close();
			}catch (Exception exe) {
			System.out.println("player stoped");
			}
			listview.setSelectedIndex(listview.getSelectedIndex()+1);
			
			
			   playThread.start();
		     songNameLabel.setText("now playing : "+filename);
	
		}
	});
	
	btnPrev.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("inside next button");
		    playThread=new Thread(runnablePlay);
	        resumeThread=new Thread(runnableResume);
	        
			try {
			 player.close();
			}catch (Exception exe) {
			System.out.println("player stoped");
			}
			listview.setSelectedIndex(listview.getSelectedIndex()-1);
			
			   playThread.start();
		     songNameLabel.setText("now playing : "+filename);
	
		}
	});
	
    }
  Runnable runnablePlay=new Runnable() {
      @Override
      public void run() {
          try {
              //code for play button
        	//String str="E:\\Madhu-PC\\Movies\\New folder\\new song\\1.mp3";
        	  
			  String str=(String) listview.getSelectedValue();
			  System.out.println("songs==="+str);
			  System.out.println(str);
			   fileInput=new FileInputStream(str);
              bufferedInputStream=new BufferedInputStream(fileInput);
              player=new Player(bufferedInputStream);
              totalLength=fileInput.available();
              player.play();//starting music
			  
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          } catch (JavaLayerException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          } 
      }
  };

    Runnable runnableResume=new Runnable() {
        @Override
        public void run() {
            try {
  			  String str=(String) listview.getSelectedValue();
  			  System.out.println(str);
  			   fileInput=new FileInputStream(str);
                bufferedInputStream=new BufferedInputStream(fileInput);
                player=new Player(bufferedInputStream);
                fileInput.skip(totalLength-pause);
                player.play();
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
   
  /* public void vol()
   {
	   JSlider sliderVol = new JSlider(-80,6);
		sliderVol.setBounds(90, 281, 374, 30);
		pnlBody.add(sliderVol);
		soundVolume sound=new soundVolume();
		
		sliderVol.addChangeListener(new ChangeListener()
				{

					@Override
					public void stateChanged(ChangeEvent e) {
						// TODO Auto-generated method stub
						sound.currentVol=sliderVol.getValue();
						sound.fc.setValue(sound.currentVol);
					}
			
				});
				JSlider sliderVol = new JSlider(-80,6);
		sliderVol.setBounds(90, 281, 374, 30);
		pnlBody.add(sliderVol);
		
		sliderVol.addChangeListener(new ChangeListener()
				{
					@Override
					public void stateChanged(ChangeEvent e) {
						// TODO Auto-generated method stub
						sound.currentVol=sliderVol.getValue();
						sound.fc.setValue(sound.currentVol);
					}
			
				});
				try {
				URI uri;
				uri = new URI(filename);
				System.out.println("URI="+uri);
				  URL url=uri.toURL();
				  System.out.println("URL="+url);
	             sound.setFile(url);
			} catch (URISyntaxException | MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   }*/
    private void volumnDownControl(double value)
	{
		// TODO Auto-generated method stub
		Mixer.Info[] mixers = AudioSystem.getMixerInfo();
		for(Mixer.Info mixerInfo :mixers) {
			Mixer mixer = AudioSystem.getMixer(mixerInfo);
			Line.Info[] lineInfos =mixer.getTargetLineInfo();
			for(Line.Info lineInfo : lineInfos)
			{
				Line line = null;
				boolean opened =true;
				
				try
				{
					line = mixer.getLine(lineInfo);
					opened=line.isOpen()|| line instanceof Clip;
					if(!opened)
					{
						line.open();
					}
					FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
							
					float currentVolumn = volControl.getValue();
				
					
					Double volumnToCut = value;
					float Changedval = (float) ((float)currentVolumn - (double)volumnToCut);
					volControl.setValue(Changedval);
					
				}
				catch(LineUnavailableException e)
				{
					
				}
				catch(IllegalArgumentException e1)
				{
					
				}
				finally
				{
					if(line != null && !opened)
					{
						line.close();
					}
				}
			}
		}
	}
}


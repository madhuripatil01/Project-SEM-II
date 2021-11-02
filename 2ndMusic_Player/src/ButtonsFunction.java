import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ButtonsFunction 
{
	
	
	
	long pauseLoc, songLength;
	int playstatus=0,filepathresponse,trackNo=0;
	//play status 0 for stop , 1 for playing, 2 for paused
	public Player player;
	FileInputStream fis1;
	File[] selectedFile;
	BufferedInputStream bis1;
	JFileChooser fcPath=new JFileChooser();
	String strPath="",strPathNew;
	FileNameExtensionFilter filter ;
	
	
	int width = 600, height = 410;
    public void btnPlay(String path)
    {
    	
    	try 
		{
			fis1=new FileInputStream(path);
			bis1=new BufferedInputStream(fis1);
			player=new Player(bis1);
			songLength=fis1.available();			
			playstatus=1;
			
		
			//lblCurrentSong.setText(selectedFile[trackNo].getName());
			strPathNew=path+"";
			
			
		}
		catch (FileNotFoundException  | JavaLayerException ex) 
		{
			playstatus=0;
			
			//lblCurrentSong.setText("");
		
			
		} 
		catch (IOException e) 
		{}
		new Thread()
		{
			public void run()
			{
				try
				{
					player.play();
					
					if(player.isComplete())
					{
						//btnMNext.doClick();
					}
				}
				catch (JavaLayerException e) 
				{
					strPath="";
					playstatus=0;
					//lblCurrentSong.setText("");
					
				}
			}
		}.start();
    }
    public static void pause(String str)
    {
    	
    }
    public static void stop(String str)
    {
    	
    }
}

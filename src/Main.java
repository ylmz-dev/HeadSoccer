import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main{
	
static String player1;
static String player2;


	public static void main(String[] args) {
		
		
		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Name of the first player:");
		player1=sc.next();
		System.out.println("Name of the second player:");
		player2=sc.next();
	      
		
		JFrame frame = new JFrame();
	
		Game panel = new Game();
		frame.setSize(1366,768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		Audio.Cal("TaDaa.wav");
		
		
		frame.setVisible(true);	
		//start
        long StartTime = System.currentTimeMillis();

		
       
      
    }
	}



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

import lejos.hardware.Audio;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.remote.ev3.RMIRegulatedMotor;

/**
 * Creates by Alex Thoennes and Dan Tartaglione
 * 
 * This class creates a GUI which implements a KeyListener. The user
 * uses the GUI to control the scarab robot. This is done by using the
 * arrow keys. The following commands are what the robot can do remotely:
 * 
 * UP:
 *   moves forward
 * DOWN:
 *   moves backwards
 * LEFT:
 *   Turns to the left
 * RIGHT:
 *   Turns to the right
 * B:
 *   tells the robot to beep
 * Q:
 *   used to safely exit the program 
 *   and close the ports
 */

public class GUIListener implements KeyListener
{
	private JFrame frame;
	
	private Audio audio;
	private RMIRegulatedMotor left;
	private RMIRegulatedMotor right;
	private EV3ColorSensor color;
	private Semaphore sema;
	private Stream music;
	
	private boolean quit;
	
	public GUIListener(Audio audio, RMIRegulatedMotor left, RMIRegulatedMotor right, EV3ColorSensor color, Semaphore s)
	{
		this.audio = audio;
		this.left = left;
		this.right = right;
		this.color = color;
		this.sema=s;
		this.music=new Stream(audio);
		
		quit = false;
		
		initFrame();
	}
	
	private void initFrame()
	{
		frame = new JFrame("Controller");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		try
		{
			left.setSpeed(500);
			right.setSpeed(500);
			
			switch (e.getKeyCode())
			{
			case KeyEvent.VK_UP:
				left.forward();
				right.forward();
				break;
			case KeyEvent.VK_DOWN:
				left.backward();
				right.backward();
				break;
			case KeyEvent.VK_LEFT:
				left.stop(false);
				right.forward();
				break;
			case KeyEvent.VK_RIGHT:
				left.forward();
				right.stop(false);
				break;
			case KeyEvent.VK_B:
				//audio.systemSound(0);
				music.play();
				break;
			case KeyEvent.VK_Q:
				System.out.println("QUIT");
				System.out.println("Closing Ports!!!");
				try {
					sema.acquire(); //This semaphore assures that the sensor will not sample after quitting
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					System.out.println("Note: Semaphore not acquired, system may not exit properly");
				}
				left.close();
				right.close();
				color.close();
				frame.dispose();
				this.quit = true;
				System.out.println("Ports closed!!!");
				System.out.println("Exiting program!!!");
				break;
			}
			
		}
		catch (RemoteException excp)
		{
			excp.printStackTrace();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		try
		{
			left.stop(true);
			right.stop(true);
		}
		catch (Exception excp)
		{
			excp.printStackTrace();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}	
	
	public boolean getQuit()
	{
		return this.quit;
	}
}
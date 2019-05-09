package scarab;

import java.rmi.RemoteException;

import lejos.hardware.Audio;
import lejos.hardware.BrickFinder;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

/**
 * 
 * @author Alex Thoennes 
 * @author Dan Tartaglione
 * 
 * This class creates a remote ev3 object so we can connect
 * to the brick then it initializes a GUI object so we can 
 * control the brick remotely.
 *
 */

public class Driver
{	
	public static void main(String[] args) throws RemoteException 
	{
		RemoteEV3 ev3 = (RemoteEV3) BrickFinder.getDefault();
		Audio audio = ev3.getAudio();
		RMIRegulatedMotor left = ev3.createRegulatedMotor("A", 'L');
		RMIRegulatedMotor right = ev3.createRegulatedMotor("B", 'L');
		GUI gui = new GUI(audio, left, right);
	}
}

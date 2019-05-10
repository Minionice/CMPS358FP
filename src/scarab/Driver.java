package scarab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import lejos.hardware.Audio;
import lejos.hardware.Bluetooth;
import lejos.hardware.BrickFinder;
import lejos.hardware.port.I2CPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.I2CSensor;
import lejos.hardware.sensor.NXTColorSensor;
import lejos.hardware.video.Video;
import lejos.internal.ev3.EV3Video;
import lejos.remote.ev3.RMII2CPort;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RMIRemoteI2CPort;
import lejos.remote.ev3.RemoteEV3;
import lejos.robotics.SampleProvider;

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
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		RemoteEV3 ev3 = (RemoteEV3) BrickFinder.getDefault();
		Audio audio = ev3.getAudio();
		audio.playSample(new File("CMPS358FP/walle.wav"));
		RMIRegulatedMotor left = ev3.createRegulatedMotor("A", 'L');
		RMIRegulatedMotor right = ev3.createRegulatedMotor("B", 'L');
		GUI gui = new GUI(audio, left, right);
		
		EV3ColorSensor colorSensor = new EV3ColorSensor(ev3.getPort("S4"));
		SampleProvider sp = colorSensor.getRedMode();
		
		float[] sample = new float[1];
		while (!gui.getQuit())
		{
			sp.fetchSample(sample,0);
			System.out.println(sample[0]);
			if (sample[0] > 0.02 && sample[0] <= .5)
			{
				audio.systemSound(0);
			}
		}
		colorSensor.close();
	}
}

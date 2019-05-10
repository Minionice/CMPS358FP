import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Semaphore;

import lejos.hardware.Audio;
import lejos.hardware.BrickFinder;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.remote.ev3.RMIRegulatedMotor;
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
		RMIRegulatedMotor left = ev3.createRegulatedMotor("A", 'L');
		RMIRegulatedMotor right = ev3.createRegulatedMotor("B", 'L');
		EV3ColorSensor colorSensor = new EV3ColorSensor(ev3.getPort("S3"));
		SampleProvider sp1 = colorSensor.getRedMode();
		Semaphore samplerProtector=new Semaphore(1);
		GUIListener gui = new GUIListener(audio, left, right, colorSensor, samplerProtector);
		/*
		 * Quitting from the GUI will end the program because it will terminate the main thread
		 */
		Detector detector=new Detector(audio, sp1, samplerProtector);
		Thread detectorThread=new Thread(detector);
		detectorThread.start();
	}
}
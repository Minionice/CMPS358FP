import java.util.concurrent.Semaphore;

import lejos.hardware.Audio;
import lejos.robotics.SampleProvider;

public class Detector implements Runnable{
	private Audio audio;
	private SampleProvider sp;
	private Semaphore sema;
	
	public Detector(Audio a, SampleProvider p, Semaphore s) {
		audio=a;
		sp=p;
		sema=s;
	}
	public void run() {
		float[] sample1=new float[1];
		while(true)
		{
			try {
				sema.acquire();
			} catch (InterruptedException e1) {
				return; //End this thread in the event of an exception
			}
			sp.fetchSample(sample1,0);
			if (sample1[0] > 0.1 && sample1[0] <= .5)
			{
				System.out.println(sample1[0]);
				audio.systemSound(0);
			}
			sema.release();
			try {Thread.sleep(1);} //Avoiding tight looping
			catch(InterruptedException e) {e.printStackTrace();}
		}
	}
}

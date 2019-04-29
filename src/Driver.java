import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import java.util.Collection;
import lejos.hardware.Button;
import lejos.hardware.LocalBTDevice;
import lejos.hardware.RemoteBTDevice;
import lejos.hardware.ev3.EV3;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.MotorPort;

public class Driver {
	private static final EV3LargeRegulatedMotor right=new EV3LargeRegulatedMotor(MotorPort.A);
	private static final EV3LargeRegulatedMotor left=new EV3LargeRegulatedMotor(MotorPort.B);
	
	public static void main(String []args) {
		//LCD.drawString("Press a button", 0, 0);
		EV3 brick=LocalEV3.get();
		LocalBTDevice brickBT=brick.getBluetoothDevice();
		Collection<RemoteBTDevice> devices=brickBT.getPairedDevices();
		RemoteBTDevice phone=null;
		for(RemoteBTDevice b : devices) {
			if(b.getAddress().equals("948BC1E307A1")){
				phone=b;
				break;
			}
		}
		LCD.clear();
		if(phone!=null) {
			LCD.drawString("Device found!", 0, 0);
		}
		else {
			LCD.drawString("Device not found", 0, 0);
		}
		Button.waitForAnyPress();
		//LCD.clear();
		right.setSpeed(420);
		left.setSpeed(420);
		while(true) {
			right.forward();
			left.forward();
		}
	}
}
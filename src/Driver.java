import lejos.hardware.lcd.LCD;
import lejos.hardware.lcd.LCDOutputStream;
import lejos.hardware.motor.EV3LargeRegulatedMotor;

import java.io.IOException;
import java.util.Collection;
import lejos.hardware.Button;
import lejos.hardware.LocalBTDevice;
import lejos.hardware.RemoteBTDevice;
import lejos.hardware.ev3.EV3;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.MotorPort;

public class Driver {
	//private static final EV3LargeRegulatedMotor right=new EV3LargeRegulatedMotor(MotorPort.A);
	//private static final EV3LargeRegulatedMotor left=new EV3LargeRegulatedMotor(MotorPort.B);
	
	public static void main(String []args) throws IOException {
		//LCD.drawString("Press a button", 0, 0);
		EV3 brick=LocalEV3.get();
		LocalBTDevice brickBT=brick.getBluetoothDevice();
		Collection<RemoteBTDevice> devices=brickBT.getPairedDevices();
		RemoteBTDevice phone=null;
		for(RemoteBTDevice b : devices) {
//			if(b.getAddress().equals("94:8B:C1:E3:07:A1")||b.getAddress().equals("7C:04:D0:3C:25:9F")){
//				phone=b;
//				break;
//			}
			phone=b;
			break;
		}
		LCDOutputStream output=new LCDOutputStream();
		try {
			output.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LCD.clear();
		LCD.clearDisplay();
		output.close();
		if(phone!=null) {
			LCD.drawString("Device found!", 0, 6);
			try{Thread.sleep(1500);}
			catch(Exception e) {}
			LCD.clear();
			LCD.drawString(phone.getAddress(), 0, 6);
		}
		else {
			LCD.drawString("Device not found", 0, 6);
		}
		Button.waitForAnyPress();
		//LCD.clear();
//		right.setSpeed(420);
//		left.setSpeed(420);
//		while(true) {
//			right.forward();
//			left.forward();
//		}
	}
}
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.Button;
import lejos.hardware.port.MotorPort;

public class Driver {
	private static final EV3LargeRegulatedMotor right=new EV3LargeRegulatedMotor(MotorPort.A);
	private static final EV3LargeRegulatedMotor left=new EV3LargeRegulatedMotor(MotorPort.B);
	
	public static void main(String []args) {
		LCD.drawString("Press a button", 0, 0);
		Button.waitForAnyPress();
		LCD.clear();
		right.setSpeed(420);
		left.setSpeed(420);
		while(true) {
			right.forward();
			left.forward();
		}
	}
}

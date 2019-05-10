import lejos.hardware.Audio;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.remote.ev3.RemoteEV3;
import lejos.hardware.Sounds;

 
public class Stream {
	final static int C1=16;
	final static int Df1=17;
	final static int D1=18;
	final static int Ef1=19;
	final static int E1=21;
	final static int F1=22;
	final static int Gf1=23;
	final static int G1=25;
	final static int Af1=26;
	final static int A1=28;
	final static int Bf1=29;
	final static int B1=31;
	
	final static int C2=33;
	final static int Df2=35;
	final static int D2=37;
	final static int Ef2=39;
	final static int E2=41;
	final static int F2=44;
	final static int Gf2=46;
	final static int G2=48;
	final static int Af2=52;
	final static int A2=55;
	final static int Bf2=58;
	final static int B2=61;
	
	final static int C3=65;
	final static int Df3=69;
	final static int D3=73;
	final static int Ef3=78;
	final static int E3=82;
	final static int F3=87;
	final static int Gf3=92;
	final static int G3=98;
	final static int Af3=104;
	final static int A3=110;
	final static int Bf3=117;
	final static int B3=123;
	
	final static int C4=131;
	final static int Df4=139;
	final static int D4=147;
	final static int Ef4=156;
	final static int E4=165;
	final static int F4=175;
	final static int Gf4=185;
	final static int G4=196;
	final static int Af4=208;
	final static int A4=220;
	final static int Bf4=233;
	final static int B4=247;
	
	final static int C5=261;
	final static int Df5=277;
	final static int D5=294;
	final static int Ef5=311;
	final static int E5=330;
	final static int F5=349;
	final static int Gf5=370;
	final static int G5=392;
	final static int Af5=415;
	final static int A5=440;
	final static int Bf5=466;
	final static int B5=494;
	
	final static int C6=523;
	final static int Df6=554;
	final static int D6=587;
	final static int Ef6=622;
	final static int E6=659;
	final static int F6=698;
	final static int Gf6=740;
	final static int G6=784;
	final static int Af6=831;
	final static int A6=880;
	final static int Bf6=932;
	final static int B6=988;
	
	final static int beat=490;
	final static int quarter=beat;
	final static int half=2*beat;
	final static int whole=4*beat;
	final static int eighth=beat/2;
	final static int sixteenth=beat/4;
	
    public static void main(String []args) {
    	RemoteEV3 brick=(RemoteEV3) BrickFinder.getDefault();
    	Audio audio=brick.getAudio();
    	audio.playNote(Sounds.PIANO, D5, sixteenth);
    	audio.playNote(Sounds.PIANO, D5, sixteenth);
    	audio.playNote(Sounds.PIANO, D6, eighth);
    	audio.playNote(Sounds.PIANO, A5, 3*sixteenth);
    	audio.playNote(Sounds.PIANO, Af5, eighth);
    	audio.playNote(Sounds.PIANO, G5, eighth);
    	audio.playNote(Sounds.PIANO, F5, eighth);
    	audio.playNote(Sounds.PIANO, D5, sixteenth);
    	audio.playNote(Sounds.PIANO, F5, sixteenth);
    	audio.playNote(Sounds.PIANO, G5, sixteenth);
    	
    	audio.playNote(Sounds.PIANO, Df5, sixteenth);
    	audio.playNote(Sounds.PIANO, Df5, sixteenth);
    	audio.playNote(Sounds.PIANO, D6, eighth);
    	audio.playNote(Sounds.PIANO, A5, 3*sixteenth);
    	audio.playNote(Sounds.PIANO, Af5, eighth);
    	audio.playNote(Sounds.PIANO, G5, eighth);
    	audio.playNote(Sounds.PIANO, F5, eighth);
    	audio.playNote(Sounds.PIANO, D5, sixteenth);
    	audio.playNote(Sounds.PIANO, F5, sixteenth);
    	audio.playNote(Sounds.PIANO, G5, sixteenth);
    	
    	audio.playNote(Sounds.PIANO, C5, sixteenth);
    	audio.playNote(Sounds.PIANO, C5, sixteenth);
    	audio.playNote(Sounds.PIANO, D6, eighth);
    	audio.playNote(Sounds.PIANO, A5, 3*sixteenth);
    	audio.playNote(Sounds.PIANO, Af5, eighth);
    	audio.playNote(Sounds.PIANO, G5, eighth);
    	audio.playNote(Sounds.PIANO, F5, eighth);
    	audio.playNote(Sounds.PIANO, D5, sixteenth);
    	audio.playNote(Sounds.PIANO, F5, sixteenth);
    	audio.playNote(Sounds.PIANO, G5, sixteenth);
    	
    	audio.playNote(Sounds.PIANO, B4, sixteenth);
    	audio.playNote(Sounds.PIANO, B4, sixteenth);
    	audio.playNote(Sounds.PIANO, D6, eighth);
    	audio.playNote(Sounds.PIANO, A5, 3*sixteenth);
    	audio.playNote(Sounds.PIANO, Af5, eighth);
    	audio.playNote(Sounds.PIANO, G5, eighth);
    	audio.playNote(Sounds.PIANO, F5, eighth);
    	audio.playNote(Sounds.PIANO, D5, sixteenth);
    	audio.playNote(Sounds.PIANO, F5, sixteenth);
    	audio.playNote(Sounds.PIANO, G5, sixteenth);
    }
}
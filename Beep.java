package ditdah;

/**
 * class Beep - 
 * @author Joe Cotton
 */

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Beep {
	SourceDataLine line = null;
	AudioFormat af = null;
	protected static final int SAMPLE_RATE = 16 * 1024;
	protected static int f = 1000;
	protected static int wpm = 20;
	
	
	public Beep() {
		say.it("beep no parm");
	}
	
	// constructor to initialize AudioFormat and SourceDataLine
	public Beep(int f, int wpm) {
		say.it("beep parms");
		this.f = f; this.wpm = wpm;
		af = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);
		try {
			line = AudioSystem.getSourceDataLine(af);
			line.open(af, SAMPLE_RATE);
			line.start();
		} catch (LineUnavailableException e) {
			say.it(e.getLocalizedMessage());
		}
	}

/**
 * play() 
 * @param b - byte array containing code for a sound - usually here a Morse code letter
 * Note that the AudioFormat and Source Data Line have already been initialized in the constructor.
 */
	public void play(byte[] b) {
			line.write(b, 0, b.length);
	}
	
/**
 * createSinWaveBuffer - creates a buffer and puts the sound in
 * @param freq
 * @param ms
 * @return
 */
	public byte[] createSinWaveBuffer(double freq, int ms) {
		int samples = (int) ((ms * SAMPLE_RATE) / 1000);
		byte[] output = new byte[samples];
		//
		double period = (double) SAMPLE_RATE / freq;
		for (int i = 0; i < output.length; i++) {
			double angle = 2.0 * Math.PI * i / period;
			output[i] = (byte) (Math.sin(angle) * 127f);
		}
		return output;
	}
	
	/**
	 * setTone - loops through the code of a letter and concationates a dot or dash or space at the end
	 * @param b
	 * @return
	 */
	public Beta setTone(Beta b){
		String s = b.getCode();
		byte[] c = {0,0};
		for (int i=0;i<s.length();i++){
			String t = s.substring(i, i+1);
			if (t.equals("-")){	c = concat(c, Dah(f,wpm)); }
			if (t.equals(".")){	c = concat(c, Dit(f,wpm)); }
			if (t.equals(" ")){	c = concat(c, wordSpace(wpm)); }
		}
		c = concat(c, charSpace(wpm)); // dot length
		c = concat(c, charSpace(wpm)); // twice for longer time between letters
		b.setBytes(c);
		return b;
	}
	
	public byte[] Dit(double freq, int WPM){
		return concat(createSinWaveBuffer(freq, dotLength(WPM)), charSpace(WPM));
	}
	public byte[] Dah(double freq, int WPM){
		return concat(createSinWaveBuffer(freq, dotLength(WPM)*3), charSpace(WPM));
	}
	public byte[] charSpace(int WPM){
		byte[] c = new byte[(dotLength(WPM) * SAMPLE_RATE) / 1000];
		for (int i=0;i<c.length;i++){c[i]=0x0;}  // zero for no tone between chars
		return c;
	}
	public byte[] wordSpace(int WPM){
		byte[] c = new byte[(dotLength(WPM) * SAMPLE_RATE) / 1000];
		for (int i=0;i<c.length;i++){c[i]=0x0;}  // zero for no tone between words
		return c;
	}
	
	public byte[] concat(byte[] a, byte[] b){
		byte[] c = new byte[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}
	
	/**
	 * dotLength() - calculate the length of a dot in milliseconds
	 * "paris" = 53 dots
	 * @param WPM
	 * @return
	 */
	public int dotLength(int WPM){
		if (WPM <= 0){return 100;}
		return 60000 / (59 * WPM);
	}	

}


//public void playp(double freq, int length) {
//final AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);
//try {
//	SourceDataLine line = AudioSystem.getSourceDataLine(af);
//	line.open(af, SAMPLE_RATE);
//	line.start();
//
//	byte[] toneBuffer = this.createSinWaveBuffer(freq, length);
//	int count = line.write(toneBuffer, 0, toneBuffer.length);
//	line.drain();
//	line.close();
//} catch (LineUnavailableException e) {
//	say.it(e.getLocalizedMessage());
//}
//}

//public void play() {
//double freq = f;
//int length = dotLength(wpm);
//final AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);
//try {
//	SourceDataLine line = AudioSystem.getSourceDataLine(af);
//	line.open(af, SAMPLE_RATE);
//	line.start();
//
//	//byte[] toneBuffer = this.createSinWaveBuffer(freq, length);
//	
//	line.drain();
//	line.close();
//} catch (LineUnavailableException e) {
//	say.it(e.getLocalizedMessage());
//}
//}

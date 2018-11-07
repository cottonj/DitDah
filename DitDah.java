package ditdah;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DitDah{
	protected static final int SAMPLE_RATE = 16 * 1024;

	public static void main(String[] args) {
		say.it("sound");

		String argFile = "source.txt";
		String argFreq;
		String argWPM;
		int freq = 800;
		int wpm = 12;
		
		// input arguments (file, tone, speed)
		if (args.length > 0){
			argFile = args[0];
		}
		if (args.length > 1){
			argFreq = args[1];
			try{
				freq = Integer.parseInt(argFreq);
			} catch(NumberFormatException e){
				say.it("Bad frequency param: " + argFreq + " - using default 800");
			}
		}
		if (args.length > 2){
			argWPM  = args[2];
			try{
				wpm = Integer.parseInt(argWPM);
			} catch(NumberFormatException e){
				say.it("Bad WPM param: " + argWPM + " - using default 12");
			}
		}
		
		// create byte[] array with tones for each letter.  store in array.
		Beep beep = new Beep(freq, wpm);
		Bet bet;
		Beta beta = new Beta();
		bet = beta.setBetaLetters();  // create Byte[] arrays for each letter sound 
		Beta[] b  = bet.getBet();
		
		// play each letter
		for (int i=0;i<42;i++){
			//beep.play(b[i].getBytes());
		}

		// open the text file and roll thru, playing each letter.
		try{
			BufferedReader in = new BufferedReader(new FileReader(argFile));
			String line = in.readLine();
			while (line != null){
				for (int i=0; i<line.length(); i++){
					String s = line.substring(i, i+1);
					say.i(s);                    // display the letter
					beep.play(bet.findTone(s));  // play the letter
				}
				beep.play(bet.findTone(" ")); // play space for new line
				say.it(" ");                  // display a new line
				line = in.readLine();
			}
		} catch (IOException e) {
			say.it(e.getLocalizedMessage());
		}

	}

}

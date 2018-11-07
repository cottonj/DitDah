package ditdah;
/**
 * class Beta - holds single letter, code, and byte[] array for sound
 * @author Joe Cotton
 *
 */
public class Beta {
	String letter = "";
	String code = "";
	byte[] bytes = new byte[20000];
	
	public Beta(){
		
	}
	public void setLetter(String l){letter = l;}
	public void setCode(String c){code = c;}
	public void setBytes(byte[] b){
		bytes = b;
	}
	public String getLetter(){return letter;}
	public String getCode(){return code;}
	public byte[] getBytes(){return bytes;}
	@Override
	public String toString(){
		return letter+" "+code+" "+bytes.length;
	}
	
	
/**
 * initialize the letters array b with letter names and code.
 * @param b is an array of Beta[]
 */
	public Bet setBetaLetters(){
		Beta beta = new Beta();      // single object with local values
		byte[] by = new byte[10000]; // local byte array for sounds
		Beta[] b  = new Beta[48];    // local Beta array

		// initialize Beta[] array 
		for (int i=0;i<b.length;i++){
			beta = new Beta();
			b[i]=beta;
		}
		
  		b[ 0].setLetter("a");
		b[ 0].setBytes(by); 
		b[ 0].setCode(".-"); 
		
		b[ 1].setLetter("b"); 
		b[ 1].setBytes(by); 
		b[ 1].setCode("-..."); 
		
		b[ 2].setLetter("c"); b[ 2].setBytes(by); b[ 2].setCode("-.-."); 
		b[ 3].setLetter("d"); b[ 3].setBytes(by); b[ 3].setCode("-.."); 
		b[ 4].setLetter("e"); b[ 4].setBytes(by); b[ 4].setCode("."); 
		b[ 5].setLetter("f"); b[ 5].setBytes(by); b[ 5].setCode("..-."); 
		b[ 6].setLetter("g"); b[ 6].setBytes(by); b[ 6].setCode("--."); 
		b[ 7].setLetter("h"); b[ 7].setBytes(by); b[ 7].setCode("...."); 
		b[ 8].setLetter("i"); b[ 8].setBytes(by); b[ 8].setCode(".."); 
		b[ 9].setLetter("j"); b[ 9].setBytes(by); b[ 9].setCode(".---"); 
		b[10].setLetter("k"); b[10].setBytes(by); b[10].setCode("-.-"); 
		b[11].setLetter("l"); b[11].setBytes(by); b[11].setCode(".-.."); 
		b[12].setLetter("m"); b[12].setBytes(by); b[12].setCode("--"); 
		b[13].setLetter("n"); b[13].setBytes(by); b[13].setCode("-."); 
		b[14].setLetter("o"); b[14].setBytes(by); b[14].setCode("---"); 
		b[15].setLetter("p"); b[15].setBytes(by); b[15].setCode(".--."); 
		b[16].setLetter("q"); b[16].setBytes(by); b[16].setCode("--.-"); 
		b[17].setLetter("r"); b[17].setBytes(by); b[17].setCode(".-."); 
		b[18].setLetter("s"); b[18].setBytes(by); b[18].setCode("..."); 
		b[19].setLetter("t"); b[19].setBytes(by); b[19].setCode("-"); 
		b[20].setLetter("u"); b[20].setBytes(by); b[20].setCode("..-"); 
		b[21].setLetter("v"); b[21].setBytes(by); b[21].setCode("...-"); 
		b[22].setLetter("w"); b[22].setBytes(by); b[22].setCode(".--"); 
		b[23].setLetter("x"); b[23].setBytes(by); b[23].setCode("-..-"); 
		b[24].setLetter("y"); b[24].setBytes(by); b[24].setCode("-.--"); 
		b[25].setLetter("z"); b[25].setBytes(by); b[25].setCode("--.."); 
		b[26].setLetter("1"); b[26].setBytes(by); b[26].setCode(".----"); 
		b[27].setLetter("2"); b[27].setBytes(by); b[27].setCode("..---"); 
		b[28].setLetter("3"); b[28].setBytes(by); b[28].setCode("...--"); 
		b[29].setLetter("4"); b[29].setBytes(by); b[29].setCode("....-"); 
		b[30].setLetter("5"); b[30].setBytes(by); b[30].setCode("....."); 
		b[31].setLetter("6"); b[31].setBytes(by); b[31].setCode("-...."); 
		b[32].setLetter("7"); b[32].setBytes(by); b[32].setCode("--..."); 
		b[33].setLetter("8"); b[33].setBytes(by); b[33].setCode("---.."); 
		b[34].setLetter("9"); b[34].setBytes(by); b[34].setCode("----."); 
		b[35].setLetter("0"); b[35].setBytes(by); b[35].setCode("-----"); 
		b[36].setLetter("."); b[36].setBytes(by); b[36].setCode(".-.-.-"); 
		b[37].setLetter(","); b[37].setBytes(by); b[37].setCode("--..--"); 
		b[38].setLetter("-"); b[38].setBytes(by); b[38].setCode("-...-"); 
		b[39].setLetter("="); b[39].setBytes(by); b[39].setCode(".-..."); 
		b[40].setLetter("/"); b[40].setBytes(by); b[40].setCode("-..-."); 
		b[41].setLetter("?"); b[41].setBytes(by); b[41].setCode("..--.."); 
		b[42].setLetter(" "); b[42].setBytes(by); b[41].setCode(" "); 

		Beep beep = new Beep();
		for (int i=0;i<42;i++){
			b[i].setBytes(beep.setTone(b[i]).getBytes());
			//beep.play(b[i].getBytes());
		}
		Bet bet = new Bet();
		bet.setBet(b);
		return bet;
	}
	
	
	
}

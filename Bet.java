package ditdah;

/**
 * class Bet - holds an array of Beta, one entry for each letter or number
 * @author Joe Cotton
 *
 */
public class Bet {
	Beta[] bet = new Beta[48];
	public Bet(){
		
	}
	public void setBet(Beta[] b){bet=b;}
	public Beta[] getBet(){return bet;}
	
	public byte[] findTone(String s){
		byte[] b = {0,0};
		Beta beta;
		for (int i = 0; i < 48; i++){
			if (bet[i].getLetter().equalsIgnoreCase(s)){
				return bet[i].getBytes();
			}
		}
		return b;
	}


}

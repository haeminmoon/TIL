package AlphabetRemetch;

public class Alphabet {	
	private String word;
	private int ascii;
	private int count;
	
	public Alphabet(String word) {
		this.word = word;
		this.ascii = convertStringToAscii();
		count = 0;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getAscii() {
		return ascii;
	}
	public void setAscii(int ascii) {
		this.ascii = ascii;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	private int convertStringToAscii() {
		int ascii = 0;
		
		ascii = this.word.charAt(0);
	
		return ascii;
	}
}

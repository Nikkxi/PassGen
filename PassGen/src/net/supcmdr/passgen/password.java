package net.supcmdr.passgen;

public class password {
	
	// VARIABLES
	private String password = "";
	private String character;
	private int length;
	private String symbols = new String(
			"abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	private String aSymbols = new String(
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
	private String nSymbols = new String("0123456789");

	// CONSTRUCTOR
	public password(){
		this.length=8;
	}
	// METHODS
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSymbols() {
		return symbols;
	}
	public String getaSymbols() {
		return aSymbols;
	}
	public String getnSymbols() {
		return nSymbols;
	}
	public void setLength(int length){
		this.length = length;
	}
	public void generate(){
		String word = new String();

		// placeholders for numerical password values
		double first = Math.random() * (length - 2) + 1;
		double second = Math.random() * (length - 2) + 1;

		while ((int) first == (int) second) {
			second = Math.random() * (length - 2) + 1;
		}

		// generate characters
		for (int i = 0; i < length; i++) {
			if (i == 0 || i == (length - 1)) {
				double n = Math.random();
				character = aSymbols.substring((int) (n * aSymbols.length()),
						(int) (n * aSymbols.length() + 1));
				word = word.concat(character);
			} else if (i == (int) first || i == (int) second) {
				double n = Math.random();
				character = nSymbols.substring((int) (n * nSymbols.length()),
						(int) (n * nSymbols.length() + 1));
				word = word.concat(character);
			} else {
				double n = Math.random();
				character = symbols.substring((int) (n * symbols.length()),
						(int) (n * symbols.length() + 1));
				word = word.concat(character);
			}
		}
		
		setPassword(word);
	}

}

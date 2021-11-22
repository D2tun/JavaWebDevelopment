package by.epam.task1.ipo.service;


public class UTFSymbolSearch {
	
	private static UTFSymbolSearch instance;
	
	private UTFSymbolSearch() {
		
	}
	
	public static UTFSymbolSearch getInstance() {
		if (instance == null) {
			instance = new UTFSymbolSearch();
		}
		return instance;
	}
	
	public String searchSymbol(char ch) {
		
		byte nextChar = (byte) ((byte) ch + 1);
		byte prevChar = (byte) ((byte) ch - 1);

		
		return "Символу " + ch + " соответствует номер " + (byte) ch 
			   + ".\n Следуюий символ " + (char) nextChar 
			   + ",\n предыдущий " + "символ " + (char) prevChar;
	}
}

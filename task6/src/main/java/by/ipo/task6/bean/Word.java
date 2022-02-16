package by.ipo.task6.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents word. Absent methods will return null.
 * @author Pavel Isidovich
 * @see TextUnit
 */
public class Word implements Serializable, TextUnit {

	/**Data field*/
	private List<Symbol> symbols = new ArrayList<>();
	
	/**
	 * This constructor creates new word object
	 * @param symbol - entered symbol
	 */
	public Word(String word) {		
		for (int i = 0; i < word.length(); ++i) {
			this.symbols.add(new Symbol(word.charAt(i)));
		}
	}

	@Override
	public List<Character> getSymbols() {
		List<Character> symbols = new ArrayList<>(this.symbols.size());

		for (int i = 0; i < this.symbols.size(); ++i) {
			symbols.add(this.symbols.get(i).getSymbols().get(0));
		}
		
		return symbols;
	}
	
	public List<Symbol> getObSymbols() {
		return this.symbols;
	}

	@Override
	public List<String> getWords() {
		List<String> words = new ArrayList<>(1);
		String word = "";
		
		for (int i  = 0; i < this.symbols.size(); ++i) {
			word += this.symbols.get(i).getSymbols().get(0);
		}
		
		words.add(word);
		return words;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbols == null) ? 0 : symbols.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (symbols == null) {
			if (other.symbols != null)
				return false;
		} else if (!symbols.equals(other.symbols))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Word [symbols=" + symbols + "]";
	}
}

package by.ipo.task6.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents symbol (single character). 
 * Absent methods will return null.
 * @author Pavel Isidovich
 * @see TextUnit
 */
public class Symbol implements Serializable, TextUnit {

	/**Data field*/
	private Character symbol;
	
	/**
	 * This constructor creates new symbol object
	 * @param symbol - entered symbol
	 */
	public Symbol(char symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Symbol [symbol=" + symbol + "]";
	}

	@Override
	public List<Character> getSymbols() {
		List<Character> character = new ArrayList<>(1); 
		character.add(this.symbol);
		return character;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + symbol;
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
		Symbol other = (Symbol) obj;
		if (symbol != other.symbol)
			return false;
		return true;
	}
}

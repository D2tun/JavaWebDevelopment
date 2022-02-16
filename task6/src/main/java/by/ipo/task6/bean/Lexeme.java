package by.ipo.task6.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * This class represents lexeme. Methods with mark "deprecated" will 
 * return null.
 * @author Pavel Isidovich
 *
 */
public class Lexeme implements Serializable, TextUnit {

	/**Data fields*/
	private List<Word> words = new ArrayList<>(1);
	private char punctuationMark;
	
	/**
	 * This constructor creates new lexeme object
	 * @param symbol - entered symbol
	 */
	public Lexeme(String lexeme) {
		if (!Character.isLetterOrDigit(lexeme.charAt(lexeme.length() - 1)) 
				&& (lexeme.charAt(lexeme.length() - 1) != '(') 
				&& (lexeme.charAt(lexeme.length() - 1) != ')')) {
			this.punctuationMark = lexeme.charAt(lexeme.length() - 1);
		} else {
			this.punctuationMark = ' ';
		}
		
		if (!lexeme.contains("[!.?,:;]")) {
			String[] lexemeWord = lexeme.split("[!.?,:;]");
			if (Pattern.compile("\\w+").matcher(lexeme).find()) {
				this.words.add(new Word(lexemeWord[0]));
			}
		} else {
			this.words.add(null);
		}
	}
	
	@Override
	public List<Character> getSymbols() {
		List<Character> symbols = new ArrayList<>();
		
		for (int i = 0; i < this.words.size(); ++i) {
			symbols.addAll(this.words.get(i).getSymbols());
		}
		
		if (this.punctuationMark != ' ') {
			symbols.add(this.punctuationMark);
		}
		
		return symbols;
	}
	
	@Override
	public List<String> getWords() {
		List<String> words = new ArrayList<>(1);
		
		for (int i = 0; i < this.words.size(); ++i) {
			words.add(this.words.get(i).getWords().get(0));
		}
		
		return words;
	}

	@Override
	public List<Word> getObWords() {
		return this.words;
	}
	
	@Override
	public List<String> getLexemes() {
		List<String> lexemes = new ArrayList<>(1);
		String lexeme = "";
		
		if (!this.words.isEmpty()) {
			lexeme += this.words.get(0).getWords().get(0);
		}
		
		if (this.punctuationMark != ' ') {
			lexeme += this.punctuationMark;
		}
		lexemes.add(lexeme);
		
		return lexemes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + punctuationMark;
		result = prime * result + ((words == null) ? 0 : words.hashCode());
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
		Lexeme other = (Lexeme) obj;
		if (punctuationMark != other.punctuationMark)
			return false;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lexeme [words=" + words + ", punctuationMark=" + punctuationMark + "]";
	}
}

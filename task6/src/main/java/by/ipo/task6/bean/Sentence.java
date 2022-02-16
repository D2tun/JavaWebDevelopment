package by.ipo.task6.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents sentence.
 * @author Pavel Isidovich
 *
 */
public class Sentence implements Serializable, TextUnit {

	/**Data fields*/
	private List<Lexeme> lexemes = new ArrayList<>();
	
	/**
	 * This constructor creates new sentence object
	 * @param symbol - entered symbol
	 */
	public Sentence(String sentence) {
		String[] data = sentence.split(" ");
		
		for (int i = 0; i < data.length; ++i) {
			this.lexemes.add(new Lexeme(data[i]));
		}
	}
	
	@Override
	public List<Character> getSymbols() {
		List<Character> symbols = new ArrayList<>();
		
		for (int i = 0; i < this.lexemes.size(); ++i) {
			symbols.addAll(this.lexemes.get(i).getSymbols());
		}
		
		return symbols;
	}

	@Override
	public List<String> getWords() {
		List<String> words = new ArrayList<>();
		
		for (int i = 0; i < this.lexemes.size(); ++i) {
			words.addAll(this.lexemes.get(i).getWords());
		}
		
		return words;
	}
	
	@Override
	public List<Word> getObWords() {
		List<Word> words = new ArrayList<>();

		for (int i = 0; i < this.lexemes.size(); ++i) {
			if (!(this.lexemes.get(i).getWords().size() == 0)) {
				words.add(this.lexemes.get(i).getObWords().get(0));
			}
		}
		
		return words;
	}

	@Override
	public List<String> getLexemes() {
		List<String> lexemes = new ArrayList<>(this.lexemes.size());
		
		for (int i = 0; i < this.lexemes.size(); ++i) {
			lexemes.add(this.lexemes.get(i).getLexemes().get(0));
		}
		
		return lexemes;
	}
	
	@Override
	public List<Lexeme> getObLexemes() {
		return this.lexemes;
	}

	@Override
	public List<String> getSentences() {
		String sentence = "";
		
		for (int i = 0; i < this.lexemes.size(); ++i) {
			sentence += this.lexemes.get(i).getLexemes().get(0) + " ";
		}
		
		List<String> sentences = new ArrayList<>(1);
		sentences.add(sentence);
		
		return sentences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lexemes == null) ? 0 : lexemes.hashCode());
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
		Sentence other = (Sentence) obj;
		if (lexemes == null) {
			if (other.lexemes != null)
				return false;
		} else if (!lexemes.equals(other.lexemes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sentence [lexemes=" + lexemes + "]";
	}
}

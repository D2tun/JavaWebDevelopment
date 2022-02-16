package by.ipo.task6.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents text.
 * @author Pavel Isidovich
 *
 */
public class Text implements Serializable, TextUnit{

	/**Data field*/
	private ArrayList<Paragraph> paragrphs = new ArrayList<>();
	
	public Text(String text) {
		String texxt = "a " + text; 
		String[] data = texxt.split("[\t]");

		for (int i = 0; i < data.length; ++i) {
			this.paragrphs.add(new Paragraph(data[i]));
		}	
	}

	@Override
	public String toString() {
		return "Text [paragrphs=" + paragrphs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paragrphs == null) ? 0 : paragrphs.hashCode());
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
		Text other = (Text) obj;
		if (paragrphs == null) {
			if (other.paragrphs != null)
				return false;
		} else if (!paragrphs.equals(other.paragrphs))
			return false;
		return true;
	}

	@Override
	public List<Character> getSymbols() {
		List<Character> characters = new ArrayList<>();
		
		for (int i = 0; i < this.paragrphs.size(); ++i) {
			characters.addAll(this.paragrphs.get(i).getSymbols());
		}
		
		return characters;
	}

	@Override
	public List<String> getWords() {
		List<String> words = new ArrayList<>();
		
		for (int i = 0; i < this.paragrphs.size(); ++i) {
			words.addAll(this.paragrphs.get(i).getWords());
		}
		
		return words;
	}

	@Override
	public List<Word> getObWords() {
		List<Word> words = new ArrayList<>();
		
		for (int i = 0; i < this.paragrphs.size(); ++i) {
			words.addAll(this.paragrphs.get(i).getObWords());
		}
		
		return words;
	}
	
	@Override
	public List<String> getLexemes() {
		List<String> lexemes = new ArrayList<>();
		
		for (int i = 0; i < this.paragrphs.size(); ++i) {
			lexemes.addAll(this.paragrphs.get(i).getLexemes());
		}
		
		return lexemes;
	}
	
	@Override
	public List<Lexeme> getObLexemes() {
		List<Lexeme> lexemes = new ArrayList<>();
		
		for (int i = 0; i < this.paragrphs.size(); ++i) {
			lexemes.addAll(this.paragrphs.get(i).getObLexemes());
		}
		
		return lexemes;
	}

	@Override
	public List<String> getSentences() {
		List<String> sentences = new ArrayList<>();
		
		for (int i = 0; i < this.paragrphs.size(); ++i) {
			sentences.addAll(this.paragrphs.get(i).getSentences());
		}
		
		return sentences;
	}

	@Override
	public List<Sentence> getObSentences() {
		List<Sentence> sentences = new ArrayList<>();
		
		for (int i = 0; i < this.paragrphs.size(); ++i) {
			sentences.addAll(this.paragrphs.get(i).getObSentences());
		}
		
		return sentences;
	}
	
	@Override
	public List<String> getParagraphs() {
		List<String> paragraphs = new ArrayList<>(this.paragrphs.size());
		
		for (int i = 0; i < this.paragrphs.size(); ++i) {
			paragraphs.add(this.paragrphs.get(i).getParagraphs().get(0));
		}
		
		return paragraphs;
	}
	
	@Override
	public List<Paragraph> getObParagraphs() {
		return this.paragrphs;
	}

	@Override
	public String getText() {
		String text = "";
		
		for (int i = 0; i < this.paragrphs.size(); ++i) {
			text += this.paragrphs.get(i).getParagraphs().get(0) + "\n";
		}
		
		return text;
	}
}

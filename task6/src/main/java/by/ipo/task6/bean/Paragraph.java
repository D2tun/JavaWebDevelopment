package by.ipo.task6.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bsh.This;

/**
 * This class represents paragraph.
 * @author Pavel Isidovich
 *
 */
public class Paragraph implements Serializable, TextUnit {

	/**Data field*/
	private List<Sentence> sentences = new ArrayList<>();
	
	/**
	 * This constructor creates new paragraph object
	 * @param symbol - entered symbol
	 */
	public Paragraph(String paragraph) {

		Pattern SENTENCE = Pattern.compile("[A-Z][^.!?]+[.!?]");
		Matcher matcher = SENTENCE.matcher(paragraph);		
		
		while (matcher.find()) {
			this.sentences.add(new Sentence(matcher.group()));
		}
	}
	
	@Override
	public List<Character> getSymbols() {
		List<Character> characters = new ArrayList<>();
		
		for (int i = 0; i < this.sentences.size(); ++i) {
			characters.addAll(this.sentences.get(i).getSymbols());
		}
		
		return characters;
	}

	@Override
	public List<String> getWords() {
		List<String> words = new ArrayList<>();
		
		for (int i = 0; i < this.sentences.size(); ++i) {
			words.addAll(this.sentences.get(i).getWords());
		}
		
		return words;
	}
	
	@Override
	public List<Word> getObWords() {
		List<Word> words = new ArrayList<>();
		
		for (int i = 0; i < this.sentences.size(); ++i) {
			words.addAll(this.sentences.get(i).getObWords());
		}
		
		return words;
	}

	@Override
	public List<String> getLexemes() {
		List<String> lexemes = new ArrayList<>();
		
		for (int i = 0; i < this.sentences.size(); ++i) {
			lexemes.addAll(this.sentences.get(i).getLexemes());
		}
		
		return lexemes;
	}
	
	@Override
	public List<Lexeme> getObLexemes() {
		List<Lexeme> lexemes = new ArrayList<>();
		
		for (int i = 0; i < this.sentences.size(); ++i) {
			lexemes.addAll(this.sentences.get(i).getObLexemes());
		}
		
		return lexemes;
	}

	@Override
	public List<String> getSentences() {
		List<String> sentences = new ArrayList<>(this.sentences.size());
		
		for (int i = 0; i < this.sentences.size(); ++i) {
			sentences.add(this.sentences.get(i).getSentences().get(0));
		}
		
		return sentences;
	}
	
	@Override
	public List<Sentence> getObSentences() {
		return this.sentences;
	}

	@Override
	public List<String> getParagraphs() {
		List<String> paragraphs = new ArrayList<>(1);
		String paragraph = "\t";
		
		for (int i = 0; i < this.sentences.size(); ++i) {
			paragraph += this.sentences.get(i).getSentences().get(0) + " ";
		}
		
		paragraphs.add(paragraph);
		
		return paragraphs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sentences == null) ? 0 : sentences.hashCode());
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
		Paragraph other = (Paragraph) obj;
		if (sentences == null) {
			if (other.sentences != null)
				return false;
		} else if (!sentences.equals(other.sentences))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paragraph [sentences=" + sentences + "]";
	}
}

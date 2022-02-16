package by.ipo.task6.bean;

import java.util.List;

/**
 * This interface contains methods of text unit objects.
 * @author Pavel Isidovich
 *
 */
public interface TextUnit {

	/**
	 * This method gets all symbols from text.
	 * @return array of symbols.
	 */
	public default List<Character> getSymbols() {
		return null;
	};
	
	/**
	 * This method gets all words from text.
	 * @return array of words.
	 */
	public default List<String> getWords() {
		return null;
	};
	
	/**
	 * This method gets all lexemes from text.
	 * @return array of lexemes.
	 */
	public default List<String> getLexemes() {
		return null;
	};
	
	/**
	 * This method gets all sentences from text.
	 * @return array of sentences.
	 */
	public default List<String> getSentences() {
		return null;
	};
	
	/**
	 * This method gets all paragraphs from text.
	 * @return array of paragraphs.
	 */
	public default List<String> getParagraphs() {
		return null;
	}
	
	/**
	 * This method gets text.
	 * @return text in string format.
	 */
	public default String getText() {
		return null;
	};
	
	/**
	 * This method gets word-objects.
	 * @return words as a list of word-objects
	 */
	public default List<Word> getObWords() {
		return null;
	};
	
	/**
	 * This method gets lexeme-objects.
	 * @return lexemes as a list of lexeme-objects.
	 */
	public default List<Lexeme> getObLexemes() {
		return null;
	};
	
	/**
	 * This method gets sentence-objects.
	 * @return sentences as a list of sentence-objects.
	 */
	public default List<Sentence> getObSentences() {
		return null;
	};
	
	/**
	 * This method gets paragraph-objects.
	 * @return paragraphs as a list of paragraph-objects.
	 */
	public default List<Paragraph> getObParagraphs() {
		return null;
	};
}

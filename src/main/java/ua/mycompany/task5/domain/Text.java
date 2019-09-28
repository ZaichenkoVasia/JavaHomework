package ua.mycompany.task5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text {
    private Sentence header;
    private List<Sentence> sentences;

    public Text() {
        sentences = new ArrayList<>();
    }

    public Text(Sentence header, List<Sentence> sentences) {
        this.header = header;
        this.sentences = sentences;
    }

    public Sentence getHeader() {
        return header;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public Text split(String text) {
        char[] charText = text.toCharArray();

        List<Word> words = new ArrayList<>();
        List<Symbol> symbols = new ArrayList<>();

        for (int i = 0; i < charText.length; i++) {

            Symbol symbol = new Letter(charText[i]);
            symbols.add(symbol);

            if (charText[i] == ' ' || charText[i] == '.') {
                Word word = new Word(symbols);
                symbols = new ArrayList<>();
                words.add(word);
            }

            if (charText[i] == '.') {
                Sentence sentence = new Sentence(words);
                if(header == null) {
                    header = sentence;
                }
                words = new ArrayList<>();
                sentences.add(sentence);
            }
        }

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(header, text.header) &&
                Objects.equals(sentences, text.sentences);
    }

    @Override
    public int hashCode() {
        class Inner{
            void display(){
                System.out.println(header);
            }
        }
        Inner inner = new Inner();
        inner.display();
        return Objects.hash(header, sentences);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(header);
        result.append("\n");

        for (Sentence sentence : sentences
        ) {
            result.append(sentence);
        }
        return result.toString();

    }
}

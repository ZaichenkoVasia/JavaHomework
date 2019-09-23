package ua.mycompany.text;

public class Sentence {

    private Word[] words;

    private Punctuation punctuation;

    public Sentence(String sentence, Punctuation punctuation) {
        this.punctuation = punctuation;
        words = new Word[0];
        splitForWords(sentence);
    }

    public int lengthWords() {
        return words.length;
    }

    public Word[] getWords() {
        return words;
    }

    public Punctuation getPunctuation() {
        return punctuation;
    }

    private void splitForWords(String sentence) {
        char[] chars = sentence.toCharArray();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ',' || chars[i] == ':' || chars[i] == ' ') {
                if (word.toString().equals("")) {
                    continue;
                }
                addWord(word.toString(), new Punctuation(chars[i]));
                word = new StringBuilder();
            } else word.append(chars[i]);
        }

        addWord(word.toString(), new Punctuation(' '));
    }

    private void addWord(String word, Punctuation punctuation) {
        Word[] newWords = new Word[words.length + 1];
        int i = 0;
        for (; i < words.length; i++) {
            newWords[i] = words[i];
        }

        if (punctuation.get() == ' ') {
            newWords[i] = new Word(word);
        } else {
            newWords[i] = new Word(word, punctuation);
        }
        words = newWords;
    }

    @Override
    public String toString() {
        StringBuilder senten = new StringBuilder();
        for (Word word : words) {
            senten.append(word.toString()).append(" ");
        }
        senten.deleteCharAt(senten.lastIndexOf(" "));
        senten.append(punctuation.get());
        senten.append(" ");
        return senten.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sentence sentence = (Sentence) o;
        if (sentence.lengthWords() != this.lengthWords()) {
            return false;
        }

        for (int i = 0; i < lengthWords(); i++) {
            if (sentence.getWords()[i] == getWords()[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (Word element : words)
            result = 31 * result + (element == null ? 0 : element.hashCode());
        return result;
    }
}

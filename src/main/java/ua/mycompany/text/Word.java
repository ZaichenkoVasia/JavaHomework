package ua.mycompany.text;

public class Word {
    private Symbol[] symbs;
    private Punctuation punctuation = null;

    public Word(String word) {
        this.symbs = new Symbol[0];
        splitForLetters(word);
    }

    public Symbol[] getSymbs() {
        return symbs;
    }

    public int length() {
        return symbs.length;
    }

    public Word(String word, Punctuation punctuation) {
        this.punctuation = punctuation;
        this.symbs = new Symbol[0];
        splitForLetters(word);
    }

    private void splitForLetters(String word) {
        char[] wordChs = word.toCharArray();
        symbs = new Symbol[wordChs.length];
        for (int i = 0; i < wordChs.length; i++)
            symbs[i] = new Symbol(wordChs[i]);
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Symbol symb : symbs) {
            word.append(symb.get());
        }
        if (punctuation != null) word.append(punctuation.get());
        return word.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        if (word.length() != this.length())
            return false;

        for (int i = 0; i < length(); i++) {
            if (word.getSymbs()[i] != symbs[i])
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (Object element : symbs)
            result = 31 * result + (element == null ? 0 : element.hashCode());
        return result;
    }
}

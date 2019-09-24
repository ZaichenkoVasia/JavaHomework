package ua.mycompany.task.text;

public class Text {

    private Sentence[] sents;

    public Text(String text) {
        this.sents = new Sentence[0];
        splitForSentence(text);
    }

    public Sentence[] getSents() {
        return sents;
    }

    public int lenght() {
        return sents.length;
    }

    private void splitForSentence(String text) {
        char[] chars = text.toCharArray();
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.' || chars[i] == '?' || chars[i] == '!') {
                addSentence(sentence.toString(), new Punctuation(chars[i]));
                sentence = new StringBuilder();
            } else sentence.append(chars[i]);
        }
    }

    private void addSentence(String sentence, Punctuation punctuation) {
        Sentence[] newSents = new Sentence[sents.length + 1];
        int i = 0;
        for (; i < sents.length; i++) {
            newSents[i] = sents[i];
        }
        newSents[i] = new Sentence(sentence, punctuation);
        sents = newSents;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Sentence sent : sents) {
            text.append(sent.toString());
        }
        return text.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Text text = (Text) o;
        if (text.lenght() != this.lenght())
            return false;

        for (int i = 0; i < this.lenght(); i++) {
            if (text.getSents()[i] != sents[i])
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (Object element : sents)
            result = 31 * result + (element == null ? 0 : element.hashCode());
        return result;
    }

    public void suppText(String text) {
        char[] chars = text.toCharArray();
        for (char aChar : chars) {
            if (aChar == '.' || aChar == '?' || aChar == '!') {
                addSentence(text, new Punctuation(aChar));
            }
        }
    }

    public String getTitle (){
        return sents[0].toString();
    }
}

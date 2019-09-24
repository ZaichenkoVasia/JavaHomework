package ua.mycompany.task.text;

import java.util.Objects;

public class Punctuation {
    private char ch;

    public Punctuation(char ch) {
        this.ch = ch;
    }

    public char get() {
        return ch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Punctuation that = (Punctuation) o;
        return ch == that.ch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ch);
    }
}

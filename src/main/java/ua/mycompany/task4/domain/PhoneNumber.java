package ua.mycompany.task4.domain;

import java.util.Objects;

public class PhoneNumber {
    private final int codeCountry;
    private final int number;

    public PhoneNumber(int codeCountry, int number) {
        this.codeCountry = codeCountry;
        this.number = number;
    }

    public int getCodeCountry() {
        return codeCountry;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return codeCountry == that.codeCountry &&
                number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeCountry, number);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "codeCountry=" + codeCountry +
                ", number=" + number +
                '}';
    }
}

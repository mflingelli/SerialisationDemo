package de.flingelli.training.json.map;

import java.util.Objects;

public class Word {
    private String word;
    private String translation;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word) && Objects.equals(translation, word1.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, translation);
    }
}

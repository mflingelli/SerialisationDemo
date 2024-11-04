package de.flingelli.training.jaxb.map;

import jakarta.xml.bind.annotation.XmlElement;

public class Word {
    private String word;
    private String translation;

    public String getWord() {
        return word;
    }

    @XmlElement
    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    @XmlElement
    public void setTranslation(String translation) {
        this.translation = translation;
    }
}

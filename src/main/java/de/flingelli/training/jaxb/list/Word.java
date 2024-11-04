package de.flingelli.training.jaxb.list;

import jakarta.xml.bind.annotation.*;

public class Word {
    private long id;
    private String word;
    private String translation;

    public long getId() {
        return id;
    }

    @XmlElement
    public void setId(long id) {
        this.id = id;
    }

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

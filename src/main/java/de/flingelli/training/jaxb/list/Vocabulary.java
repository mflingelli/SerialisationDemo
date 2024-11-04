package de.flingelli.training.jaxb.list;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Vocabulary")
public class Vocabulary {
    private List<Word> words = new ArrayList<>();

    public boolean addWord(Word word) {
        return words.add(word);
    }

    public List<Word> getWords() {
        return words;
    }

    @XmlElementWrapper(name = "words")
    @XmlElement(name = "word")
    public void setWords(List<Word> words) {
        this.words = words;
    }

    public void writeToFile(String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Vocabulary.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(this, new File(filename));
    }

    public void readFromFile(String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Vocabulary.class);
        Vocabulary vocabulary = (Vocabulary) context.createUnmarshaller().unmarshal(new File(filename));
        words.clear();
        words.addAll(vocabulary.getWords());
    }
}
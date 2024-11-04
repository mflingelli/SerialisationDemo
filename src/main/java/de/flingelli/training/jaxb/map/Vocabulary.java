package de.flingelli.training.jaxb.map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "Vocabulary")
public class Vocabulary {
    private Map<Long, Word> words = new HashMap();

    public void putWord(long id, Word word) {
        words.put(id, word);
    }

    public Map<Long, Word> getWords() {
        return words;
    }

    @XmlElementWrapper(name = "words")
    @XmlElement(name = "word")
    public void setWords(Map<Long, Word> words) {
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
        words.putAll(vocabulary.getWords());
    }
}

package de.flingelli.training.jaxb.map;

import jakarta.xml.bind.JAXBException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class VocabularyTest {
    private static String FILENAME = "vocabulary_map.xml";

    @Test
    public void writeFile() throws JAXBException, IOException {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.addWord(0, getWord("Auto", "car"));
        vocabulary.addWord(1, getWord("Fahrrad", "bike"));
        vocabulary.writeToFile(FILENAME);
        Files.deleteIfExists(Paths.get(FILENAME));
    }

    @Test
    public void readFile() throws JAXBException, IOException {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.addWord(0, getWord("Auto", "car"));
        vocabulary.addWord(1, getWord("Fahrrad", "bike"));
        vocabulary.addWord(2, getWord("Boot", "boat"));
        vocabulary.writeToFile(FILENAME);
        vocabulary = new Vocabulary();
        Assert.assertEquals(vocabulary.getWords().size(), 0);
        vocabulary.readFromFile(FILENAME);
        Assert.assertEquals(vocabulary.getWords().size(), 3);
        Files.deleteIfExists(Paths.get(FILENAME));
    }

    private Word getWord(String word, String translation) {
        Word result = new Word();
        result.setWord(word);
        result.setTranslation(translation);
        return result;
    }
}

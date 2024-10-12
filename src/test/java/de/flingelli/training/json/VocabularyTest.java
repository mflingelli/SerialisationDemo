package de.flingelli.training.json;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VocabularyTest {
    private static String FILENAME = "vocabulary.json";

    @Test
    public void writeFile() throws IOException {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.addWord(getWord(0, "Auto", "car"));
        vocabulary.addWord(getWord(1, "Fahrrad", "bike"));
        vocabulary.writeToFile(FILENAME);
        Files.deleteIfExists(Paths.get(FILENAME));
    }

    @Test
    public void readFile() throws IOException {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.addWord(getWord(0, "Auto", "car"));
        vocabulary.addWord(getWord(1, "Fahrrad", "bike"));
        vocabulary.addWord(getWord(2, "Boot", "boat"));
        vocabulary.writeToFile(FILENAME);
        vocabulary = new Vocabulary();
        Assert.assertEquals(vocabulary.getWords().size(), 0);
        vocabulary.readFromFile(FILENAME);
        Assert.assertEquals(vocabulary.getWords().size(), 3);
        Files.deleteIfExists(Paths.get(FILENAME));
    }

    private Word getWord(long id, String word, String translation) {
        Word result = new Word();
        result.setId(id);
        result.setWord(word);
        result.setTranslation(translation);
        return result;
    }
}

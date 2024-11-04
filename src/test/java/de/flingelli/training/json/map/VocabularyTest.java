package de.flingelli.training.json.map;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VocabularyTest {
    private static String FILENAME = "vocabulary_map.json";

    @Test
    public void writeFile() throws IOException {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.putWord(0, getWord("Auto", "car"));
        vocabulary.putWord(1, getWord("Fahrrad", "bike"));
        vocabulary.writeToFile(FILENAME);
        Files.deleteIfExists(Paths.get(FILENAME));
    }

    @Test
    public void readFile() throws IOException {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.putWord(0, getWord("Auto", "car"));
        vocabulary.putWord(1, getWord("Fahrrad", "bike"));
        vocabulary.putWord(2, getWord("Boot", "boat"));
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

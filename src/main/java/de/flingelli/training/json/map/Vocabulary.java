package de.flingelli.training.json.map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Vocabulary {
    private Map<Long, Word> words = new HashMap<>();

    public void putWord(long id, Word word) {
        words.put(id, word);
    }

    public Map<Long, Word> getWords() {
        return words;
    }

    public void setWords(Map<Long, Word> words) {
        this.words = words;
    }

    public void writeToFile(String filename) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(this, writer);
        }
    }

    public void readFromFile(String filename) throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filename)) {
            Vocabulary vocabulary = gson.fromJson(reader, Vocabulary.class);
            words.clear();
            words.putAll(vocabulary.getWords());
        }
    }
}

package de.flingelli.training.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;

public class Vocabulary {
    private ArrayList<Word> words = new ArrayList<>();

    public boolean addWord(Word word) {
        return words.add(word);
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
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
            words.addAll(vocabulary.getWords());
        }
    }
}

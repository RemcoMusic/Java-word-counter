package com.rvg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextProcessing implements WordFrequency{

    private String unprocessedText;
    private List<String> words;
    private List<Integer> frequency;

    public TextProcessing(String text){
        unprocessedText = text;
        processText();
    }

    @Override
    public void processText() {
        String[] rawWordsList;
        if(unprocessedText == null || unprocessedText.isEmpty()){
            rawWordsList = new String[0];
        } else {
            rawWordsList = unprocessedText.split("\\s+");
        }
        Map<String, Integer> frequencyWords = new HashMap<>();

        for (String word : rawWordsList) {
            frequencyWords.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
        words = new ArrayList<String>(frequencyWords.keySet());
        frequency = new ArrayList<Integer>(frequencyWords.values());
    }

    @Override
    public List<String> getWord() {
        return words;
    }

    @Override
    public List<Integer> getFrequency() {
        return frequency;
    }
}

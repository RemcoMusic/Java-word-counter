package com.rvg;

import java.util.*;
import java.util.stream.Collectors;

public class TextAnalyzer implements  WordFrequencyAnalyzer{
    //TODO programming situation when 2 words have the same frequency
    @Override
    public int calculateHighestFrequency(String text) {
        TextProcessing words = new TextProcessing(text);

        int maxSoFar = words.getFrequency().get(0);
        int maxSoFarIndex = 0;
        int wordIndex = 0;
        for (int frequency: words.getFrequency()) {
            if (frequency > maxSoFar){
                maxSoFar = frequency;
                wordIndex = maxSoFarIndex;
            }
            maxSoFarIndex++;
        }
        System.out.println("The word with highest frequency is: " + words.getWord().get(wordIndex) + " with a frequency of: " + maxSoFar);
        return maxSoFar;
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        TextProcessing words = new TextProcessing(text);
        if(words.getWord().contains(word)){
            int indexOfWord = words.getWord().indexOf(word);
            return words.getFrequency().get(indexOfWord);
        } else {
            return 0;
        }
    }

    @Override
    public Map calculateMostFrequentNWords(String text, int n) {
        String[] rawWordsList;
        if(text == null || text.isEmpty()){
            rawWordsList = new String[0];
        } else {
            rawWordsList = text.split("\\s+");
        }
        Map<String, Integer> frequencyWords = new HashMap<>();

        for (String word : rawWordsList) {
            frequencyWords.compute(word.toLowerCase(), (k, v) -> v == null ? 1 : v + 1);
        }

        Map<String, Integer> result = frequencyWords.entrySet()
                .stream()
                .sorted(Map.Entry
                        .<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(n)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }
}

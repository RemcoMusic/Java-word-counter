package com.rvg;

import java.util.Map;

public interface WordFrequencyAnalyzer {
    int calculateHighestFrequency(String text);
    int calculateFrequencyForWord(String text, String word);
    Map calculateMostFrequentNWords(String text, int n);
}

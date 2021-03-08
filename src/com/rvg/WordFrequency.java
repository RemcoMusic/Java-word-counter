package com.rvg;

import java.util.List;

public interface WordFrequency {
    void processText();
    List<String> getWord();
    List<Integer> getFrequency();
}

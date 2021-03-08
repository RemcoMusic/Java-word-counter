package com.rvg;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Program starting");
	    String text = "The sun shines over the lake lake the lake lake";
	    String word = "shines";

	    TextAnalyzer foo = new TextAnalyzer();

	    foo.calculateHighestFrequency(text);

		System.out.println("The word: \"" + word + "\" is present: " + foo.calculateFrequencyForWord(text,word) + " time(s).");

		Map result = foo.calculateMostFrequentNWords(text, 3);

		System.out.println(result);
    }
}

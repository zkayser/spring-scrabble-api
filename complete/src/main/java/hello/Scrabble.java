package hello;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Scrabble {
		private static final HashMap<Integer, Integer>  letterToScore = new HashMap<Integer, Integer>();
		public final String word;
		public final Integer score;

    Scrabble(String word) {
    	String[] letterGroups = {"AEIOULNRST", "DG", "BCMP", "FHVWY", "K", "JX", "QZ"};
    	Integer[] scores = {1, 2, 3, 4, 5, 8, 10};
    	IntStream.range(0, scores.length).forEach(index -> addToScoreMap(letterGroups[index], scores[index]));
    	this.word = word.toUpperCase();
    	this.score = getScore();
    }

    Integer getScore() {
    	return fold(word, 0, x -> y -> letterToScore.get(x) + y);
    }

    private Integer fold(String str, Integer acc, Function<Integer, Function<Integer, Integer>> f) {
    	return str.isEmpty() ? acc : f.apply(str.codePointAt(0)).apply(fold(str.substring(1), acc, f));
    }

    private void addToScoreMap(String letters, Integer value) {
    	letters.chars().forEach(letter -> letterToScore.put(letter, value));
    }
}
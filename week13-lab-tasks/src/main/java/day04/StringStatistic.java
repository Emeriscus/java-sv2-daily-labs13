package day04;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StringStatistic {

    private static final String VOWELS = "aeiou";

    public Map<Character, Integer> vowelCounter(String text) {
        Map<Character, Integer> result = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char act = text.charAt(i);
            if (isVowel(act)) {
                if (!result.containsKey(act)) {
                    result.put(act, 1);
                } else {
                    result.put(act, result.get(text.charAt(i)) + 1);
                }
            }
        }
        return result;
    }

    private boolean isVowel(char c) {
        return VOWELS.indexOf(Character.toLowerCase(c)) >= 0;
    }

    public Map<Character, Integer> vowelCounter2(String text) {
        Map<Character, Integer> result = new HashMap<>();
        for (Character actual : text.toCharArray()) {
            if (isVowel(actual) && !result.containsKey(actual)) {
                result.put(actual, 1);
            } else if (isVowel(actual)) {
                result.put(actual, result.get(actual) + 1);
            }
        }
        return result;
    }
}

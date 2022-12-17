package lab1;

import java.util.ArrayList;

public class StringArray {
    public static String[] lessThanAverage(String[] words) {
        double sumSymbols = 0;
        ArrayList<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            sumSymbols += word.length();
        }

        double avgLength = sumSymbols / words.length;

        for (String word : words) {
            if (word.length() < avgLength) {
                filteredWords.add(word);
            }
        }

        String[] result = new String[filteredWords.size()];
        return filteredWords.toArray(result);
    }
}

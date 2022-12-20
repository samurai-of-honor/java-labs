package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StringArrayLambda {
    public static String[] lessThanAverage(String[] words) {
        if (words.length <= 1) {
            return words;
        }

        int avgLength = String.join("", words).length() / words.length;

        Supplier<ArrayList<String>> strList = ArrayList::new;
        ArrayList<String> filteredWords = strList.get();

        BiPredicate<String, Integer> isLess = (s, n) -> s.length() <= n;

        Consumer<String> addIfLess = (word) -> {
            if (isLess.test(word, avgLength)) {
                filteredWords.add(word);
            }
        };

        for (String word : words) {
            addIfLess.accept(word);
        }

        Supplier<String[]> strArray = () -> new String[filteredWords.size()];

        return filteredWords.toArray(strArray.get());
    }

    public static void main(String[] args) {
        String[] words = {"a", "bb", "ccc", "dddd"};
        String[] resArray = StringArrayLambda.lessThanAverage(words);
        System.out.println(Arrays.toString(resArray));
    }
}

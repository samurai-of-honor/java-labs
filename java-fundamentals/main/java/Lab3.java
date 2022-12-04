import java.util.Arrays;
import java.util.Comparator;

public class Lab3 {
    public static StringBuffer sortBySymbolCount(StringBuffer s, char c) {
        String[] stringWords = s.toString().toLowerCase().split(" |[,.!?]+ |[.!?]");
        StringBuffer[] sortedWords = new StringBuffer[stringWords.length];

        for (int i = 0; i < stringWords.length; i++) {
            sortedWords[i] = new StringBuffer(stringWords[i]);
        }

        Arrays.sort(sortedWords, new CompareBySymbolCount(c));

        return new StringBuffer(Arrays.toString(sortedWords));
    }

    public static void main(String[] args) {
        StringBuffer testS = new StringBuffer("Hello, world! ");
        System.out.println("Before:\n" + testS);
        System.out.println("After sort by symbol count:\n" + sortBySymbolCount(testS, 'd'));
    }
}

class CompareBySymbolCount implements Comparator<StringBuffer> {
    private final char c;

    public CompareBySymbolCount(char c) {
        this.c = c;
    }

    @Override
    public int compare(StringBuffer o1, StringBuffer o2) {
        int count1 = 0, count2 = 0;

        for (int i = 0; i < o1.length(); i++) {
            if (o1.charAt(i) == c) {
                count1++;
            }
        }

        for (int i = 0; i < o2.length(); i++) {
            if (o2.charAt(i) == c) {
                count2++;
            }
        }

        return count2 - count1;
    }
}
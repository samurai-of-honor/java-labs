package lab6;

import java.util.HashMap;
import java.util.Scanner;

public class Translator {
    private HashMap<String, String> dictionary;

    public Translator() {
        this.dictionary = new HashMap<>();
    }

    public Translator(HashMap<String, String> dict) {
        this.dictionary = dict;
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(HashMap<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    // Add new word from console
    public void addWord() {
        System.out.print("""
                Enter words in this format
                  engWord:ukrWord
                Or enter "exit" to exit
                """);

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        while (!str.equals("exit")) {
            String[] words = str.split(":");
            if (words.length != 2) {
                System.out.println("Wrong format");
            } else {
                dictionary.put(words[0], words[1]);
            }
            str = in.nextLine();
        }
    }

    // Add new word by input words
    public void addWord(String engWord, String ukrWord) {
        dictionary.put(engWord, ukrWord);
    }

    public String translate(String text) {
        boolean isUpper;
        String[] words = text.split(" |[.,?!] |[.?!]");

        for (String word : words) {
            isUpper = Character.isUpperCase(word.charAt(0));

            String ukrWord = dictionary.get(word.toLowerCase());
            if (ukrWord != null) {
                if (isUpper) {
                    ukrWord = ukrWord.substring(0, 1).toUpperCase() + ukrWord.substring(1);
                }
                text = text.replace(word, ukrWord);
            }
        }
        return text;
    }

    public static void main(String[] args) {
        HashMap<String, String> testMap = new HashMap<>() {{
            put("test", "тест");
        }};

        Translator translator = new Translator(testMap);
        translator.addWord("random", "випадковий");
        translator.addWord();


        System.out.print("Enter text to translate: ");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        String translateResult = translator.translate(text);
        System.out.println(translateResult);
    }
}

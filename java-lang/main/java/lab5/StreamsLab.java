package lab5;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamsLab {
    public static String getMaxLineFromFile(String filePath) {
        int maxCount = 0;
        String maxLine = "";

        try (BufferedReader r = new BufferedReader(new FileReader(filePath))) {
            String line = r.readLine();

            while (line != null) {
                int len = line.split(" ").length;

                if (len > maxCount) {
                    maxLine = line;
                    maxCount = len;
                }

                line = r.readLine();
            }
        } catch (IOException e) {
            return e.getMessage();
        }

        return maxLine;
    }

    public static Map<String, Integer> getTagsCount(String url) {
        Map<String, Integer> tags = new HashMap<>();
        StringBuilder page = new StringBuilder();


        try (BufferedReader r = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            String line = r.readLine();

            while (line != null) {
                page.append(line);
                line = r.readLine();
            }

            Pattern pattern = Pattern.compile("<[a-z0-9]+?[ >]");
            Matcher matcher = pattern.matcher(page);

            while (matcher.find()) {
                String tag = matcher.group().substring(1, matcher.group().length() - 1);
                tags.put(tag, tags.getOrDefault(tag, 0) + 1);
            }
        } catch (IOException e) {
            return null;
        }
        return tags;
    }

    public static Map<String, Integer> sortTagsByCount(Map<String, Integer> unsortTags) {

        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortTags.entrySet());


        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        Map<String, Integer> sortedTags = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedTags.put(entry.getKey(), entry.getValue());
        }

        return sortedTags;
    }

    public static void main(String[] args) {
        String textPath = "src/main/java/lab5/text.txt";
        String shapePath = "src/main/java/lab5/shapes";
        String filePath = "src/main/java/lab5/file.txt";
        String url = "http://www.example.com/";

        // Task 1
        System.out.println(StreamsLab.getMaxLineFromFile(textPath) + "\n");

        // Task 2
        lab3.Shape[] shapes = lab3.ShapeHandler.generateRandomShapes(3);
        lab3.ShapeHandler.saveShapes(shapes, shapePath);

        lab3.Shape[] loadedShapes = lab3.ShapeHandler.loadShapes(shapePath);
        if (loadedShapes != null) {
            for (lab3.Shape shape : loadedShapes) {
                System.out.println(shape.toString());
            }
        }


        // Task 3
        char[] chars = "Hello world!".toCharArray();
        try (EncodingStream ostream = new EncodingStream(new BufferedWriter(new FileWriter(filePath)))) {
            ostream.write(chars, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] decodedChars = new char[chars.length];
        try (DecodingStream istream = new DecodingStream(new BufferedReader(new FileReader(filePath)))) {
            int n = istream.read(decodedChars, 1);
            System.out.printf("\nDecoded %d character:\n", n);
            System.out.println(decodedChars);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Task 4
        Map<String, Integer> tags = StreamsLab.getTagsCount(url);

        Map<String, Integer> tagsByLexicographic = new TreeMap<>(tags);
        System.out.println("\n" + tagsByLexicographic);

        Map<String, Integer> tagsByCount = StreamsLab.sortTagsByCount(tags);
        System.out.println(tagsByCount);
    }
}

class EncodingStream extends FilterWriter {
    protected EncodingStream(Writer out) {
        super(out);
    }

    public void write(char[] cbuf, int key) throws IOException {
        for (int i = 0; i < cbuf.length; i++) {
            cbuf[i] = (char) (cbuf[i] + key);
        }
        super.write(cbuf, 0, cbuf.length);
    }
}

class DecodingStream extends FilterReader {
    protected DecodingStream(Reader in) {
        super(in);
    }

    public int read(char[] cbuf, int key) throws IOException {
        int count = super.read(cbuf, 0, cbuf.length);
        for (int i = 0; i < count; i++) {
            cbuf[i] = (char) (cbuf[i] - key);
        }
        return count;
    }
}
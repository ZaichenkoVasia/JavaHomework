package ua.mycompany.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFromFile {
    private static final String FILE ="D:\\string.txt";

    public static void main(String[] args) throws IOException {
        String text = readOneTask(FILE);
        System.out.println(text);
        System.out.println(mergeByMapMethod(text));
    }

    private static String readOneTask(String file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file)) ){
            StringBuilder result = new StringBuilder();
            String line;
            while ((line= reader.readLine())!= null){
                result.append(line);
            }
            return result.toString();
        }
    }

    private static Map<Character, Integer> mergeByMapMethod(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = sentence.toCharArray();

        for (char aChar : chars) {
            map.merge(aChar, 1, (oldCounter, counter) -> ++oldCounter);
        }
        return map;
    }
}

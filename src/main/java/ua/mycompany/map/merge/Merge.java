package ua.mycompany.map.merge;
import java.util.HashMap;
import java.util.Map;

public class Merge {
    public static void main(String[] args) {
        System.out.println(mergeByCounter("Hello"));
        System.out.println(mergeByMapMethod("Hello"));
    }

    public static Map<Character, Integer> mergeByCounter(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Argument is null");
        }

        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = sentence.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                Integer counter = map.get(aChar);
                map.put(aChar, ++counter);
            } else {
                map.put(aChar, 1);
            }

        }
        return map;
    }

    public static Map<Character, Integer> mergeByMapMethod(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Argument is null");
        }

        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = sentence.toCharArray();
        for (char aChar : chars) {
            map.merge(aChar,1, (a,b) -> (++a));
        }
        return map;
    }
}

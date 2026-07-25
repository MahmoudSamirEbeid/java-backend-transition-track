import java.util.*;

public class Exercise09 {

    public static void main(String[] args) {

        String[] words = {
                "Apple",
                "Ant",
                "Ball",
                "Book",
                "Cat",
                "Car",
                "Dog"
        };

        Map<Character, List<String>> dictionary = new TreeMap<>();

        // Store words in the map
        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            char letter = Character.toUpperCase(word.charAt(0));

            if (!dictionary.containsKey(letter)) {
                dictionary.put(letter, new ArrayList<>());
            }

            dictionary.get(letter).add(word);
        }

        // Sort words
        List<List<String>> lists = new ArrayList<>(dictionary.values());

        for (int i = 0; i < lists.size(); i++) {
            Collections.sort(lists.get(i));
        }

        printDictionary(dictionary);

        printWords(dictionary, 'C');
    }

    public static void printDictionary(Map<Character, List<String>> dictionary) {

        List<Character> keys = new ArrayList<>(dictionary.keySet());

        for (int i = 0; i < keys.size(); i++) {

            Character letter = keys.get(i);

            System.out.println(letter + " -> " + dictionary.get(letter));
        }
    }

    public static void printWords(Map<Character, List<String>> dictionary, char letter) {

        System.out.println();
        System.out.println("Words starting with " + letter + ":");

        System.out.println(dictionary.get(letter));
    }
}
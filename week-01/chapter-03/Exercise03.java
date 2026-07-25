public class Exercise03 {

    public static void main(String[] args) {

        String sentence = "Java is easy Java is powerful Java";
        String word = "Java";

        countUsingIndexOf(sentence, word);

        countUsingReplace(sentence, word);
    }

    public static void countUsingIndexOf(String sentence, String word) {

        int count = 0;

        int index = sentence.indexOf(word);

        while (index != -1) {

            count++;

            index = sentence.indexOf(word, index + word.length());
        }

        System.out.println("Using indexOf()");
        System.out.println("Occurrences = " + count);
    }

    public static void countUsingReplace(String sentence, String word) {

        int originalLength = sentence.length();

        String newSentence = sentence.replace(word, "");

        int newLength = newSentence.length();

        int count = (originalLength - newLength) / word.length();

        System.out.println();
        System.out.println("Using replace()");
        System.out.println("Occurrences = " + count);
    }
}
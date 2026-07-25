public class Exercise08 {

    public static void main(String[] args) {

        // Lab Exercise 1

        String string1 = "Mahmoud";
        String string2 = "Ali";

        String longer = betterString(
                string1,
                string2,
                (s1, s2) -> s1.length() > s2.length()
        );

        System.out.println("Longer String = " + longer);

        String first = betterString(
                string1,
                string2,
                (s1, s2) -> true
        );

        System.out.println("First String = " + first);

        // Lab Exercise 2

        String text = "Mahmoud";

        if (containsOnlyLetters(text)) {
            System.out.println("Contains only letters");
        } else {
            System.out.println("Contains non-letter characters");
        }
    }

    public static String betterString(
            String s1,
            String s2,
            StringChecker checker) {

        if (checker.isBetter(s1, s2)) {
            return s1;
        }

        return s2;
    }

    public static boolean containsOnlyLetters(String text) {

        for (int i = 0; i < text.length(); i++) {

            if (!Character.isLetter(text.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

@FunctionalInterface
interface StringChecker {

    boolean isBetter(String s1, String s2);

}
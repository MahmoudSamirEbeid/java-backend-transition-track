public class Exercise01 {

    public static void main(String[] args) {

        displayMessage();

        printValue(10);

        printString(3, "Java");

    }

    public static void displayMessage() {
        System.out.println("Hello, ITI");
    }

    public static void printValue(int value) {
        System.out.println("Value: " + value);
    }

    public static void printString(int number, String text) {
        for (int i = 0; i < number; i++) {
            System.out.println(text);
        }
    }
}
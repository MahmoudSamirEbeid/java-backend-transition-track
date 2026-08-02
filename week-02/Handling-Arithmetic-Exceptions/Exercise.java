public class Exercise {
    public static void main(String[] args) {

        int numerator = 50;
        int denominator = 0;

        // Handle division by zero using try-catch
        try {
            int result = numerator / denominator;
            System.out.println(result);
        }
        // Catch ArithmeticException if denominator is zero
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }

        // This statement always executes
        System.out.println("Program completed");
    }
}
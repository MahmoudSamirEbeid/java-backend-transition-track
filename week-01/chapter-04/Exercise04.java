import java.util.function.Function;

public class Exercise04 {

    public static void main(String[] args) {

        Function<Double, Double> convertToFahrenheit =
                celsius -> (celsius * 9 / 5) + 32;

        double celsius = 25.0;

        double fahrenheit = convertToFahrenheit.apply(celsius);

        System.out.println("Celsius = " + celsius);
        System.out.println("Fahrenheit = " + fahrenheit);
    }
}
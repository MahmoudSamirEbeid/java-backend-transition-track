public class Exercise02Part1 {

    public static void main(String[] args) {

        int[] numbers = generateArray();

        findMinimum(numbers);
        findMaximum(numbers);
    }

    public static int[] generateArray() {

        int[] numbers = new int[1000];

        int first = 1;
        int last = 1000;

        for (int i = 0; i < numbers.length; i++) {

            if (i % 2 == 0) {
                numbers[i] = first++;
            } else {
                numbers[i] = last--;
            }
        }

        return numbers;
    }

    public static void findMinimum(int[] numbers) {

        long startTime = System.nanoTime();

        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Minimum = " + min);
        System.out.println("Minimum Search Time = " + (endTime - startTime) + " ns");
    }

    public static void findMaximum(int[] numbers) {

        long startTime = System.nanoTime();

        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Maximum = " + max);
        System.out.println("Maximum Search Time = " + (endTime - startTime) + " ns");
    }
}
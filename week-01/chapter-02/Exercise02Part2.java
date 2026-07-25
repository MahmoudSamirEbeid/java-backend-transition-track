public class Exercise02Part2 {

    public static void main(String[] args) {

        int[] numbers = generateArray();

        int target = 750;

        binarySearch(numbers, target);
    }

    public static int[] generateArray() {

        int[] numbers = new int[1000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        return numbers;
    }

    public static void binarySearch(int[] numbers, int target) {

        long startTime = System.nanoTime();

        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex <= rightIndex) {

            int middleIndex = (leftIndex + rightIndex) / 2;

            if (numbers[middleIndex] == target) {

                long endTime = System.nanoTime();

                System.out.println("Target Found = " + target);
                System.out.println("Index = " + middleIndex);
                System.out.println("Binary Search Time = " + (endTime - startTime) + " ns");

                return;
            }

            if (target > numbers[middleIndex]) {

                leftIndex = middleIndex + 1;

            } else {

                rightIndex = middleIndex - 1;
            }
        }

    }
}
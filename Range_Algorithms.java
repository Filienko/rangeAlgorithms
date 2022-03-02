public class Range_Algorithms {

    public static void main(String[] args){

        int[] testValuesInefficient = {1000, 2000, 4000, 8000, 16000, 32000, 64000};
        int[] testValuesEfficient = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 256000, 512000, 1000000, 2000000, 4000000, 8000000, 16700000, 33000000, 65000000, 130000000, 260000000};

        System.out.println("Inefficient Range Algorithm testing");

        inefficientRange(testValuesInefficient);

        System.out.println("Less inefficient Range Algorithm testing");

        updatedInefficientRange(testValuesInefficient);

        System.out.println("Efficient Range Algorithm testing");

        efficientRange(testValuesEfficient);

    }

    static int inefficientRange(int[] numbers) {
        int maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }
    public static int updatedInefficientRange(int[] numbers) {
        int maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    public static int efficientRange(int[] numbers) {
        int max = numbers[0];     // find max/min values
        int min = max;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max - min;
    }

}

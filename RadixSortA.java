import java.util.*;

public class RadixSort {
    public static void radixSort(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);
        int exp = 1;
        while (max / exp > 0) {
            countingSortByDigit(array, exp);
            exp *= 10;
        }
    }

    private static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[--count[digit]] = array[i];
        }

        System.arraycopy(output, 0, array, 0, n);
    }

    public static void main(String[] args) {
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(data);
        System.out.println("Sorted array: " + Arrays.toString(data));
    }
}

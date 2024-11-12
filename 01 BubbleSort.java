import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();
        // for (int i : arr) {
        // System.out.print(i + " ");
        // }
        System.out.println("Time taken: " + (endTime - startTime) / 1000000 + " ms");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
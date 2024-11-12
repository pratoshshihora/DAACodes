import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] arr = new int[9000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        long startTime = System.nanoTime();
        selectionSort(arr);
        long endTime = System.nanoTime();
        // for (int i : arr) {
        // System.out.print(i + " ");
        // }
        System.out.println((endTime - startTime) / 1000000);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
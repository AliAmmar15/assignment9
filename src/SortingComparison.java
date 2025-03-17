import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    
    // Bubble Sort
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

   
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // Method to generate a random array
    public static int[] generateRandomArray(int size, int maxValue) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(maxValue);
        }
        return arr;
    }
    
    public static void main(String[] args) {
        int arraySize = 10000;
        int maxValue = 100000;
        
        int[] bubbleArray = generateRandomArray(arraySize, maxValue);
        int[] mergeArray = Arrays.copyOf(bubbleArray, bubbleArray.length);
        
        // Measure Bubble Sort time
        long startBubble = System.nanoTime();
        bubbleSort(bubbleArray);
        long endBubble = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endBubble - startBubble) / 1e6 + " ms");
        
        // Measure Merge Sort time
        long startMerge = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        long endMerge = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endMerge - startMerge) / 1e6 + " ms");
    }
}

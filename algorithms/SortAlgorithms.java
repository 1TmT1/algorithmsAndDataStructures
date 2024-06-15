package algorithms;

import java.util.Arrays;
import java.util.Random;

public class SortAlgorithms {

    // Helper function to print values from an array
    // Time - O(n), Space - O(1)
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println(arr[arr.length - 1]);
    }

    // Helper function to swap between values between two known indexes in an array
    // Time - O(1), Space - O(1)
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper function to get maximum value in array
    // Time - O(n), Space - O(1)
    private static int getMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }

    // Note: also known as Sinking Sort
    // Time - O(n^2), Space - O(1)
    public static void bubbleSort(int[] arr) {
        boolean isSwapped;

        for (int i = 0; i < arr.length - 1; i++) {
            isSwapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }

            if (isSwapped == false) {
                break;
            }
        }
    }

    // Time - O(n^2), Space - O(1)
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }
    }

    // Time - O(n^2), Space - O(1)
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    // Time - O(n * log n), Space - O(n)
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    // Helper function for merge sort algorithm -> take the two sub-arrays divided and merge them into one sorted array
    // Time - O(n), Space - O(n)
    private static void merge(int[] arr, int low, int mid, int high) {
        int s1 = mid - low + 1;
        int s2 = high - mid;

        int[] left = new int[s1];
        int[] right = new int[s2];

        for (int i = 0; i < s1; i++) {
            left[i] = arr[low + i];
        }

        for (int i = 0; i < s2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int current = low;

        while (i < s1 && j < s2) {
            if (left[i] <= right[j]) {
                arr[current] = left[i];
                i++;
            } else {
                arr[current] = right[j];
                j++;
            }

            current++;
        }

        while (i < s1) {
            arr[current] = left[i];
            i++;
            current++;
        }

        while (j < s2) {
            arr[current] = right[j];
            j++;
            current++;
        }
    }

    // Time - O(n * log n), Space - O(1)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int i = partitionMedian(arr, low, high);

            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }

    // Helper function returning bigger value by comparing two values given in two indexes in array
    // Time - O(1), Space - O(1)
    private static int bigger(int[] arr, int x, int y) {
        if (arr[x] > arr[y]) {
            return x;
        }

        return y;
    }

    // Helper function return median value of three value located in array in low, mid, high indexes
    // Time - O(1), Space - O(1)
    private static int getMedianPivot(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int biggest = bigger(arr, low, bigger(arr, mid, high));

        if (biggest == low) {
            return bigger(arr, mid, high);
        }

        if (biggest == high) {
            return bigger(arr, low, mid);
        }

        return bigger(arr, low, high);
    }

    // Helper function for quick sort algorithm -> placing all elements greater than the pivot to its right, smaller to its left
    // Note: pivot selected here is always in the high index after setting median in its position
    // Time - O(n), Space - O(1)
    private static int partitionMedian(int[] arr, int low, int high) {
        int iPivotStart = getMedianPivot(arr, low, high);
        int pivotValue = arr[iPivotStart];
        int iPivotTarget = low;

        swap(arr, iPivotStart, high);
        
        int iPivotTemp = high;

        for (int i = low; i < iPivotTemp; i++) {
            int current = arr[i];

            if (current < pivotValue) {
                swap(arr, i, iPivotTarget);
                iPivotTarget++;
            }
        }

        swap(arr, iPivotTemp, iPivotTarget);
        return iPivotTarget;
    }

    // Helper function for quick sort algorithm -> placing all elements greater than the pivot to its right, smaller to its left
    // Note: pivot selected here is always in the low index
    // Time - O(n), Space - O(1)
    private static int partitionStart(int[] arr, int low, int high) {
        int pivot = arr[low];
        int x = high;

        for (int i = high; i > low; i--) {
            if (arr[i] > pivot) {
                swap(arr, i, x--);
            }
        }

        swap(arr, low, x);

        return x;
    }

    // Helper function for partitionRandom function -> get random index as pivot from low to high and swap it with the high position
    // Time - O(1), Space - O(1)
    private static void randomPivot(int[] arr, int low, int high) {
        Random random = new Random();
        int pivot = random.nextInt(high-low)+low;

        swap(arr, pivot, high);
    }

    // Helper function for quick sort algorithm -> placing all elements greater than the pivot to its right, smaller to its left after placing random pivot in high index using randomPivot function
    // Note: pivot selected here is always in the high index after setting random one in its position
    // Time - O(n), Space - O(1)
    private static int partitionRandom(int[] arr, int low, int high) {
        randomPivot(arr, low, high);
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    // Helper function for quick sort algorithm -> placing all elements greater than the pivot to its right, smaller to its left
    // Note: pivot selected here is always in the high index
    // Time - O(n), Space - O(1)
    private static int partitionEnd(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        
        return i + 1;
    }

    public static void heapSort(int[] arr) {
        int size = arr.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(arr, 0, i);

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);

            heapify(arr, size, largest);
        }
    }

    // Time - O(d*(n+m)), Space - O(n+m)
    public static void radixSort(int[] arr) {
        int max = getMax(arr, arr.length);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
    
    // Helper function for radix sort -> sort the array via counting algorithm using unit digit of array values
    // Time - O(n+m), Space - O(n+m)
    private static void countingSort(int[] arr, int exp) {
        int[] result = new int[arr.length];
        int[] countingArr = new int[10];
        
        for (int i = 0; i < arr.length; i++) {
            countingArr[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            countingArr[i] += countingArr[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            result[countingArr[(arr[i] / exp) % 10] - 1] = arr[i];
            countingArr[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }

    // Time - O(n * log n), Space - O(1)
    public static void shellSort(int[] arr) {
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                int temp = arr[j];
                int x;

                for (x = j; x >= i && arr[x - i] > temp; x -= i) {
                    arr[x] = arr[x - i];
                }

                arr[x] = temp;
            }
        }
    }

    public static void timSort(int[] arr) {
        int minRun = minRunLength();

        for (int i = 0; i < arr.length; i += minRun) {
            insertionSort(arr);
        }

        for (int size = minRun; size < arr.length; size *= 2) {
            for (int low = 0; low < arr.length; low += 2 * size) {
                int mid = low + size - 1;
                int high = Math.min((low + 2 * size - 1), (arr.length - 1));

                if (mid < high) {
                    merge(arr, low, mid, high);
                }
            }
        }
    }

    private static int minRunLength() {
        final int MIN_MERGE = 32;

        int r = 0;
        int min = MIN_MERGE;

        while (min >= MIN_MERGE) {
            r |= (min & 1);
            min >>= 1;
        }

        return min + r;
    }

    // TODO
    public static void bucketSort(int[] arr) {

    }

    // Time - O(n+m) *inputArr & countingArr respectively, Space - O(n+m) *result & countingArr respectively
    public static int[] countingSort(int[] arr) {
        int length = arr.length;
        int max = 0;

        for (int i = 0; i < length; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] countingArr = new int[max + 1];

        for (int i = 0; i < length; i++) {
            countingArr[arr[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            countingArr[i] += countingArr[i - 1];
        }

        int[] result = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            result[countingArr[arr[i]] - 1] = arr[i];
            countingArr[arr[i]]--;
        }

        return result;
    }

    // TODO
    public static void bitonicSort(int[] arr) {

    }

    // TODO
    public static void combSort(int[] arr) {
        
    }

    // Sort array only with values ranging from 0 to 2
    // Time - O(n), Space - O(1)
    public static void dutchNationalFlagProblemSort(int[] arr) {
        int low = 0, high = arr.length -1, i = 0;

        while (i <= high) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                low++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, high);
                high--;
            }
        }
    }

    // Time - O(n+m), Space - O(n+m)
    public static int[] mergeSorted(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int x = 0, y = 0;
        
        for (int i = 0; i < result.length; i++) {
            if (x >= arr1.length) {
                result[i] = arr2[y];
                y++;
                continue;
            }

            if (y >= arr2.length) {
                result[i] = arr1[x];
                x++;
                continue;
            }

            if (arr1[x] <= arr2[y]) {
                result[i] = arr1[x];
                x++;
            } else {
                result[i] = arr2[y];
                y++;
            }
        }

        return result;
    }

    // Time - O(n), Space - O(n)
    public static int[] sortedSquares(int[] arr) {
        int[] result = new int[arr.length];
        int i = 0, j = arr.length - 1;

        for (int x = arr.length - 1; x >= 0; x--) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[x] = arr[i] * arr[i];
                i++;
            } else {
                result[x] = arr[j] * arr[j];
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 632, 213, 53, 231, 323, 12, 1, 0};
        int[] temp = Arrays.copyOf(arr, arr.length);

        System.out.println("Unsorted array:");
        printArray(arr);

        System.out.println("Sorted via bubble sort:");
        bubbleSort(temp);
        printArray(temp);
        System.out.println();

        temp = Arrays.copyOf(arr, arr.length);
        System.out.println("Sorted via insertion sort:");
        insertionSort(temp);
        printArray(temp);
        System.out.println();

        temp = Arrays.copyOf(arr, arr.length);
        System.out.println("Sorted via selection sort:");
        selectionSort(temp);
        printArray(temp);
        System.out.println();

        System.out.println("Sorted via merge sort:");
        temp = Arrays.copyOf(arr, arr.length);
        mergeSort(temp, 0, temp.length - 1);
        printArray(temp);
        System.out.println();

        System.out.println("Sorted via quick sort:");
        temp = Arrays.copyOf(arr, arr.length);
        quickSort(temp, 0, temp.length - 1);
        printArray(temp);
        System.out.println();

        System.out.println("Sorted via heap sort:");
        temp = Arrays.copyOf(arr, arr.length);
        heapSort(temp);
        printArray(temp);
        System.out.println();

        System.out.println("Sorted via counting sort:");
        temp = Arrays.copyOf(arr, arr.length);
        printArray(countingSort(temp));
        System.out.println();

        System.out.println("Sorted via radix sort:");
        temp = Arrays.copyOf(arr, arr.length);
        radixSort(temp);
        printArray(temp);
        System.out.println();

        System.out.println("Sorted via shell sort:");
        temp = Arrays.copyOf(arr, arr.length);
        shellSort(temp);
        printArray(temp);
        System.out.println();

        System.out.println("Sorted via tim sort:");
        temp = Arrays.copyOf(arr, arr.length);
        timSort(temp);
        printArray(temp);
        System.out.println();

        System.out.println("Sorted via Dutch national flag sort:");
        int[] dutchArr = {0, 2, 2, 1, 1, 2, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 0, 1, 2};
        dutchNationalFlagProblemSort(dutchArr);
        printArray(dutchArr);
        System.out.println();

        System.out.println("Sorted squares:");
        int[] squares = sortedSquares(temp);
        printArray(squares);
        System.out.println();

        int[] temp2 = {2, 3, 5, 7, 9, 23, 51};
        System.out.println("Merging two sorted arrays:");
        System.out.print("arr 1: ");
        printArray(temp);
        System.out.print("arr 2: ");
        printArray(temp2);
        printArray(mergeSorted(temp, temp2));
    }
}

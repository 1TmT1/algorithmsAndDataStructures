package data_structures.array;

public class ArrayUtils {

    // Time - O(n), Space - O(1) 
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Time - O(n), Space - O(n)
    public static int[] removeEvens(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 != 0) {
                counter++;
            }
        }

        int[] oddArr = new int[counter];
        counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 != 0) {
                oddArr[counter] = arr[i];
                counter++;
            }
        }

        return oddArr;
    }

    // Time - O(n), Space - O(1) 
    public static void reverseArray(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Time - O(n), Space - O(1)
    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    // Time - O(n), Space - O(1)
    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    // Time - O(n), Space - O(1)
    public static int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }

    // Time - O(n), Space - O(1)
    public static void moveZeroesToEnd(int[] arr) {
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] != 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
        }
    }

    // Time - O(n), Space - O(n)
    public static int[] resize(int[] arr, int capacity) {
        int[] newArray = new int[capacity];

        if (capacity > arr.length) {
            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
        } else if (capacity < arr.length) {
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = arr[i];
            }
        } else {
            return arr;
        }

        return newArray;
    }

    // Time - O(n), Space - O(1)
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int total = n * (n + 1) / 2;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return total - sum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 0, 5, 0, 8, 9, 0, 12, 4, 5, 0};

        printArray(arr);

        int[] oddArr = removeEvens(arr);
        printArray(oddArr);
    
        reverseArray(arr, 0, arr.length-1);
        printArray(arr);
        
        reverseArray(oddArr, 0, oddArr.length-1);
        printArray(oddArr);

        // Print maximum values of each array.
        System.out.println("Max: " + findMax(arr));
        System.out.println("Max: " + findMax(oddArr));

        // Print minimum value of each array.
        System.out.println("Min: " + findMin(arr));
        System.out.println("Min: " + findMin(oddArr));

        // Print second max of each array.
        System.out.println("Second max: " + findSecondMax(arr));
        System.out.println("Second max: " + findSecondMax(oddArr));
        
        // Move zeroes to end while maintaining relative positions of non-zeroes.
        moveZeroesToEnd(arr);
        printArray(arr);

        printArray(resize(arr, 4));

        arr = new int[]{1, 6, 3, 4, 2}; 

        System.out.println("\nMissing number from this array:");
        printArray(arr);
        System.out.println(findMissingNumber(arr));
    }
}   
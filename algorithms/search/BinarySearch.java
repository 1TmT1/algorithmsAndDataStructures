package algorithms.search;

public class BinarySearch {
    public static boolean binarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == value) {
                return true;
            }

            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static int binarySearchInsert(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == value) {
                return mid;
            }

            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 16, 22, 123};

        System.out.println(binarySearch(arr, 3));
        
        System.out.println(binarySearchInsert(arr, 5));
    }
}

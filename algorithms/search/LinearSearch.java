package algorithms.search;

public class LinearSearch {
    public static boolean search(int[] arr, int n, int value) {
        for (int i = 0; i < n && i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 10, 1};

        System.out.println(search(arr, arr.length, 4));
    }
}

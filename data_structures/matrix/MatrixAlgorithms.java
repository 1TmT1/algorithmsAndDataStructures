package data_structures.matrix;

public class MatrixAlgorithms {

    public static void searchSortedMatrix(int[][] matrix, int n, int x) {
        int i = 0;
        int j = n - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j] == x) {
                System.out.println("x found at - [" + i + ", " + j + "]");
                return;
            }

            if (matrix[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Not Found");
    }

    public static void printSpiral(int[][] matrix, int r, int c) {
        int i = 0, k = 0, l = 0;
        while (k < r && l < c) {
            for (i = l; i < c; i++) { // L -> R
                System.out.print(matrix[k][i] + " ");
            }
            k++;
            for (i = k; i < r; i++) { // T -> B
                System.out.print(matrix[i][c-1] + " ");
            }
            c--;
            if (k < r) {
                for (i = c; i >= l; i--) { // R -> L
                    System.out.print(matrix[r-1][i] + " ");
                }
                r--;
            }

            if (l < c) {
                for (i = r - 1; i >= k; i--) { // B -> T
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] martix = {
            {5,  19, 30}, 
            {7,  25, 42}, 
            {10, 27, 50}
        };

        searchSortedMatrix(martix, martix.length, 50);
        printSpiral(martix, martix.length, martix.length);
    }
}

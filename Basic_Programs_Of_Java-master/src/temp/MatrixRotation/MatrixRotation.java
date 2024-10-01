package temp.MatrixRotation;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degress clockwise.
 */
public class MatrixRotation {
    // Function to rotate the matrix by 90 degrees clockwise
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    // Helper function to reverse a row
    private static void reverseRow(int[] row) {
        int start = 0, end = row.length - 1;
        while (start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }

    // Function to print the matrix (for testing)
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("Matrix after 90 degrees clockwise rotation:");
        printMatrix(matrix);
    }

    /*
Output:
Original matrix:
1 2 3
4 5 6
7 8 9

Matrix after 90 degrees clockwise rotation:
7 4 1
8 5 2
9 6 3
     */
}

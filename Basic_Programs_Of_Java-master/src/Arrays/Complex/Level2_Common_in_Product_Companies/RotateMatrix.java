package Arrays.Complex.Level2_Common_in_Product_Companies;

//Rotate matrix (2D array) by 90 degrees in place
public class RotateMatrix {
    public static void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[i][n - j - 1];
                mat[i][n - j - 1] = t;
            }
        }
    }
}
//Time: O(n²), Space: O(1)

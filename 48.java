// class Solution {
//     public void rotate(int[][] mat) {
//         int n = mat.length, k = n - 1;
//         for (int i = 0; i < n >> 1; i++)
//             for (int j = i; j < k - i; j++) {
//                 int t = mat[i][j];
//                 mat[i][j] = mat[k - j][i];
//                 mat[k - j][i] = mat[k - i][k - j];
//                 mat[k - i][k - j] = mat[j][k - i];
//                 mat[j][k - i] = t;
//             }
//     }
// }

class Solution {
    public void rotate(int[][] matrix) {
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
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
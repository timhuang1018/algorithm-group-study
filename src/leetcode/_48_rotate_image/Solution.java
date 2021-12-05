package leetcode._48_rotate_image;

public class Solution {

    public void rotate(int[][] matrix) {

        printMatrix(matrix);
        int N = matrix.length;

        // An N x N matrix will have floor(N/2) square cycles
        // cause in a cycle we visit first row and last row, and so on
        for(int i=0; i< N/2; i++){
            for(int j=i; j< N - i - 1; j++){
                //top to right , right to bottom, bottom to left, left to top
                int temp = matrix[i][j];
                //assign bottom-left to top-left
                matrix[i][j] = matrix[N - 1 - j][i];
                //assign bottm-right to bottom-left
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
                //assign top-right to bottm-right
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
                //assign  top-left to top-right
                matrix[j][N - 1 - i] = temp;
            }
        }
        System.out.println("");
        printMatrix(matrix);
    }
    static void printMatrix(int arr[][])
    {
        int N = arr.length;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print( arr[i][j] + " ");
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        });
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //time complexity O(mn), space complexity O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        //use four border as condition and location
        int n = matrix.length, m = matrix[0].length;
        int up = 0,  down = n - 1;
        int left = 0, right = m - 1;
        while (res.size() < n * m) {
            //top-left to top-right
            for (int j = left; j <= right && res.size() < n * m; j++)
                res.add(matrix[up][j]);

            //top-right to bottom-right
            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
                res.add(matrix[i][right]);

            //bottom-right to bottom-left
            for (int j = right; j >= left && res.size() < n * m; j--)
                res.add(matrix[down][j]);

            //bottom-left to top-left
            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
                res.add(matrix[i][left]);

            //update border
            left++; right--; up++; down--;
        }
        return res;
    }
}

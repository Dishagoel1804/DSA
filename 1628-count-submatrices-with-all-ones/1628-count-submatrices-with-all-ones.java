import java.util.*;

class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] heights = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            // Build histogram heights
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) heights[j]++;
                else heights[j] = 0;
            }

            // Count rectangles in histogram
            ans += countRectangles(heights);
        }
        return ans;
    }

    private int countRectangles(int[] heights) {
        int n = heights.length;
        int[] sum = new int[n]; // sum[j] = rectangles ending at column j
        Stack<Integer> st = new Stack<>();
        int res = 0;

        for (int j = 0; j < n; j++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[j]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                int prev = st.peek();
                sum[j] = sum[prev] + heights[j] * (j - prev);
            } else {
                sum[j] = heights[j] * (j + 1);
            }

            res += sum[j];
            st.push(j);
        }
        return res;
    }
}

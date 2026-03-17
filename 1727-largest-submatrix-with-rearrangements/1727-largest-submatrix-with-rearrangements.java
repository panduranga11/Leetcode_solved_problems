class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int heights[][] = new int[m][n];
        for (int j = 0; j < n; j++) {
            heights[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    heights[i][j] = heights[i - 1][j] + 1;
                } else {
                    heights[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, maxarea(heights[i]));
        }
        return ans;
    }

    public int maxarea(int[] h) {
        int ans = 0;
        int n = h.length;
        Arrays.sort(h);
        for (int i = 0; i < n; i++) {
            ans = Math.max(h[i] * (n - i), ans);

        }
        return ans;
    }

 
}
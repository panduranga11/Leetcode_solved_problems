class Solution {

    static int[][][] dp;

    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m][k + 1];

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = Integer.MIN_VALUE;
                }
            }
        }

        int score = solve(grid, k, 0, 0, 0);
        return score < 0 ? -1 : score;
    }

    public static int solve(int[][] grid, int k, int i, int j, int cost) {

        if (cost > k) {
            return Integer.MIN_VALUE;
        }

        if (i == grid.length || j == grid[0].length) {
            return Integer.MIN_VALUE;
        }

     
        if (dp[i][j][cost] != Integer.MIN_VALUE) {
            return dp[i][j][cost];
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if (grid[i][j] == 0) {
                return dp[i][j][cost] = grid[i][j];
            } else {
                return dp[i][j][cost] =
                        (cost + 1 <= k ? grid[i][j] : Integer.MIN_VALUE);
            }
        }

        int rs, ls;

        if (grid[i][j] == 0) {
            rs = grid[i][j] + solve(grid, k, i, j + 1, cost);
            ls = grid[i][j] + solve(grid, k, i + 1, j, cost);
        } else {
            rs = grid[i][j] + solve(grid, k, i, j + 1, cost + 1);
            ls = grid[i][j] + solve(grid, k, i + 1, j, cost + 1);
        }

       
        dp[i][j][cost] = Math.max(ls, rs);
        return dp[i][j][cost];
    }
}

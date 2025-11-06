class Solution {
    public int len(int i, int j, String s, int[][] dp) {
        // Base cases
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            // Characters match
            dp[i][j] = 2 + len(i + 1, j - 1, s, dp);
        } else {
            // Characters don’t match — choose the better option
            dp[i][j] = Math.max(len(i + 1, j, s, dp), len(i, j - 1, s, dp));
        }
        return dp[i][j];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return len(0, n - 1, s, dp);
    }
}

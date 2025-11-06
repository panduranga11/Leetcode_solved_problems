// class Solution {
//     public int len(int i, int j, String s, int dp[][]) {
//         if (i > j) {
//             return 0;
//         }
//         if (i == j) {
//             return 1;
//         }
//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }

//         if (s.charAt(i) == s.charAt(j)) {
//             return dp[i][j] = 2 + len(i + 1, j - 1, s, dp);
//         } else {
//             return dp[i][j] = Math.max(len(i + 1, j, s, dp), len(i, j - 1, s, dp));
//         }
//     }

//     public int longestPalindromeSubseq(String s) {
//         int n=s.length();
//         int [][]dp=new int[n][n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(i>j){
//                     dp[i][j]=0;
//                 }
//                 if(i==j){
//                     dp[i][j]=1;
//                 }
//             }
//         }

       
//         return len(0, s.length() - 1, s, dp);
//     }
// }
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}


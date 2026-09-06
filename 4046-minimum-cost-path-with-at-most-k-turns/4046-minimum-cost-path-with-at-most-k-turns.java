class Solution {
    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, -1, 0, 1};

    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int  dp[][][][] = new int[m][n][k + 1][5];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int l=0;l<k+1;l++){
                    Arrays.fill(dp[i][j][l],-1);
                }
            }
        }

        int ans = solve(0, 0, 0, k, 4, grid, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(int i, int j, int curk, int k,
                     int prev, int grid[][], int dp[][][][]) {

        if(i == grid.length - 1 &&
           j == grid[0].length - 1) {
            return grid[i][j];
        }
        if(dp[i][j][curk][prev]!=-1){
            return dp[i][j][curk][prev];
        }


        int ans = Integer.MAX_VALUE;

        for(int dir = 0; dir <= 3; dir++) {

            int nr = i + dr[dir];
            int nc = j + dc[dir];

            int newk=curk;
            if(prev!=4 && dir!=prev){
                newk++;
            }

            
          if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && newk<=k ){

         

            int next = solve(nr, nc, newk, k, dir, grid, dp);

            if(next != Integer.MAX_VALUE) {
                ans = Math.min(ans, grid[i][j] + next);
            }
            
        }

        

        
    }
    return dp[i][j][curk][prev]=ans;
}
}
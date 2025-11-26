class Solution {
    public static int count(int i,int j,int mod,int [][]grid,int m,int n,int k,int [][][]dp){
        if(i==m-1 && j==n-1 && mod==0){
            return 1;
        }
        if(i>m-1 || j>n-1){
            return 0;
        }
        if(dp[i][j][mod]!=-1){
            return dp[i][j][mod];
        }
        long ways=0;
        if(i+1<m){
        ways+=count(i+1,j,(mod+grid[i+1][j])%k,grid,m,n,k,dp);
        }
        if(j+1<n){
        ways+=count(i,j+1,(mod+grid[i][j+1])%k,grid,m,n,k,dp);
        }
        return dp[i][j][mod]=(int)(ways%1000000007);

    }
    public int numberOfPaths(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        int dp[][][]=new int[m+1][n+1][k+1];
        for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
        Arrays.fill(dp[i][j], -1);
    }
}
return count(0,0,grid[0][0]%k,grid,m,n,k,dp);

        
    }
}
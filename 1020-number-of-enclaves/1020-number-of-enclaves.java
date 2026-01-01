class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean dp[][]=new boolean[m][n];

        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                solve(0,i,grid.length,grid[0].length,grid,dp);
            }

            if(grid[m-1][i]==1){
                solve(m-1,i,grid.length,grid[0].length,grid,dp);
            }
        }
        for(int i=1;i<m-1;i++){
            if(grid[i][0]==1){
                
                solve(i,0,grid.length,grid[0].length,grid,dp);
                  System.out.println(dp[1][0]);
                
            }

            if(grid[i][n-1]==1){
                solve(i,n-1,grid.length,grid[0].length,grid,dp);
            }
        }
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !dp[i][j]){
                    c++;
                }
            }
        }
      
        return c;

    }
    public void solve(int  i,int j,int row,int col,int [][]mat,boolean [][]dp){
        dp[i][j]=true;
        
        

            int dr[]={-1,0,1,0};
            int dc[]={0,1,0,-1};
            for(int k=0;k<4;k++){
                int r=i+dr[k];
                int c=j+dc[k];
                if(r>=0 && r<row && c>=0 && c<col && mat[r][c]==1 && !dp[r][c]){
                   solve(r, c, row, col, mat, dp);
                   }
                }
            }
        
        
}

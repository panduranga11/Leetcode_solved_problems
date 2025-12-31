class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
      return bs(row,col,cells);  
    }
    public boolean check(int row,int col,int [][]mat,boolean [][]dp){
        for(int i=0;i<col;i++){
            if(mat[0][i]==0 && !dp[0][i]){
            if(solve(0,i,row,col,mat,dp)){
                return true;
            }
            }
        }
        return false;
    }
    public boolean solve(int  i,int j,int row,int col,int [][]mat,boolean [][]dp){
        dp[i][j]=true;
        if(i==row-1){
            return true;
        }

            int dr[]={-1,0,1,0};
            int dc[]={0,1,0,-1};
            for(int k=0;k<4;k++){
                int r=i+dr[k];
                int c=j+dc[k];
                if(r>=0 && r<row && c>=0 && c<col && mat[r][c]==0 && !dp[r][c]){
                   if (solve(r, c, row, col, mat, dp)) {
    return true;
}
                }
            }
        return false;
        }
        

    
    public int bs(int row,int col,int [][]cells){
        int l=1;
        int r=cells.length;
        int ans=0;
        while(l<=r){
        int mid=(l+r)/2;
        int [][]mat=new int[row][col];
        for(int i=0;i<=mid-1;i++){
            int ro=cells[i][0];
            int c=cells[i][1];
            mat[ro-1][c-1]=1;
        }
        boolean[][] dp = new boolean[row][col];
 if(check(row,col,mat,dp)){
    ans=mid;
    l=mid+1;
 }else{
    r=mid-1;
 }
        }
        return ans;

    }
    }

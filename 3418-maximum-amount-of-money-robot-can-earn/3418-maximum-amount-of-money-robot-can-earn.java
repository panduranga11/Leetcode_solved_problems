class Solution {
    public int maximumAmount(int[][] coins) {
     int m=coins.length;
     int n=coins[0].length;
     int [][][]dp=new int[m][n][3];
     for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            Arrays.fill(dp[i][j],Integer.MIN_VALUE);
        }
     }

     return  solve(0,0,2,coins,dp);


    }
    public int solve(int i,int j,int left,int [][]c,int [][][]dp){
        if(i==c.length-1 && j==c[0].length-1){
         if(c[i][j]<0 && left>0){
            return 0;
         }else{
            return c[i][j];
         }
        }
        if(i>=c.length || j>=c[0].length){
           return -(int)1e8;

        }
        if(dp[i][j][left]!=Integer.MIN_VALUE){
            return dp[i][j][left];
        }
        int val=c[i][j];
        int ans=Integer.MAX_VALUE;
         ans=Math.max(val+solve(i,j+1,left,c,dp),val+solve(i+1,j,left,c,dp));
        if(val<0 && left>0 ){
ans=Math.max(solve(i,j+1,left-1,c,dp),ans);
ans=Math.max(solve(i+1,j,left-1,c,dp),ans);
        }
           
        

         return dp[i][j][left]=ans;
         
         


        
    }
}
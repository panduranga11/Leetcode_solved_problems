class Solution {
    public int numOfWays(int n) {
        int []prev=new int [3];
     int dp[][][][] = new int[n][4][4][4];
     for(int i=0;i<n;i++){
        for(int j=0;j<4;j++){
            for(int k=0;k<4;k++){
                Arrays.fill(dp[i][j][k],-1);
            }
        }
     }

    return solve(0,prev,n,dp);
    }
    public int solve(int ind,int []prev,int n,int [][][][]dp){
    int ans=0;
   if(ind==n){
    return 1;
   }
   if(dp[ind][prev[0]][prev[1]][prev[2]]!=-1){
    return dp[ind][prev[0]][prev[1]][prev[2]];
   }
   for(int c1=1;c1<=3;c1++){
    for(int c2=1;c2<=3;c2++){
        for(int c3=1;c3<=3;c3++){
            if(c1!=c2 && c2!=c3 && c1!=prev[0]&& c2!=prev[1]&& c3!=prev[2]){
                
                int []cur={c1,c2,c3};
                ans =(ans+solve(ind+1,cur,n,dp))%1000000007;
            }
        }
    }
   }
   return dp[ind][prev[0]][prev[1]][prev[2]]=ans%1000000007;
    }
}
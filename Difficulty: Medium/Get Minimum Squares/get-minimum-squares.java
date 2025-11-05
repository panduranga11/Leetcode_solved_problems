class Solution {
    public int minSquares(int n) {
      int dp[]=new int[100001];
       Arrays.fill(dp, -1);
      return count(n,dp);
        
    }
    public int count(int n,int []dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=n;
        for(int i=1;i*i<=n;i++){
            ans=Math.min(ans,1+count(n-i*i,dp));
        }
        return dp[n]=ans;
    }
}
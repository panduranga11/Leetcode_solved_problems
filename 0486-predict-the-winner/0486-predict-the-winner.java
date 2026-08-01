class Solution {
    public boolean predictTheWinner(int[] nums) {
        
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
       
        int val=solve(0,n-1,nums,dp);
       
        return val>=0;
     
    }
    public int solve(int i,int j,int []nums,int [][]dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int pi=nums[i]-solve(i+1,j,nums,dp);
        int pj=nums[j]-solve(i,j-1,nums,dp);
        return dp[i][j]=Math.max(pi,pj);
    }
}

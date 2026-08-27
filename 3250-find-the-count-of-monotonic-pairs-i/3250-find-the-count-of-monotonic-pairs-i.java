class Solution {
    public int countOfPairs(int[] nums) {
        int n=nums.length;
        int dp[][][]=new int [n][52][52];
        for(int i=0;i<n;i++){
            for(int j=0;j<52;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

      return solve(0,nums,-1,-1,dp);  
    }
    public int solve (int ind,int []nums,int p1,int p2,int [][][]dp){
        if(ind >=nums.length){
            return 1;
        }
        if(dp[ind][p1+1][p2+1]!=-1){
            return dp[ind][p1+1][p2+1];
        }
        
        int ans=0;
        for(int i=0;i<=nums[ind];i++){
            int t1=i;
            int t2=nums[ind]-i;
            if((p1==-1 && p2==-1) ||(t1>=p1 && t2 <=p2)){
ans=(ans+solve(ind+1,nums,t1,t2,dp))%1000000007;

            }
        }
        return dp[ind][p1+1][p2+1]=ans%1000000007;
    }
}
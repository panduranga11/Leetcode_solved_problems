class Solution {
    public int len(int []nums,int ind,int prev,int [][]dp){
        if(ind==nums.length){
            return 0;
        }
        if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }
        int include=0;
        int notinclude=0;
        if(prev==-1 || nums[ind]>nums[prev]){
            include= 1+len(nums,ind+1,ind,dp);
        }
        notinclude= len(nums,ind+1,prev,dp);
        
        return dp[ind][prev+1]=Math.max(include,notinclude);
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length][nums.length+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return len(nums,0,-1,dp);
        
    }
}
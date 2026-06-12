class Solution {
    public int maxCoins(int[] nums) {
int n=nums.length;

        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0, nums.length - 1, nums,dp);
    }

    public int solve(int i, int j, int[] nums,int [][]dp) {

        if (i > j) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int curmax = 0;
        for (int st = i; st <= j; st++) {
            int l = 1;
            int r = 1;

            if (i-1>=0) {
                l = nums[i-1];
            }
            if (j+1<nums.length) {
                r = nums[j+1];
            }

            int val = l * nums[st] * r;
            curmax = Math.max(curmax, val + solve(i, st - 1, nums,dp) + solve(st + 1, j, nums,dp));
        }

        return dp[i][j]=curmax;
    }
}
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
      return solve(0,k,arr,dp);  
    }
    public int solve(int ind ,int k,int []arr,int []dp){
        if(ind>=arr.length){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int maxsum=0;
        int max=arr[ind];
        for(int i=ind;i<Math.min(ind+k,arr.length);i++){
            max=Math.max(arr[i],max);
            maxsum=Math.max(maxsum, max*(i-ind+1)+solve(i+1,k,arr,dp));

        }
        return dp[ind]=maxsum;
    }
}
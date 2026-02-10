class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxLen = 1;
        int l=0;
        for(int r=0;r<n;r++){
            while(1L*nums[l]*k<nums[r]){
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);

        }
        return n-maxLen;

    }
}
//TRIED DP BUT MEOMORY LIMIT EXCEEDED!!!!!!!
// class Solution {
//     public int minRemoval(int[] nums, int k) {
//         int n=nums.length;
//         Arrays.sort(nums);
//         int dp[][]=new int[n][n];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i],-1);
//         }
//        return removals(0,n-1,nums,k,dp);
       
//     }
//     public int removals(int i,int j,int []nums,int k,int [][]dp){
//         if(i>j){
//             return Integer.MAX_VALUE;
//         }
//         if(1L*nums[i]*k>=nums[j]){
//             return i+nums.length-j-1;
//         }
//         if(dp[i][j] != -1) return dp[i][j];

//         return dp[i][j]= Math.min(removals(i+1,j,nums,k,dp),removals(i,j-1,nums,k,dp));

//     }
// }

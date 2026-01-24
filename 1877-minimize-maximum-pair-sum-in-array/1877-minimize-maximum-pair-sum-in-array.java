class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
      
       int n=nums.length;
        int ans=nums[0]+nums[n-1];
        for(int i=0;i<n/2;i++){
            int sum=nums[i]+nums[n-1-i];
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}
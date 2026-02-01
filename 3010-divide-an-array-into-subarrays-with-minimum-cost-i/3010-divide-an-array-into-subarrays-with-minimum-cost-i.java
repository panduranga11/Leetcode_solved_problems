class Solution {
    public int minimumCost(int[] nums) {
       int n=nums.length;
       int sum=nums[0];
       nums[0]=100;
       Arrays.sort(nums);
       
        sum+=(nums[0]+nums[1]);
        return sum;
      
    }
}
class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n=nums.length;
        int c=0;
        for(int i=n-1;i>0;i--){
            if(nums[i]<nums[i-1]){
                nums[i-1]=nums[i]+nums[i-1];
                c++;
            }

        }
        return c;
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum=Integer.MIN_VALUE;
        int sum=0;
       
        for(int i=0;i<nums.length;i++){
           if(sum+nums[i]>nums[i]){
            sum+=nums[i];
           }else{
            sum=nums[i];
            
           }
           max_sum=Math.max(max_sum,sum);

        }
        return max_sum;
        
    }
}
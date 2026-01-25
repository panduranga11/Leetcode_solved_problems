class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
      Arrays.sort(nums);
      
    
    int diff=Integer.MAX_VALUE;

   
    for(int i=0;i<=n-k;i++){
        int max=nums[i];
        int min=nums[i];
        for(int j=i;j<i+k;j++){
            min=Math.min(min,nums[j]);
            max=Math.max(max,nums[j]);
            
        }
        diff=Math.min(diff,max-min);
    }
    return diff;
} 
}
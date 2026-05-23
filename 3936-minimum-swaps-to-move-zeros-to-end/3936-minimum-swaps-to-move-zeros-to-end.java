class Solution {
    public int minimumSwaps(int[] nums) {
       int co=0;
       int n=nums.length;
       for(int i:nums){
        if(i==0){
            co++;
        }
       } 
       
       int i=n-1;
       int ans=0;
       while(co>0){
        
if(nums[i]!=0){
ans++;
}
co--;
i--;
       }
       return ans;
    }
}
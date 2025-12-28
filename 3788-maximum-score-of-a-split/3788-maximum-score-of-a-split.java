class Solution {
    public long maximumScore(int[] nums) {
        int n=nums.length;
        
        long pre[]=new long[n];
        long suf[]=new long[n];
      
        pre[0]=nums[0];
        suf[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
            suf[n-1-i]=Math.min(suf[n-1-i+1],nums[n-1-i]);
           
            
            
        }
        long ans=Long.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            ans=Math.max(ans,pre[i]-suf[i+1]);
            
            
            
        }
        return ans;
       
       
    }
}
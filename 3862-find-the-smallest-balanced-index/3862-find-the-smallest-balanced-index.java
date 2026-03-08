class Solution {
    public int smallestBalancedIndex(int[] nums) {
      
        int n=nums.length;
        double log[]=new double[n];
        log[0]=Math.log(nums[0]);
        for(int i=1;i<n;i++){
            log[i]=log[i-1]+Math.log(nums[i]);
            
        }
        double presum=0;
        if(n==1){
            return -1;
        }
        if(n==2){
            if(nums[0]==1){
                return 1;
            }else{
                return -1;
            }
            
                
            }
        
        
        
        for(int i=0;i<n;i++){
            double left=Double.MAX_VALUE;
            double right=0;
            if(i!=0 ){
                left=Math.log(presum);
            }
            if(i!=n-1){
                right=log[n-1]-log[i];
            }
            if(Math.abs(left-right)<1e-9){
                return i;
            }
            presum+=nums[i];
            
        }
        return -1;
    }
}
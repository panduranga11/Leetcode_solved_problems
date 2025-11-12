class Solution {
    public int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}

    public int minOperations(int[] nums) {
        int n=nums.length;
       int g=nums[0];
        int count1=0;
        for(int i=0;i<n;i++){
           g=gcd(g,nums[i]);
           if(nums[i]!=1){
        count1++;
           }
        }
        int min=Integer.MAX_VALUE;

        if(g==1 && count1==n){
        for(int i=0;i<n;i++){
            int gd=nums[i];
        for(int j=i+1;j<n;j++){
            gd=gcd(gd,nums[j]);
            if(gd==1){
                min=Math.min(min,j-i+1);
            }
        }
        }
        return (count1-1)+(min-1);
        } 
        if(g==1){
            return count1;
        }else{
            return -1;
        }
            
}
}
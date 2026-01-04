class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int ans=0;

        for(int i=0;i<n;i++){
ans+=sum(nums[i]);
        }
        return ans;
    }
    public int sum(int k){
       int count =0;
       int sum=0;
       for(int i=1;i*i<=k;i++){
         if(k%i==0){
           if(i*i==k){
             count++;
             sum+=i;
}else{
    count+=2;
    sum+=(i+k/i);
   
}
         }
       }
if(count>4){
    return 0;
}

return count==4? sum:0;
       

    

}
    }
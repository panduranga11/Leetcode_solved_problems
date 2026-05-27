class Solution {
    public int minOperations(int[] nums, int k) {
      int n=nums.length;
      int ans=Integer.MAX_VALUE;
      
      for(int x=0;x<k;x++){
        for(int y=0;y<k;y++){
        if(x==y){
            continue;
        }
        int t1=0;
        int t2=0;
        
   
for(int i=0;i<n;i++){
    int rem=nums[i]%k;
    if(i%2==0){
t1+=Math.min((x-rem+k)%k,(rem-x+k)%k);
    }else{

t2+=Math.min((y-rem+k)%k,(rem-y+k)%k);
    }
}

 ans=Math.min(ans,t1+t2);
        }
       
      }
      
        
        
    return ans; 
    }
}
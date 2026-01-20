class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
       int ans[]=new int[n];
       for(int i=0;i<n;i++){
        int ele=nums.get(i);
        if(ele==2){
            ans[i]=-1;
        }else{
            int k=0;
            
            
            while(k<31 && (ele &(1<<k))!=0){
k++;
            }
            int m=~(1<<(k-1));
            int x=ele &(m);
            System.out.println(x);
            ans[i]=x;
            
        }

       } 
      return ans;
    }
}
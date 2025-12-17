class Solution {
    public long getDescentPeriods(int[] prices) {
      int l=0;
      int n=prices.length;
      if(n==1){
        return 1;
      }
      int r=1;
      long ans=0;
      while(r<n){
        if(prices[r]!=prices[r-1]-1){
            int k=r-l;
            long m=1L*k*(k+1)/2;
            ans+=m;
            l=r;
            
        }
        r++;
      }
      int k=r-l;
      long m=1L*k*(k+1)/2;
      ans+=m;
        
      return ans; 
    }
}
class Solution {
    public int countKthRoots(int l, int r, int k) {
       int ans=0;
       if(k==1){
        return r-l+1;
       }
    
       int st=(int)Math.pow(l,1.0/k);
       while((long)Math.pow(st,k)<=1L*r){
        if((long)Math.pow(st,k)>=l){
        ans++;
        }
        st++;
       }
        
        return ans;
    }
}
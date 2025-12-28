class Solution {
    public long minimumCost(int c1, int c2, int cb, int n1, int n2) {

        long ans = Long.MAX_VALUE;
        int n = Math.min(n1, n2);
        
        if(cb>=c1+c2){
            ans=Math.min(ans,1L*c1*n1+1L*c2*n2);
            
        }

        Long cal=1L*cb*n;
      
           
            int k1 = n1 -n ;
            int k2 = n2 - n;
            
if(k2<k1){
    int ex=k1-k2;

    
    
    cal+=Math.min(1L*cb*ex,1L*k1*c1);

}else{
    int ex=k2-k1;
    cal+=Math.min(1L*cb*ex,1L*k2*c2);
}

           

            ans = Math.min(ans, cal);
        
        return ans;
    }
}

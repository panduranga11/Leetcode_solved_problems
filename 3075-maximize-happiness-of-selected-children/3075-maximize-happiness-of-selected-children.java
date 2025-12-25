class Solution {

    public long maximumHappinessSum(int[] h, int k) {
        
        int fac=0;
        Arrays.sort(h);
        int n=h.length;
        long ans=0;
        for(int i=0;i<k;i++){
            if(h[n-1-i]-fac<0){
                return ans;
            }else{
                ans+=(h[n-1-i]-fac);
                fac++;
            }

        }
        return ans;
    }
}


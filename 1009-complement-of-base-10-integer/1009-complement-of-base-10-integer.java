class Solution {
    public int bitwiseComplement(int n) {
        int ans=0;
        int ind=0;
        if(n==0){
            return 1;
        }
       
        while(n>0){
            int bit=n&1;
            int p=bit==0?1:0;
            n=n>>1;
            ans=ans |(p<<ind);
            ind++;

            
        }
        return ans;
    }
}
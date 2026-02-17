class Solution {
    public int reverseBits(int n) {
        int  k=0;
        for(int i=0;i<32;i++){
            k=k<<1;
            int m=(1&n);
            n=n>>1;
            k=k|m;
            

        }
        return k;
        
    }
}
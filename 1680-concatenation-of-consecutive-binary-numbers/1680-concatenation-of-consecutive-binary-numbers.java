class Solution {
    public int concatenatedBinary(int n) {
        long res=0;
        int bit=0;
     for(int i=1;i<=n;i++){
        
       if((i&(i-1))==0){
        bit++;
       }
        res=((res<<bit) |i)%1000000007;


     }
     return (int)res;
    }
}
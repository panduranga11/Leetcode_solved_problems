class Solution {
    public int rev(int n){
       String ans="";
        while(n>0){
           int d=n%10;
            ans+=d;
            
            
            n=n/10;
        }
        
        return Integer.parseInt(ans);
    }
    public int mirrorDistance(int n) {
        return Math.abs(n-rev(n));
    }
}
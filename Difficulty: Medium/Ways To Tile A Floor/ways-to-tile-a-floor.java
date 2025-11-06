class Solution {
    public int numberOfWays(int n) {
        if(n<=3){
            return n;
        }
        int prev1=2;
        int prev2=1;
        for(int i=3;i<=n;i++){
            int cur=prev1+prev2;
            prev2=prev1;
            prev1=cur;
            
        }
        return prev1;
    }
};
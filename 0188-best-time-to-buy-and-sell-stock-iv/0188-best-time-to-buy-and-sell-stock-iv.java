class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][]=new int [prices.length][2][k+1];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
       return stock(0,1,0,k,prices,dp); 
    }
    public int stock(int ind,int flag,int co,int k,int [] prices,int [][][]dp){
        if(ind==prices.length){
        return 0;
        }
        if(dp[ind][flag][co]!=-1){
            return dp[ind][flag][co];
        }
       int profit=0;
       if(flag==1 && co<k ){
          profit+=Math.max(-prices[ind]+stock(ind+1,0,co,k,prices,dp),stock(ind+1,1,co,k,prices,dp));
       }
       if(flag==0 && co<k){
        profit+=Math.max(prices[ind]+stock(ind+1,1,co+1,k,prices,dp),stock(ind+1,0,co,k,prices,dp));
       }
       return dp[ind][flag][co]= profit;

    }
}
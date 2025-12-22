class Solution {
    public long profit(int []p,int ind,int  flag,int count,long [][][]dp){
        if(count>=2){
            return 0;
        }
       if(ind==p.length){
        return 0;

       }
       if(dp[ind][flag][count]!=-1){
        return dp[ind][flag][count];
       }
        
       long maxp=0;
       if(flag!=0 && count <2){
        maxp=Math.max(0+profit(p,ind+1,1,count,dp),-p[ind]+profit(p,ind+1,0,count,dp));
       }else{
       maxp=Math.max(0+profit(p,ind+1,0,count,dp),+p[ind]+profit(p,ind+1,1,count+1,dp));
       }
       return dp[ind][flag][count]=maxp;
    }
    public int maxProfit(int[] prices) {
        long dp[][][] =new long[prices.length][2][2];
        
for (int i = 0; i < prices.length; i++) {
    for (int j = 0; j < 2; j++) {
        Arrays.fill(dp[i][j], -1);
    }
}
        return (int)profit(prices,0,1,0,dp);
    }
}
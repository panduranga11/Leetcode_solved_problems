class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        int fcount []=new int [n];
        int min=items[0][1];
         for(int i=0;i<n;i++){
            min=Math.min(min,items[i][1]);
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(items[j][0]%items[i][0]==0){
                    fcount[i]++;
                }
            }
            fcount[i]++;

            
        }
        int dp[][]=new int[n+1][budget+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return ks(0,budget,items,min,dp,fcount);
        

    }
    public int ks(int ind,int rem,int [][]wt,int min,int [][]dp,int []pro){
        if(ind>=wt.length){
            return rem/min;
        }
        if(dp[ind][rem]!=-1){
            return dp[ind][rem];
        }
        int take=0;
        if(wt[ind][1]<=rem){
            take=Math.max(ks(ind+1,rem,wt,min,dp,pro),pro[ind]+ks(ind+1,rem-wt[ind][1],wt,min,dp,pro));
        }
        int nt=ks(ind+1,rem,wt,min,dp,pro);
        return dp[ind][rem]=Math.max(take,nt);
    }
}
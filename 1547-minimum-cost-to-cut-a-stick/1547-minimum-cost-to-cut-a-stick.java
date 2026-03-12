class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int arr[]=new int [m+2];
        arr[0]=0;
        arr[arr.length-1]=n;
       for(int i=0; i<m;i++){
            arr[i+1]= cuts[i];
        }
        int dp[][]=new int[102][102];
        for(int i=0;i<102;i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(arr);
        return solve(1,arr.length-2,arr,n,dp);
    }
    public int solve(int i,int j,int []cuts,int n,int [][]dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int mincost=Integer.MAX_VALUE;
        for(int st=i;st<=j;st++){
          int cost=cuts[j+1]-cuts[i-1]+solve(i,st-1,cuts,n,dp)+solve(st+1,j,cuts,n,dp);
        //   System.out.println(cost); 
          mincost=Math.min(mincost,cost);
        }
        return dp[i][j]=mincost;
        
    }
}
class Solution {
    public int minCut(String s) {
        char c[]=s.toCharArray();
        int n=c.length;

        int []dp=new int[n];
        Arrays.fill(dp,-1);

        boolean pal[][]=new boolean[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(c[i]==c[j] && (j-i<=1 || pal[i+1][j-1])){
                    pal[i][j]=true;
                }
            }
        }

        return solve(n-1,c,dp,pal);
    }

    public int solve(int j,char []c,int []dp,boolean [][]pal){
        if(j<0){
            return -1;
        }

        if(dp[j]!=-1){
            return dp[j];
        }

        int min=Integer.MAX_VALUE;

        for(int ind=0;ind<=j;ind++){
            if(pal[ind][j]){
                min=Math.min(min,1+solve(ind-1,c,dp,pal));
            }
        }

        return dp[j]=min;
    }
}
class Solution {
    public int findIntegers(int n) {
        String s=Integer.toBinaryString(n);
        // System.out.println(s);
        int dp[][][]=new int [2][s.length()+1][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<s.length()+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        return solve(1,0,0,s,dp);
    }
    public int solve(int t,int ind,int  prev,String s,int [][][]dp){
        if(ind==s.length()){
            return 1;
        }
        if(dp[t][ind][prev]!=-1){
            return dp[t][ind][prev];
        }
        int ans=0;
        int end=t==1?s.charAt(ind)-'0':1;
        for(int i=0;i<=end;i++){
            int nt=t==1 && i==end?1:0;
            if(prev==1){
                if(i==0){
                ans+=solve(nt,ind+1,i,s,dp);
                }else{
                    continue;
                }
                
            }else{
                ans+=solve(nt,ind+1,i,s,dp);
            }
        }
        return dp[t][ind][prev]=ans;

    }
}
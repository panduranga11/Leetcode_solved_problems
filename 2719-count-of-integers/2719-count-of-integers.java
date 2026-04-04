class Solution {
    public int count(String num1, String num2, int min_sum, int max_sum) {
        while(num1.length()<num2.length()){
            num1='0'+num1;
        }
        char [] c1=num1.toCharArray();
        char [] c2=num2.toCharArray();
        int dp[][][][]=new int [23][401][2][2];
        for(int i=0;i<23;i++){
            for(int j=0;j<401;j++){
                for(int k=0;k<2;k++){
                    Arrays.fill(dp[i][j][k],-1);
                }
            }
        }
     return solve(0,c1,c2,0,1,1,min_sum,max_sum,dp);   
    }
    public int solve(int ind,char c1[],char c2[],int sum,int t1,int t2,int min_sum,int max_sum,int [][][][]dp){
        if(ind==Math.max(c1.length,c2.length)){
            return sum>=min_sum?1:0;
        }
        if(dp[ind][sum][t1][t2]!=-1){
            return dp[ind][sum][t1][t2];
        }
        int ans=0;
        int st=(ind<c1.length && t1==1)?c1[ind]-'0':0;
        int end=(t2==1)?c2[ind]-'0':9;
        
        for(int i=st;i<=end;i++){
            int nt1=(t1==1) && i==st?1:0;
            int nt2=(t2==1) && i==end?1:0;
       int  nsum=sum+i;
        if(nsum<=max_sum){
            ans=(ans+solve(ind+1,c1,c2,nsum,nt1,nt2,min_sum,max_sum,dp)%1000000007)%1000000007;
        }
        }
        return dp[ind][sum][t1][t2]=ans;

    }
}
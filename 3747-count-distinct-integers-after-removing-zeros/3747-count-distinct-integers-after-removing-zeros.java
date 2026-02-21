class Solution {
    

    public long countDistinct(long n) {
       char [] ch=Long.toString(n).toCharArray();
       int l=ch.length;
       long dp[][][]=new long[l][2][2];
       
       for(int i = 0; i < l; i++){
      for(int j = 0; j < 2; j++){
        Arrays.fill(dp[i][j], -1);
    }
}
       return rec(0,0,1,ch,dp) ;
      
    }
    public long rec(int ind,int st,int ti,char []ch,long [][][]dp){
       if(ind==ch.length){
        return st;
       }
       if(dp[ind][st][ti]!=-1){
        return dp[ind][st][ti];
       }
       long ans=0;
       int end=ti==1?ch[ind]-'0':9;
       for(int i=0;i<=end;i++){
        if(i==0){
            if(st==0){
            ans+=rec(ind+1,0,(ti==1 &&i==end)?1:0,ch,dp);
            }
        }else{
            ans+=rec(ind+1,1,(ti==1 &&i==end)?1:0,ch,dp);

        }
       }
       return dp[ind][st][ti] =ans;
       
    }
}
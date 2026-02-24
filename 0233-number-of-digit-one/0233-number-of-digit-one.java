class Solution {
    public int countDigitOne(int n) {
     
    

       char [] ch=Long.toString(n).toCharArray();
       int l=ch.length;
       int dp[][]=new int[l][2];
       
       for(int i = 0; i < l; i++){
    
        Arrays.fill(dp[i], -1);}

       return rec(0,0,1,ch,dp,0) ;
    }
    
    public int rec(int ind,int st,int ti,char []ch,int [][]dp,int count){
       if(ind==ch.length){
        return count ;
       }
       if(dp[ind][ti]!=-1){
        return dp[ind][ti];
       }
       int ans=0;
       int end=ti==1?ch[ind]-'0':9;
       for(int i=0;i<=end;i++){
       
       
            ans+=rec(ind+1,1,(ti==1 &&i==end)?1:0,ch,dp,i==1?count+1:count);

        
       }
       return dp[ind][ti] =ans;
       
   
        
    }
}
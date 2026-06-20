class Solution {
    public long goodIntegers(long l, long r, int k) {
        String s1=Long.toString(l);
        String s2=Long.toString(r);
        while(s1.length()<s2.length()){
            s1="0"+s1;

        }
        long dp[][][][]=new long[17][2][2][11];
        for(int i=0;i<17;i++){
            for(int j=0;j<2;j++){
                for(int o=0;o<2;o++){
                    //System.out.println(i+" "+j+" "+o);
                    Arrays.fill(dp[i][j][o],-1);
                }
            }
        }
        return solve(0,s1,s2,1,1,10,k,dp);

       
    }
    public long solve(int ind,String s1,String s2 ,int t1,int t2,int prev,int k,long [][][][]dp){
        if(ind==s2.length()){
          return 1;
        }
        if(dp[ind][t1][t2][prev]!=-1){
            return dp[ind][t1][t2][prev];
        }
        long ans=0;
        
        int st=t1==1?s1.charAt(ind)-'0':0;
        int end=t2==1?s2.charAt(ind)-'0':9;
        
        for(int i=st;i<=end;i++){
           
            int nt1=(t1==1 && i==st)?1:0;
            int nt2=(t2==1 && i==end)?1:0;
            if(prev==10){
                if(i==0){
                    ans+=solve(ind+1,s1,s2,nt1,nt2,10,k,dp);
                }else{
                    ans+=solve(ind+1,s1,s2,nt1,nt2,i,k,dp);
                }
            }else{
                if(Math.abs(prev-i)<=k){
                    ans+=solve(ind+1,s1,s2,nt1,nt2,i,k,dp);
                }
            }

        }
        return dp[ind][t1][t2][prev]=ans;

    }
}
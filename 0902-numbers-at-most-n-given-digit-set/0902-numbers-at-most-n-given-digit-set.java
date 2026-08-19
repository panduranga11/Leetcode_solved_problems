class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        HashSet<Integer>set=new HashSet<>();
        int max=-1;
        for(String i:digits){
            int k=Integer.parseInt(i);
            set.add(k);
max=Math.max(max,k);
        }
        
        char c []=Integer.toString(n).toCharArray();
        int dp[][][]=new int [c.length][2][2];
       for(int i=0;i<c.length;i++){
        for(int j=0;j<2;j++){
            Arrays.fill(dp[i][j],-1);
        }
       }

      return solve(0,1,set,c,max,0,dp);

    }
    public int solve (int ind ,int t,HashSet<Integer>set,char []c,int max,int std,int [][][]dp){
        if(ind>=c.length){
            if(std==1){
            return 1;
            }else{
                return  0;
            }
        }
        if(dp[ind][std][t]!=-1){
            return dp[ind][std][t];
        }
        int ans=0;
      

        int end=t==1?c[ind]-'0':9;
        //System.out.println(end);
        for(int i=0;i<=end;i++){
              if(i==0 && std==0){
            ans+=solve(ind+1,0,set,c,max,std,dp);
        }else{
            if(set.contains(i) && i<=max ){
            int nt=t==1 && i==end ?1:0;
            //System.out.println("ind "+ind+" :"+i);
ans+=solve(ind+1,nt,set,c,max,1,dp);
        }
    }
        }
    return dp[ind][std][t]=ans;
}
}
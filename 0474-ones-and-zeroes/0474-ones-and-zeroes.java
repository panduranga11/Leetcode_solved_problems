class Solution {
    public static int[] count(String s){
        
        int ones=0;
        int zeroes=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='0'){
                zeroes++;
            }else{
                ones++;
            }
        }
        return new int[]{zeroes,ones};
    }
    public static int largest(String []strs,int ind,int m,int n,int [][][]dp){
        if(m<0 || n<0){
            return Integer.MIN_VALUE;
        }
        if(ind==strs.length){
            return 0;
        }
        if(dp[ind][m][n]!=-1){
            return dp[ind][m][n];
        }
        int pick=0;
        int arr[]=count(strs[ind]);

        if(m>=arr[0] && n>=arr[1]){
            pick=1+largest(strs,ind+1,m-arr[0],n-arr[1],dp);
        }
        int notpick=largest(strs,ind+1,m,n,dp);
        
        return dp[ind][m][n]= Math.max(pick,notpick);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int [][][]dp=new int[strs.length][m+1][n+1];
      for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
      return largest(strs,0,m,n,dp);  
}
}
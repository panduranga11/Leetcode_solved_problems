class Solution {
   
    public int maxProfit(int[] p) {
        int n=p.length;
  
     int next[]=new int[2];
        
        for(int i=n-1;i>=0;i--){
            int cur[]=new int[2];
            for(int j=0;j<=1;j++){
                int profit=0;
                if(j==1){
            profit=Math.max(-p[i]+next[0],next[1]);
        }else{
            profit=Math.max(+p[i]+next[1],next[0]);

        }
        cur[j]=profit;
            }
            next=Arrays.copyOf(cur,cur.length);
        }
        
        return next[1];
        
    }
}
class Solution {
    public long minCost(String s, int[] cost) {
        long minc=Long.MAX_VALUE;
        boolean vis[]=new boolean[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(!vis[c-'a']){
            vis[c-'a']=true;
                 long m=0;
            for(int j=0;j<n;j++){
               
                if(s.charAt(j)!=c){
                m+=cost[j];
                }
            }
                minc=Math.min(minc,m);
            }
            
        }
        return minc;
    }
}
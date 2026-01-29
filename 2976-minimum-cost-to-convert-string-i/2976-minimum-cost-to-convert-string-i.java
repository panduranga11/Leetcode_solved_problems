class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long [][]build=new long[26][26];
        
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j){
                    build[i][j]=0;
                }else{
                    build[i][j]=Integer.MAX_VALUE;
                }
            }
        }
    int n=original.length;
    for(int i=0;i<n;i++){
        int row=original[i]-'a';
        int col=changed[i]-'a';
        // System.out.println(row+" "+col);
        int val=cost[i];
        // System.out.println(val);
      build[row][col]= Math.min(build[row][col],val);
     // System.out.println("row "+row+" col "+col+"is "+ build[row][col]);

    }
    // for(long []k:build){
    //     System.out.println(Arrays.toString(k));
    // }
   
floydWarshall(build,26);
    long ans=0;
    for(int i=0;i<source.length();i++){
        char c1=source.charAt(i);
        char c2=target.charAt(i);
        // System.out.println(c1-'a'+"  "+c2-'a');
        if(build[c1-'a'][c2-'a']==Integer.MAX_VALUE){
            return -1;
        }else{
            ans+=build[c1-'a'][c2-'a'];
        }

    }
    return ans;
    
    
        
    }
     public  void floydWarshall(long[][] dist, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] == Integer.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
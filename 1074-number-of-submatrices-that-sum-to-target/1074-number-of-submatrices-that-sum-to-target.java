class Solution {
    public int numSubmatrixSumTarget(int[][] mat, int x) {
       int m=mat.length;
       int n=mat[0].length;
       int pre[][]=new int[m][n];
       for(int i=0;i<m;i++){
           int sum=0;
           for(int j=0;j<n;j++){
               sum+=mat[i][j];
               pre[i][j]=sum;
               
           }
       }
       int ans=0;
       
       for(int stcol=0;stcol<n;stcol++){
        for(int j=stcol;j<n;j++){
           HashMap<Integer,Integer>map=new HashMap<>();
           map.put(0,1);
           int sum=0;
           for(int i=0;i<m;i++){
            int rem=(stcol>0)?pre[i][stcol-1]:0;
               sum+=pre[i][j]-rem;
               int diff=sum-x;
               if(map.containsKey(diff)){
                   ans+=map.get(diff);
               }
               map.put(sum,map.getOrDefault(sum,0)+1);
               
               
           }
       }
       }
       return ans;
    }
}
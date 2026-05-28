class Solution {
     
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
      int par[]=new int[n+1];
      for(int i = 1; i <= n; i++){
    par[i] = i;
}
      int rank[]=new int[n+1];
     
      
        int ans[]=new int [2];
        for(int i=0;i<n;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            if(find(a,par)==find(b,par)){
               ans[0]=a;
               ans[1]=b;

            }else{
                union(a,b,par,rank);
            }
        }
        return ans;
       

    }
    public int find(int v,int []par){
        if(par[v]==v){
            return v;
        }
        return find(par[v],par);
    }
    public void union (int a,int b,int []par,int []rank){
int p1=find(a,par);
int p2=find(b,par);
if(rank[p1]==rank[p2]){
    par[p2]=p1;
    rank[p1]++;

}else if(rank[p1]>rank[p2]){
par[p2]=p1;
}else{
par[p1]=p2;
}
    }
}
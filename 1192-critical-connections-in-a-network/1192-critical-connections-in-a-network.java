class Solution {
    int t=0;
    int count=0;
     List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
     
      int dis[]=new int [n];
      int low[]=new int [n];
      boolean []vis=new boolean[n];
      List<List<Integer>>adj=new ArrayList<>();
      for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
      }
      for(int i=0;i<connections.size();i++){
        int u=connections.get(i).get(0);
        int v=connections.get(i).get(1);
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      //System.out.println(adj);
      for(int i=0;i<n;i++){
        if(!vis[i]){
            dfs(i,-1,dis,low,adj,vis);
        }
      }
      return ans;

    }
    public void dfs(int node,int par,int []dis,int low[],List<List<Integer>>adj,boolean vis[]){
        vis[node]=true;
        dis[node]=t++;
        low[node]=dis[node];
        for(int a:adj.get(node)){
            if(a==par){
                continue;
            }
            if(vis[a]){
                low[node]=Math.min(low[node],dis[a]);
            }else{
                dfs(a,node,dis,low,adj,vis);
                low[node]=Math.min(low[node],low[a]);

            }
        }
        if(par!=-1 && low[node]>dis[par]){
ans.add(new ArrayList<>(Arrays.asList(par,node)));
        }

    }
}
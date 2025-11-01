class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] pr) {
      List<List<Integer>> adj=new ArrayList<>();
      ArrayList<Integer>ans =new ArrayList<>();
      for(int i=0;i<n;i++){
          adj.add(new ArrayList<>());
      }
      for(int i=0;i<pr.length;i++){
          adj.get(pr[i][0]).add(pr[i][1]);
      }
      int vis[]=new int [n];
      for(int i=0;i<n;i++){
          if(vis[i]!=1){
              dfs(i,vis,adj,ans);
          }
      }
      return ans;
      
      
    
        
    }
    public void dfs(int i,int []vis,List<List<Integer>> adj,ArrayList<Integer>ans){
        vis[i]=1;
        for(int k:adj.get(i)){
            if(vis[k]!=1){
                dfs(k,vis,adj,ans);
            }
        }
        ans.add(i);
        
        
    }
}
class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
            for(int i=0;i<edges.length;i++){
                int u=edges[i][0];
                int v=edges[i][1];
                adj.get(u).add(v);
            }
        
        Stack<Integer>st=new Stack<>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,st,vis);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!st.isEmpty()){
            int ele=st.pop();
            ans.add(ele);
        }
        return ans;
        
    }
    public static void dfs(int i,List<List<Integer>>adj,Stack<Integer> st,boolean vis[]){
        vis[i]=true;
        for(Integer n:adj.get(i)){
            if(!vis[n]){
                dfs(n,adj,st,vis);
            }
        }
        st.push(i);
    }
}